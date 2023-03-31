package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.NoticeVO;

@Repository
public class AdminNoticeDAOImpl implements AdminNoticeDAO {
	@Autowired//자동 의존성 주입
	private SqlSession sqlSession;//mybatis 쿼리문 수행 객체를 생성

	@Override
	public void insertNotice(NoticeVO n) {
		this.sqlSession.insert("an_in", n);
		//mybatis에서 insert()메서드는 레코드를 저장한다 an_in은 insert 유일 아이디명.
	}
	
	
}
