package org.zerock.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.service.AdminNoticeService;
import org.zerock.vo.NoticeVO;

@Controller
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService adminNoticeService;
	
	
	//관리자 공지 작성
	@GetMapping("/admin_notice_write") //get으로 접근하는 매핑주소를 등록
	public ModelAndView admin_notice_write(HttpServletResponse response, HttpSession session) throws Exception{
	//ModelAndView의 역할 : 
		response.setContentType("text/html;charset=UTF-8");
		//웹브라우저에 응답하는 문자/태그,언어코딩 타입을 설정
		PrintWriter out = response.getWriter();//출력스트림 객체 생성
		String admin_id=(String)session.getAttribute("admin_id");
		//명시적인 다운캐스팅 하면서 관리자 세션 아이디값을 구함.
		
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='admin_login';");
			out.println("</script>");
		}else {//관리자가 로그인 된 상태
			ModelAndView gm = new ModelAndView("admin/admin_notice_write");
			//뷰리졸브 경로 (뷰페이지 경로) => /WEB-INF/views/admin/admin_notice_write.jsp
			return gm;
		}
		return null;
	}//admin_notice_write
	
	//관리자 공지저장
	@PostMapping("/admin_notice_write_ok")
	public String admin_notice_write_ok(NoticeVO n, HttpServletResponse response, HttpSession session) throws Exception{
		/* admin_notice_write.jsp 의 네임파라미터 이름과 NoticeVO.java의 변수명이 일치하면
	 	NoticeVO n에서 n객체에 작성자,제목,비번,내용이 함께 저장된다 */
		response.setContentType("text/html;charset=UTF-8");
		//웹브라우저에 출력되는 문자.태그,언어코딩타입을 설정
		PrintWriter out = response.getWriter();
		String admin_id=(String)session.getAttribute("admin_id");
		//관리자 세션 아이디값을 구함.
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='admin_login';");
			out.println("</script>");
		}else {
			this.adminNoticeService.insertN(n);//공지 저장
			return "redirect:/admin_notice_list"; //관리자 공지목록으로 이동 => jsp파일을 작성하지않아 공지글작성시에 error404가뜸.
		}
		return null;
	}//admin_notice_write_ok()

}

















