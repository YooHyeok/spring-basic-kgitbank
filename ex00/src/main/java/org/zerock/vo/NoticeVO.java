package org.zerock.vo;

public class NoticeVO {

	/* mybatis를 사용하려면 테이블의 컬럼명과 빈클래스 변수명을 일치시킨다. */
	private int notice_no;			//공지 번호
	private String notice_name;		//공지 작성자
	private String notice_title;	//공지 제목
	private String notice_pwd;		//공지 비밀번호
	private String notice_cont;		//공지 내용
	private int notice_hit;			//조회수
	private String notice_date;		//등록날짜


	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_pwd() {
		return notice_pwd;
	}
	public void setNotice_pwd(String notice_pwd) {
		this.notice_pwd = notice_pwd;
	}
	public String getNotice_cont() {
		return notice_cont;
	}
	public void setNotice_cont(String notice_cont) {
		this.notice_cont = notice_cont;
	}
	public int getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

}
