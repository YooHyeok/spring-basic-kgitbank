package org.zerock.service;

import java.util.List;

import org.zerock.vo.ReplyVO;

public interface ReplyService {
	
	void addReply(ReplyVO vo);//public abstract가 생략된 추상메서드

	List<ReplyVO> listReply(int bno); //가변적목록으로 변환 (object -> List<>)

	void updateReply(ReplyVO vo);

	void remove(int rno);

}
