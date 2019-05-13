package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;

public class QnAWriteService implements QnAService {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String qName = request.getParameter("qName");
		String qEmail = request.getParameter("qEmail");
		String qPhone = request.getParameter("qPhone");
		String pdCode = request.getParameter("qdCode");
		String qContents = request.getParameter("qContents");
		
		QnADao dao = new QnADao();
		dao.regist(qName, qEmail, qPhone, pdCode, qContents);
		System.out.println(dao);
		System.out.println(qName);
	}
	

}
