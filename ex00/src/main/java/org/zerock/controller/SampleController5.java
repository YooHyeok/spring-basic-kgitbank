package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.vo.ProductVO;

@Controller
public class SampleController5 {
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
	/*
	@ResponseBody 애노테이션을 사용하면 jsp파일을 만들지 않고도 웹브라우저에 키,값 쌍의
	json데이터를 쉽게 출력할 수 있다.
	*/
		ProductVO p = new ProductVO("수박", 15000);
		return p; //JSON 데이터의 키이름이 ProductVO빈 클래스의 변수명이 된다.
	}
}
