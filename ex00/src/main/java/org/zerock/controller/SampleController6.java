package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.vo.SampleVO;

@RestController  /*
				 스프링4.0 버전 이후부터는 @RestController 어노테이션으로 JSP뷰페이지를 만들지 않고도, rest방식의 데이터 처리를 위해서 사용한다. 
				 만들어지는 데이터 객체는 문자열,JSON,XML 이다.
				 */
@RequestMapping("/sample") //컨트롤러 자체에 매핑주소 sample등록
public class SampleController6 {

	@RequestMapping("/hello") //get or post 처리가능
	// hello매핑주소 등록
	public String hello() {
		return "REST START";
	}//hello() => 문자열 객체를 반환.
	
	@GetMapping("/sendVO") //GET으로 접근하는 매핑주소 처리. 브라우저 주소창에 sendVO.json을 입력하면 원하는 JSON 데이터 키, 값을 확인할 수 있다.
	public SampleVO sendVO() {
		//리턴타입이 SampleVO 이면 변수명이 json데이터의 키이름이 된다.
		SampleVO vo = new SampleVO();
		vo.setFirstName("이");
		vo.setLastName("순신");
		vo.setMno(10);
		
	
		return vo;
	}//sendVO
	
	@RequestMapping("/sendList") //sendList.json으로 JSON데이터 확인
	public List<SampleVO> sendList(){
		List<SampleVO> list = new ArrayList<>(); //업캐스팅 : 참조타입간의 형변환
		/*
		java.util.List 인터페이스 컬렉션 자료구조 특징
		1. 가변적인 복수개의 데이터를 저장한다.
		2. 복수개의 원소값을 순서있게 저장한다. (중복원소값을 허용한다.)
		3. JDK 1.5부터는 <SampleVO>라는 컬렉션 제네릭타입이 추가되어서 지정된 SampleVO타입만 저장가능하다.
		4. JDK 1.7부터는 <> 제네릭타입은 생략가능하다.
		 */
		for(int i=1; i<=10; i++) {
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName("세종");
			vo.setLastName("대왕님");
			
			list.add(vo); //컬렉션에 추가
		}//for
		return list;
		
	}//sendList()
	
	//키, 값 쌍의 Map타입 JSON
	@GetMapping("/sendMap") //sendMap.json으로 JSON데이터를 확인
	public Map<Integer,SampleVO> sendMap(){
		Map<Integer,SampleVO> map = new HashMap<>(); //업캐스팅 : 참조타입간의 형변환
		/*
		<java.util패키지의 Map컬렉션 인터페이스 자료구조 특징>
		1. 키,값 쌍으로 가변적인 복수개의 데이터를 저장
		2. 키를 통해서 값을 검색하는 사전적인 자료구조로서 검색속도가 빠르다.
		3. 중복키는 없고, 중복값은 존재한다.
		 */
		for(int i=1; i<=10; i++) {
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName("홍");
			vo.setLastName("길동");
			map.put(i,vo); //해쉬맵 컬렉션에 키,값을 저장
		}
		return map;
	}//sendMap()
	
	@RequestMapping("/sendError")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		/*
		 1.@RestController 는 별도의 jsp파일을 만들지 않고도 Rest서비스를 실행하기 때문에 결과데이터에 예외적인 문제가 발생 할 수 있다. 
		 스프링에서 제공하는 ResponseEntity 타입은 개발자가 문제가되는 나쁜상태 404, 500 같은 Http나쁜상태코드를 
		 데이터와 함께 전송할 수 있기 때문에 좀 더 세밀한 제어가 필요한 경우 사용해 볼 수 있다.
		 BAD_REQUEST는 400나쁜상태코드가 전송된다. 
		 200상태코드가 전송되면 정상적으로 데이터가 수행성공했다는 뜻이다.
		 */
	}
	
	//정상적인 json데이터와 404(자원을 찾지 못했을때) 나쁜 상태코드를 함께 전송
	@RequestMapping("/sendListNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		List<SampleVO> list = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName("이");
			vo.setLastName("순신");
			
			list.add(vo);
		}//for
		return new ResponseEntity<List<SampleVO>>(list,HttpStatus.NOT_FOUND);
		//정상적인 JSON데이터와 NOT_FOUND 즉, 404나쁜상태코드가 전송(브라우저창에서 F12개발 툴 콘솔에서 확인가능하다.)
		
	}//sendListNot()
	
}

