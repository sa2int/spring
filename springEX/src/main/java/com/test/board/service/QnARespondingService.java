package com.test.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;
import com.test.board.dto.QnADto;

public class QnARespondingService implements QnAService {
	
	

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int stCode = Integer.parseInt(request.getParameter("stCode"));
		int emCode = Integer.parseInt(request.getParameter("emCode"));
		QnADao dao = new QnADao();
		List<QnADto> dtos = null ;
		
		System.out.println("stCode : " + stCode);
		dtos =  dao.qnaResponding(stCode, emCode);
		
			model.addAttribute("response", dtos);
		
		
	}
	
	

}
