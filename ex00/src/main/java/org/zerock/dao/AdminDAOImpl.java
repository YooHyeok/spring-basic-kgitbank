package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SqlSession sqlSession;//자동의존성 주입

	@Override
	public AdminVO admin_Login(String admin_id) {
		return this.sqlSession.selectOne("admin_login", admin_id);
		//mybatis에서 selectOne()메서드는 단 한개의 레코드를 반환. admin_login은 select 유일 아이디명 
	}//관리자 로그인 인증
	
}
