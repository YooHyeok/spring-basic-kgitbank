package org.zerock.dao;

import java.util.List;

import org.zerock.vo.BoardVO;

//클래스의 조상은 object!
public interface BoardDAO {

	int getCount();
	
	void insertBoard(BoardVO b);//인터페이스는 조상이 없음(빈껍데기). 클래스간의 직접적인 연결은 좋지않아 마모(톱니바퀴)가되어서 유연하게 연결해주는 역할을해준다.
	//추상메서드 => {}가 없고 실행문장이 없고, 호출 불가능. 반드시 자손클래스에서 오버라이딩.

	List<BoardVO> getList(BoardVO b);
	
	void updateHit(int bno);
	
	BoardVO getCont(int bno);
	
	void editBoard(BoardVO eb);

	void delBoard(int bno);

	void updateReplyCnt(int bno, int amount);
	
	
	
}
