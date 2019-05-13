package com.test.board.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;
import com.test.board.dto.AnswerDto;
import com.test.board.dto.QnADto;

public class QnAListService implements QnAService{

	@Override
	public void execute(Model model) {
		
		QnADao dao = new QnADao();
		
		ArrayList<QnADto> dtos = dao.qnaList();
		
		model.addAttribute("list", dtos);
		
	}
	 

}
