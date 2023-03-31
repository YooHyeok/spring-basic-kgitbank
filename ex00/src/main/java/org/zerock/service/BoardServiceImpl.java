package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired//자동 의존성 주입 @inject로 써도 됨.
	private BoardDAO boardDao;

	@Override//추상메서드 오버라이딩.
	public int getCount() {
		
		return this.boardDao.getCount();
			
	}

	@Override
	public List<BoardVO> getList(BoardVO b) {
		
		return this.boardDao.getList(b);
	}

	@Override
	public void insertBoard(BoardVO b) { //void는 리턴타입이 없음.
		
		this.boardDao.insertBoard(b);
	}

	//스프링의 AOP를 통한 트랜잭션을 적용해서 데이터를 일치.
	@Transactional(isolation = Isolation.READ_COMMITTED)
	//트랜잭션 격리(트랜잭션이 처리되는 중간에 외부간섭을 제거)
	@Override
	public BoardVO getCont(int bno) {
		this.boardDao.updateHit(bno);//조회수 증가
		return this.boardDao.getCont(bno);//오라클 데이터베이스로 부터 게시물 내용을 가져오기
	}//조회수 증가와 게시물 내용보기로 분리

	@Override
	public BoardVO getCont2(int bno) {
		return this.boardDao.getCont(bno);
	}//게시물 내용 가져오기

	@Override
	public void editBoard(BoardVO eb) {
		this.boardDao.editBoard(eb);
	}//게시물 수정

	@Override
	public void delBoard(int bno) {
		this.boardDao.delBoard(bno);
	}
}




