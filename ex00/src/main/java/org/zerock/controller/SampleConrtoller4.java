package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleConrtoller4 {
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg","this is seven");
		//msg키 이름에 this is seven문자열을 담아서 다른 매핑주소로 전달한다. 
		//서버상에서 실행되기 때문에 보안성이 우수하다.

		return "redirect:/doF"; //doE매핑주소가 실행되면 다른 매핑주소인 doF로 이동한다.
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String name) {
		System.out.println("전달된 값"+name);
	}
	
}
