package org.zerock.vo;

public class SampleVO {//데이터 저장빈 클래스
	private int mno;	      //멤버 변수명이 JSON객체의 키이름이 된다.
	private String firstName; //성
	private String lastName;  //이름

	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
