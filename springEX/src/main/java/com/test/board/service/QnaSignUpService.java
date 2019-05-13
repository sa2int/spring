package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;

public class QnaSignUpService implements QnAService {
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String emName = request.getParameter("emName");
		String emPw = request.getParameter("emPw");
		String emNum = request.getParameter("emNum");
		
		QnADao dao = new QnADao();
		dao.signUp(emName, emPw, emNum);
		System.out.println("ser" + emPw);
		System.out.println("service" + dao);
		
		
	
		
	}

}
