package org.zerock.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.service.AdminService;
import org.zerock.vo.AdminVO;

@Controller
public class AdminController {

	@Inject
	private AdminService adminService;
	
	//관리자 로그인 폼
	@GetMapping("/admin_login")	//get방식으로 접근하는 매핑주소를 처리
	public ModelAndView admin_login() {
		ModelAndView am = new ModelAndView();
		am.setViewName("admin/admin_login");
		//뷰 리졸브 경로 => /WEB-INF/views/admin/admin_login.jsp
		/* 	뷰페이지 경로가 /WEB-INF로 잡힌 이유는 JSP파일이 직접 웹브라우저에서 실행되지 않는다
			=> 보안효과(스프링 개발자 입사 -> 기술 면접)	*/
		
	return am;	
	}
	
	//관리자 로그인 인증
	@PostMapping("/admin_login_ok") //post방식으로 접근할 매핑주소를 처리
	public String admin_login_ok(AdminVO ab, HttpServletResponse response,HttpSession session) throws Exception {
		/*
		1. AdminVO 빈클래스의 변수명과 admin_login.jsp의 네임파라미터 이름이 같으면 ab객체에 관리자 아이디와 비번이 저장됨.
		2. HttpServletResponse는 서버의 가공된 정보를 사용자 웹브라우저에 응답할 때 사용.
		3. session은 로그인 인증과 로그아웃할 때 사용하고 서버에서 구동되며 보안성이 우수하다.
		*/
		response.setContentType("text/html;charset=UTF-8");
		//브라우저에 응답하는 문자/태그, 언어코딩 타입을 지정.
		PrintWriter out = response.getWriter();//출력스트림 객체 생성
			
		AdminVO admin_pwd = this.adminService.admin_Login(ab.getAdmin_id()); //관리자 아이디를 기준으로 오라클 DB로부터 관리자 정보를 가져옴. 
		//adminService 인터페이스에 admin_login() 추상메서드만들기
		
		if(admin_pwd == null) {
			out.println("<script>");
			out.println("alert('관리자 정보가 없습니다.');");
			out.println("history.back();"); //history는 자바스크립트에서 과거형 객체로서 이전주소정보를 담고있다. go(-1)은 뒤로 한칸 이동
			out.println("</script>");
			
		}else {
			if(!admin_pwd.getAdmin_pwd().equals(ab.getAdmin_pwd())) {
				out.println("<script>");
				out.println("alert('관리자 비밀번호가 다릅니다!');");
				out.println("history.go(-1);");
				out.println("</script>");
				
			}else {
				session.setAttribute("admin_id", ab.getAdmin_id());//세션 키이름 admin_id에 관리자 아이디를 저장
				session.setAttribute("admin_name", admin_pwd.getAdmin_name());//admin_name키이름에 오라클로부터 가져온 관리자이름을 저장
				return "redirect:/admin_main";
			}
		}
		return null;
		}//admin_login_ok()
	
	//관리자 메인화면
	@RequestMapping("/admin_main")
	public String admin_main(HttpServletResponse response,HttpSession session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		//업캐스팅을 한것에 한해서 다운캐스팅을 허용함. 세션관리자 아이디값을 명시적인 다운캐스팅을 하면서 좌측변수에 저장해서 구함.
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인하세요');");
			out.println("location='admin_login';");
			out.println("</script>");
			
		}else {
			return "admin/admin_main"; //	->	  /WEB-INF/admin/admin_main.jsp
		}
		return null;
	}//admin_main
	
	//관리자 로그아웃
	@PostMapping("/admin_logout")
	public String admin_logout(HttpServletResponse response, HttpSession session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		session.invalidate();//세션만료
		
		out.println("<script>");
		out.println("alert('관리자 로그아웃 되었습니다.');");
		out.println("location='admin_login';");
		out.println("</script>");
		
		return null;
	}
		
}

/*
PrintWriter 출력스트림
out.println("<script>");
out.println("");
out.println("");
out.println("");
out.println("</script>");
*/