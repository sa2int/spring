package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;

public class QnAChangePwService implements QnAService{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String emName = request.getParameter("emName");
		String emNum = request.getParameter("emNum");
		String emNewPw = request.getParameter("emNewPw");
		String emNewPwChk = request.getParameter("emNewPwChk");
		
		
		QnADao dao = new QnADao();
		dao.changePw(emNewPw, emName, emNum);
		
		
		
	}
	

}
