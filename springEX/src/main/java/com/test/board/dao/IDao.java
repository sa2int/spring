package com.test.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.test.board.dto.Employee;
import com.test.board.dto.QnADto;

public interface IDao {
	
	public ArrayList<QnADto> list();
	public void regist(final String qName, final String qEmail, final String qPhone, final String pdCode, final String qContents);
	public List<QnADto> qnaResponding(int stCode, int emCode);
	public List<QnADto> qnaResponding2(int stCode);
	public void reply(String reply, int qCode, int emCode);
	public void signUp(final String emName, final String emPw, final String emNum);
	public Employee login(String emNumber, String password);
	public void updateState(final int stCode, final int emCode, final int qCode);
	public void changePw(String emNewPw, String emName, String emNum);
	

}
