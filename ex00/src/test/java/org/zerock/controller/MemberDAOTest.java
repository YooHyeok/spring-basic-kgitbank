package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDAO;
import org.zerock.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDAOTest {
	@Autowired //자동의존성주입
	private MemberDAO dao;
	
	@Test
	public void testInsertMember() throws Exception{
		MemberVO m = new MemberVO();
		m.setUserid("aaaaa");//회원아이디
		m.setUserpw("77777");//회원비번
		m.setUsername("이순신");//회원 이름
		m.setEmail("hong@naver.com");//전자우편
		
		dao.insertMember(m);//회원저장
	}
}
