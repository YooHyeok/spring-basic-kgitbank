package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.BoardDAO;
import org.zerock.dao.ReplyDAO;
import org.zerock.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDao;//의존성 주입(DI)
	
	@Autowired
	private BoardDAO boardDao;//의존성 주입
	
	//aop를 통한 트랜잭션 적용
	@Transactional
	@Override
	public void addReply(ReplyVO vo) {
/*	이클립스에서 해당 메서드에 트랜잭션을 적용하면 스프링의 aop의 Around타입에 해당하는 위 아래 화살표가 해당 메서드 왼쪽 첫머리 부분에 생성된다
										   Around타입은 스프링Aop의 Advice의 적용 범위를 나타낸다
	스프링aop 용어정리
	1. advice	 : 실제 기능을 구현한 객체
	2. Around타입   : target메서드 호출전 이후 모두 가장 광범위하게 사용됨.	
	3. target 	 : 대상 메서드를 가지는 객체
*/	
		this.replyDao.addReply(vo);		//댓글추가 (DAO와 연결)
		this.boardDao.updateReplyCnt(vo.getBno(),1);//새로운 댓글이 추가되면 댓글갯수 1증가
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		
		return this.replyDao.listReply(bno)	;
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);
	}

	@Transactional
	@Override
	public void remove(int rno) {
		int bno=this.replyDao.getBno(rno);//댓글번호로 게시물 번호값을 구함.
		this.replyDao.delReply(rno); //댓글 삭제 (DAO에 생성될 메서드 이름)
		this.boardDao.updateReplyCnt(bno, -1);//댓글이 삭제되면 댓글갯수 1감소
	}
	
}
