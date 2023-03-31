package org.zerock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO;

@Repository //@Repository 애노테이션은 DAO를 스프링에서 인식하게 한다. 
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;//mybatis 쿼리문 수행객체 의존성 주입(DI)

	
	
	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("b_in",b);
		//b_in은 insert 아이디명.
	}//게시판 저장
	

	@Override
	public int getCount() {
		return this.sqlSession.selectOne("b_count");
		//mybatis에서 selectOne()메서드는 단 한개의 레코드만 반환.
		//b_count는 board.xml에 설정할 유일한 select 아이디명.
	}//총 레코드 갯수

	
	@Override
	public List<BoardVO> getList(BoardVO b) {
		return this.sqlSession.selectList("b_list",b);
		//myBatis에서 selectList()메서드는 하나 이상의 복수개의 레코드를 검색해서 컬렉션 리스트로 반환한다.
		//b_list는 유일한 select 아이디명이다.(중복되지않는)
	}//게시판 목록

	
	@Override
	public void updateHit(int bno) {
		this.sqlSession.update("b_hit",bno);
		/*
		mybatis에서 update()메서드는 레코드를 수정. 
		레코드란 데이터베이스 용어로서 컬럼에 저장된 한 행의 자로 집합을 뜻함.	
		b_hit는 update아이디명 (해당아이디명은 유일해야 한다.)
		*/
	}//조회수 증가

	
	@Override
	public BoardVO getCont(int bno) {
		return this.sqlSession.selectOne("b_cont",bno);
	}//게시물 내용


	@Override
	public void editBoard(BoardVO eb) {
		this.sqlSession.update("b_edit",eb);
	}//게시물 수정


	@Override
	public void delBoard(int bno) {
		this.sqlSession.delete("b_del", bno);
		/*
		mybatis에서 delete()메서드는 레코드 삭제.
		b_del은 board.xml에서 설정할 해당아이디명=>이 아이디명은 유일해야한다.(중복id가 없어야함)
		*/
	}//게시물 삭제


	@Override
	public void updateReplyCnt(int bno, int amount) {
		Map<String,Object> pm=new HashMap<>();
		/* java.util패키지의 컬렉션 Map인터페이스를 구현한 컬렉션 클래스 HashMap특징
		1. jdk1.2에서 추가된   키,값 쌍으로 저장하는 사전적인 자료구조.
		2. 가변적인 하나이상의 복수개의 원소값을 저장할 수 있다.
		3. 키를 통해서 값을 전송하기 때문에 검색속도가 빠르다.
		4. 중복키는 존재할 수 없고 중복값은 존재한다. 
		 <String,Object>제네릭 타입은 jdk1.5에서 추가되었고 문자열 키와 Object타입값만 저장가능하다.*/
		pm.put("bno",bno); //bno키이름에 게시판 번호값을 저장한다. bno키이름을 board.xml에서 참조해서 번호값을 가져온다.
		pm.put("amount", amount);
		this.sqlSession.update("updateReplyCnt",pm);
		//updateReplyCnt는 board.xml에서 설정할 update 유일 아이디명.
		
	}//댓글 갯수 추가





	
	
}
