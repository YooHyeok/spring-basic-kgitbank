package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.ReplyService;
import org.zerock.vo.ReplyVO;

@RestController
@RequestMapping("/replies")//컨트롤러 자체에 매핑주소 등록
public class ReplyController {
	
	@Autowired
	private ReplyService ReplyService;
	
	//댓글 등록
	
	@RequestMapping(value="",method=RequestMethod.POST)
	//post방식으로 접근하는 매핑주소를 처리
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
		/*
		@RequestBody 어노테이션은 전송된 JSON 데이터를 객체로 변환한다.
		데이터 전송방식은 JSON을 이용한다.
		JSON으로 보내진 자료를 ReplyVO 타입으로 바꿔준다.
		
		ResponseEntity : rest방식에서 뷰단을 생략하고 바로띄워줄때 기능을 활성화시켜주는 내장객체 클래스.
		*/
		ResponseEntity<String> entity=null;
		
		try {
			this.ReplyService.addReply(vo);//댓글 추가
			entity = new ResponseEntity<String>("success", HttpStatus.OK);//댓글저장 성공시 success문자열이 반환되고, 정상상태코드 200이 반환된다.
		}catch(Exception e) {
			e.printStackTrace();//예외 오류가 발생하면 족적을 남김.
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			//예외 오류가 발생하면 나쁜상태코드 문자열이 반환됨
		}
		return entity;
		
	}//register()
	
	//게시물 번호에 해당하는 댓글목록
	@RequestMapping(value="/all/{bno}",method=RequestMethod.GET)
	//get으로 접근하는 매핑주소 처리
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno){
		
		//@pathVariable("bno")는 매핑 주소의 게시물 번호값을 추출하는 용도로 활용된다.
		
		ResponseEntity<List<ReplyVO>> entity=null;
		
		try {
			entity = new ResponseEntity<>(this.ReplyService.listReply(bno),HttpStatus.OK);
			//게시물 번호에 해당하는 댓글 목록을 반환.
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//list()
	
	//댓글 수정
	@RequestMapping(value="/{rno}",method= {RequestMethod.PUT , RequestMethod.PATCH}) //댓글번호(rno)가 주소값으로
	//PUT은 전체자료를 수정, PATCH는 일부자료만 수정
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity=null;
		try {
			vo.setRno(rno); //댓글 번호 저장
			this.ReplyService.updateReply(vo); //댓글 수정
			entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK); //수정 성공하면 SUCCESS문자열과 200정상 상태 코드가 반환
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//update
	
	//댓글 삭제
	@RequestMapping(value="{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno){
		ResponseEntity<String> entity = null;
	
		try {
			this.ReplyService.remove(rno);//댓글 삭제
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//remove()
	
}
