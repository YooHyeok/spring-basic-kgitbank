package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.vo.ProductVO;

@Controller
public class SampleController3 {
	@RequestMapping("/nameprice")
	public String nameprice(Model m) {
		ProductVO p = new ProductVO("신발", 120000);
		m.addAttribute("p", p);//p키이름에 p객체 저장
		return "shop/pro_name";//뷰 리졸브 경로=> /WEB-INF/views/shop/pro_name.jsp
	}
}
