package org.zerock.vo;

public class MemberVO {//데이터 저장빈 클래스
	
//	mybatis를 사용하기 위해서는 테이블의 컬럼명과 데이터 저장빈 클래스의 변수명을 일치시키는것이 좋다
	
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private String regdate;
	private String updatedate;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
