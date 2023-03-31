package org.zerock.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void updatePoint(String sender, int point) {
		Map<String,Object> pm = new HashMap<>(); //문자열 키, Object타입 값만 저장하는 컬렉션 제네릭 자료구조이고 업캐스팅 하면서 pm을 생성
		pm.put("sender",sender);//sender키이름에 보낸사람 저장.
		pm.put("point",point);//포인트점수 => point.xml에서 키이름을 참조하여 해당 값을 가져온다.
		this.sqlSession.update("pointUp",pm);//pointUp은 유일한 update아이디명(point.xml)
	}//메시지를 보낸 사람에게 포인트점수 10점 증가.


}
