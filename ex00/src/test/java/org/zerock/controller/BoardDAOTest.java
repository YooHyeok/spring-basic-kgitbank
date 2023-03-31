package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class BoardDAOTest {
	@Autowired
	private BoardDAO boardDao;
	
	@Test
	public void testBoardInsert() throws Exception{
		BoardVO b = new BoardVO();
		b.setWriter("홍길동"); b.setTitle("게시판 제목입니다.");
		b.setContent("게시판 내용입니다.");
		
		this.boardDao.insertBoard(b);//게시판 저장
	}
}
