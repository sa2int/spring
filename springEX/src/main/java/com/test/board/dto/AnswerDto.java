package com.test.board.dto;

public class AnswerDto {
	
	private int aCode;
	private String aAnswer;
	private int qCode;
	private String qRegistTime;
	private int emCode;

	
	public AnswerDto() {
	}
	
	public AnswerDto(String aAnswer, int qCode, String qRegistTime, int emCode) {
		this.aAnswer = aAnswer;
		this.qCode = qCode;
		this.qRegistTime = qRegistTime;
		this.emCode = emCode;
	}
	
	public AnswerDto(int aCode, String aAnswer, int qCode, String qRegistTime, int emCode) {
		this.aCode = aCode;
		this.aAnswer = aAnswer;
		this.qCode = qCode;
		this.qRegistTime = qRegistTime;
		this.emCode = emCode;
	}
	
	public int getaCode() {
		return aCode;
	}
	public void setaCode(int aCode) {
		this.aCode = aCode;
	}
	public String getaAnswer() {
		return aAnswer;
	}
	public void setaAnswer(String aAnswer) {
		this.aAnswer = aAnswer;
	}
	public int getqCode() {
		return qCode;
	}
	public void setqCode(int qCode) {
		this.qCode = qCode;
	}
	public String getqRegistTime() {
		return qRegistTime;
	}
	public void setqRegistTime(String qRegistTime) {
		this.qRegistTime = qRegistTime;
	}
	public int getEmCode() {
		return emCode;
	}
	public void setEmCode(int emCode) {
		this.emCode = emCode;
	}
	
	
	

}
