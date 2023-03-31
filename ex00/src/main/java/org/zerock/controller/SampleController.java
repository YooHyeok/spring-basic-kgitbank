package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //@Controller 애너테이션을 사용하면 해당 컨트롤러 클래스는 스프링에서 인식함
public class SampleController {
	
	@RequestMapping("doA")//get or post로 접근하는 doA매핑주소를 웹주소창에서
	//실행하게 함
	public void doA() {
		//리턴타입이 없는 void형 이면 매핑주소인 doA가 jsp파일명 doA.jsp가 된다.
		System.out.println("doA매핑주소가 실행됨.");
	}
	
	@RequestMapping("doB") //같은 매핑주소는 등록이 안됨.
	public void doB() {
		System.out.println("doB매핑주소가 실행됨.");
	}
}
