package com.test.board.dto;

public class QnADto {

	private int qcode;
	private String qname;
	private String qemail;
	private String qphone;
	private int pdCode;
	private String qcontents;
	private String qregistTime;
	private int stCode;
	private String pdName;
	private String stName;
	private int emCode;
	private String aanswer;
	private String emName;
	private int acode;
	
	
	public int getAcode() {
		return acode;
	}

	public void setAcode(int acode) {
		this.acode = acode;
	}

	public QnADto() {
	}

	public QnADto(String qcontents) {
		this.qcontents = qcontents;
	}
	
	

	public QnADto(String qname, String qemail, String qphone, int pdCode, String qcontents) {
		super();
		this.qname = qname;
		this.qemail = qemail;
		this.qphone = qphone;
		this.pdCode = pdCode;
		this.qcontents = qcontents;
	}

	public QnADto(int qcode, String qname, String qemail, String qphone, int pdCode, String qcontents,
			String qregistTime, int stCode, String pdName, String stName, int emCode, String aanswer, String emName, int acode) {
		this.qcode = qcode;
		this.qname = qname;
		this.qemail = qemail;
		this.qphone = qphone;
		this.pdCode = pdCode;
		this.qcontents = qcontents;
		this.qregistTime = qregistTime;
		this.stCode = stCode;
		this.pdName = pdName;
		this.stName = stName;
		this.emCode = emCode;
		this.aanswer = aanswer;
		this.emName = emName;
		this.acode = acode;
	}


	public int getQcode() {
		return qcode;
	}



	public void setQcode(int qcode) {
		this.qcode = qcode;
	}



	public String getQname() {
		return qname;
	}



	public void setQname(String qname) {
		this.qname = qname;
	}



	public String getQemail() {
		return qemail;
	}



	public void setQemail(String qemail) {
		this.qemail = qemail;
	}



	public String getQphone() {
		return qphone;
	}



	public void setQphone(String qphone) {
		this.qphone = qphone;
	}



	public int getPdCode() {
		return pdCode;
	}



	public void setPdCode(int pdCode) {
		this.pdCode = pdCode;
	}



	public String getQcontents() {
		return qcontents;
	}



	public void setQcontents(String qcontents) {
		this.qcontents = qcontents;
	}



	public String getQregistTime() {
		return qregistTime;
	}



	public void setQregistTime(String qregistTime) {
		this.qregistTime = qregistTime;
	}



	public int getStCode() {
		return stCode;
	}



	public void setStCode(int stCode) {
		this.stCode = stCode;
	}



	public String getPdName() {
		return pdName;
	}



	public void setPdName(String pdName) {
		this.pdName = pdName;
	}



	public String getStName() {
		return stName;
	}



	public void setStName(String stName) {
		this.stName = stName;
	}



	public int getEmCode() {
		return emCode;
	}



	public void setEmCode(int emCode) {
		this.emCode = emCode;
	}

	public String getAanswer() {
		return aanswer;
	}

	public void setAanswer(String aanswer) {
		this.aanswer = aanswer;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}
	
	
	
	
	
	

}
