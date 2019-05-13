package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;

public class QnAUpdateState implements QnAService {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int stCode = Integer.parseInt(request.getParameter("stCode"));
		int emCode = Integer.parseInt(request.getParameter("emCode"));
		int qCode = Integer.parseInt(request.getParameter("qCode"));
		System.out.println(stCode);
		QnADao dao = new QnADao();
		dao.updateState(stCode, emCode, qCode);
		
		System.out.println(stCode);
		

		
	}

	
	
}
