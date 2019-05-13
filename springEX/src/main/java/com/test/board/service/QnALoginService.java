package com.test.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import com.test.board.dao.QnADao;
import com.test.board.dto.Employee;

public class QnALoginService implements QnAService {

	@Override
	public void execute(Model model) {
		Employee employee = null;
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String emNum = request.getParameter("emNum");
		String emPw = request.getParameter("emPw");
		
		QnADao dao = new QnADao();
		//int login = ;
		employee = dao.login(emNum, emPw);
		
		if(employee != null) {
			HttpSession session = request.getSession();
			session.setAttribute("auth_id", employee);
			
			System.out.println(employee);
			System.out.println(session);
			System.out.println(employee.getEmName());
			System.out.println(employee.getEmCode());
			
		} 
		
		
	}
}
