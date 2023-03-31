package org.zerock.service;

import java.util.List;

import org.zerock.vo.BoardVO;

public interface BoardService {
	
	int getCount();

	List<BoardVO> getList(BoardVO b);

	void insertBoard(BoardVO b);

	BoardVO getCont(int bno);

	BoardVO getCont2(int bno);

	void editBoard(BoardVO eb);

	void delBoard(int bno);
}
