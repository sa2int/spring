package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;
import com.test.board.dto.AnswerDto;
import com.test.board.dto.QnADto;

public class QnAContentsService implements QnAService {
	
	

	@Override
	public void execute(Model model) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		String qCode = request.getParameter("qcode");
//		
//		QnADao dao = new QnADao();
//		QnADto dto = dao.contentsView(qCode);
//		AnswerDto dto2 = dao.replyView(qCode);
//		System.out.println("answer qCode : " + qCode);
//		System.out.println("answer dto : " + dto);
//		System.out.println("answer answer : " + dto2.getaAnswer());
//		model.addAttribute("contentsView", dto);
//		model.addAttribute("replyView", dto2);
		
	}

}
