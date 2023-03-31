package org.zerock.vo;

public class ReplyVO {
	//tbl_reply테이블의 컬럼명과 변수명을 일치시킨다.
	
	//private = ReplyVO클래스 안에서만접근 가능 외부클래스에서 접근 불가능
	private int rno; 			// 댓글번호
	private int bno;			// 게시판 번호값만 저장됨.
	private String replyer;		//댓글 작성자
	private String replytext;	//댓글내용
	private String regdate;		//댓글 등록 날짜
	private String updatedate;	//댓글 수정 날짜
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
