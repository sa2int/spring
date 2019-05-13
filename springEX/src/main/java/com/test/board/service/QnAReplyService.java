package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.test.board.dao.QnADao;

public class QnAReplyService implements QnAService{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		HttpSession session = request.getSession();
//		String session_id = (String) session.getAttribute("auth_id.emName");
		String reply = request.getParameter("reply");
		int qCode = Integer.parseInt(request.getParameter("qCode"));
		int emCode = Integer.parseInt(request.getParameter("emCode"));
//		System.out.println("se : " + session_id);
		System.out.println("seesion Name :" + emCode);
		System.out.println("qCode :" + request.getParameter("qCode"));
		QnADao dao = new QnADao();
		dao.reply(reply, qCode, emCode);
		
		
		
		
		
	}

}
