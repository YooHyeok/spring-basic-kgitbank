package org.zerock.dao;

import java.util.List;

import org.zerock.vo.ReplyVO;

public interface ReplyDAO {
	void addReply(ReplyVO vo);//추상메서드는 {}가 없고 실행문장이 없다.그러므로
	//호출이 불가능.

	List<ReplyVO> listReply(int bno);

	void updateReply(ReplyVO vo);

	void delReply(int rno);

	int getBno(int rno); //댓글 번호를 기준으로 해당 게시물 번호값을 알아냄.

}
