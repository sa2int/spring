package com.test.board.dto;

public class Employee {
	private int emCode;
	private String emName;
	private String emPw;
	private String emNum;
	
	
	public Employee() {
	}
	
	public Employee(int emCode, String emName, String emPw, String emNum) {
		this.emCode = emCode;
		this.emName = emName;
		this.emPw = emPw;
		this.emNum = emNum;
	}
	
	public int getEmCode() {
		return emCode;
	}

	public void setEmCode(int emCode) {
		this.emCode = emCode;
	}

	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public String getEmPw() {
		return emPw;
	}
	public void setEmPw(String emPw) {
		this.emPw = emPw;
	}
	public String getEmNum() {
		return emNum;
	}
	public void setEmNum(String emNum) {
		this.emNum = emNum;
	}
	
	

}
