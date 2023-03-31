package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.MemberVO;

@Repository//@Repository 애노테이션은 DAO를 스프링에서 인식하게 한다. 

public class MemberDAOImpl implements MemberDAO{ //상속클래스.
	
	@Autowired
	private SqlSession sqlSession; //mybatis 쿼리문 수행 객체생성
	@Override //상속관계에서 조상에있는 동일메서드원형을 그대로 상속받은것을 통해 
	
	public void insertMember(MemberVO m) {
	 this.sqlSession.insert("m_in",m);
	 /*
	  mybatis에서 insert()메서드는 레코드 저장. m_in은 member.xml매퍼태그에서
	  설정할 insert 아이디명.	이 아이디명은 중복되서는 안된다.
	  */
	}//회원저장

	

}