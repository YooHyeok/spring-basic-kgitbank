package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.ReplyVO;

@Repository//@Repository 애노테이션은 DAO를 스프링에서 인식하게 한다. 
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired//자동의존성 주입
	private SqlSession sqlSession;//mybatis 쿼리문 수행객체 생성
	

	@Override
	public void addReply(ReplyVO vo) {
		this.sqlSession.insert("reply_in",vo);
		//mybatis에서 insert()메서드는 레코드 저장. reply_in은 insert 아이디명.
		
	}


	@Override
	public List<ReplyVO> listReply(int bno) {
		
		return this.sqlSession.selectList("reply_list",bno);
		/*
		mybatis에서 selectList()메서드는 하나 이상의 레코드를 검색해서 컬렉션 List로 반환한다.
		reply_list는 select 유일 아이디명이다.
		*/
	}//댓글 목록


	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlSession.update("reply_edit", vo);
		//mybatis에서 update()메서드는 레코드 수정. reply_edit는 update아이디명
	}//댓글 수정


	@Override
	public void delReply(int rno) {
		this.sqlSession.delete("reply_del", rno);
		//mybatis에서 delete()메서드는 레코드 삭제. reply_del은 delete아이디명.
	}//댓글 삭제


	@Override
	public int getBno(int rno) {
		return this.sqlSession.selectOne("reply_bno",rno);
		//mybatis에서 selectOne()메서드는 단 한개의 레코드값만 반환
		//reply_bno는 reply.xml에서 설정할 유일한 select 아이디 명.
		
	}//댓글 번호에 해당하는 게시물 번호값 알아내기
}
