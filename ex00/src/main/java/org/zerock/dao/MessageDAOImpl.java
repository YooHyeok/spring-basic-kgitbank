package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SqlSession sqlSession; //mybatis쿼리문 수행객체

	@Override
	public void create(MessageVO vo) {
		this.sqlSession.insert("m_in2",vo);
		//mybatis에서 insert()메서드는 레코드 추가, m_in2는 insert아이디 명.
	}//메시지 추가
}


//컨트롤러 -> service -> serviceImpl(override) -> dao -> daoImpl(override)