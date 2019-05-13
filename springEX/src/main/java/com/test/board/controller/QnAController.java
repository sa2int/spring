package com.test.board.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.board.dao.IDao;
import com.test.board.dto.Employee;
import com.test.board.service.QnAService;
import com.test.board.util.Constant;

@Controller
public class QnAController {
	
	QnAService qnaService;
	public JdbcTemplate template;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping(value = "qnaMail")
	public String home() throws Exception {

		return "qna/mailForm";
	}

	// mailSending 코드
	@RequestMapping(value = "mailSending")
	public String mailSending(HttpServletRequest request) {
		System.out.println("sending");
		String setfrom = "chsdnpd@gmail.com";
		String tomail = request.getParameter("tomail"); // 받는 사람 이메일
		String title = request.getParameter("title"); // 제목
		String content = request.getParameter("content"); // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:qnaMail";
	}

	// Total List By mybatis
	@RequestMapping(value = "qnaList")
	public String qnaList(Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.list());

		return "qna/qnaList";
	}
//	// Total List
//		@RequestMapping(value = "qnaList")
//		public String qnaList(Model model) {
//
//			qnaService = new QnAListService();
//			qnaService.execute(model);
//
//			return "qna/qnaList";
//		}


	// Responding List
	@RequestMapping(value = "qnaResponding")
	public String qnaResponding(HttpServletRequest request, Model model) {

//		model.addAttribute("request", request);
//		qnaService = new QnARespondingService();
//		qnaService.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("response", dao.qnaResponding(Integer.parseInt(request.getParameter("stCode")), Integer.parseInt(request.getParameter("emCode"))));
		
		return "qna/qnaResponding";

	}
	
	// Responding List
	@RequestMapping(value = "qnaResponding2")
	public String qnaResponding2(HttpServletRequest request, Model model) {

//		model.addAttribute("request", request);
//		qnaService = new QnARespondingService();
//		qnaService.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("response", dao.qnaResponding2(Integer.parseInt(request.getParameter("stCode"))));
		
		return "qna/qnaResponding";

	}

	// Contents View & reply Form
//	@RequestMapping(value = "contentsView")
//	public String contentsView(HttpServletRequest request, Model model) {
//		System.out.println("contentsView");
//
//		model.addAttribute("request", request);
//		qnaService = new QnAContentsService();
//		qnaService.execute(model);
//
//		return "qna/qnaContentsView";
//		// return "redirect:qnaList";
//	}

	// index
	@RequestMapping(value = "index")
	public String index() {

		return "qna/index";
	}

	// QnA Form
	@RequestMapping(value = "qnaForm")
	public String qnaForm(Model model) {

		return "qna/qnaForm";
	}

	// register QnA form by customer
	@RequestMapping(value = "qnaRegister", method = RequestMethod.POST)
	public String qnaRegister(HttpServletRequest request, Model model) {
		System.out.println("write");

		String setfrom = "chsdnpd@gmail.com";
		String qEmail = request.getParameter("qEmail"); // 받는 사람 이메일
		String title = request.getParameter("title"); // 제목
		String qContents = request.getParameter("qContents"); // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(qEmail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(qContents); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

//		model.addAttribute("request", request);
//		qnaService = new QnAWriteService();
//		qnaService.execute(model);
		
		System.out.println("1 : " + request.getParameter("pdCode"));
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.regist(request.getParameter("qName"), request.getParameter("qEmail"), request.getParameter("qPhone"), request.getParameter("pdCode"), request.getParameter("qContents") );
		System.out.println("2 : " + request.getParameter("pdCode"));
		return "qna/quitPage";
	}

	// reply logic
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public String reply(HttpServletRequest request, Model model) {

		String setfrom = "chsdnpd@gmail.com";
		String qEmail = request.getParameter("qemail"); // 받는 사람 이메일
		String title = request.getParameter("title"); // 제목
		String reply = request.getParameter("reply"); // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(qEmail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(reply); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("reply :" + reply);
//		model.addAttribute("request", request);
//		qnaService = new QnAReplyService();
//		qnaService.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.reply(request.getParameter("reply"), Integer.parseInt(request.getParameter("qCode")), Integer.parseInt(request.getParameter("emCode")));

		return "redirect:qnaList";
	}

	// Sign Up View
	@RequestMapping(value = "signUpForm")
	public String signUpForm(Model model) {
		System.out.println("form");
		return "qna/signUpForm";
	}

	// Sign Up logic
	@RequestMapping(value = "signUpInput", method = RequestMethod.POST)
	public String signUpPro(HttpServletRequest request, Model model) {
		System.out.println("form input");

//		model.addAttribute("request", request);
//		qnaService = new QnaSignUpService();
//		qnaService.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.signUp(request.getParameter("emName"), request.getParameter("emPw"), request.getParameter("emNum"));
		

		return "redirect:qnaLogin";
	}

	// Login View
	@RequestMapping(value = "qnaLogin")
	public String login() {
		return "qna/qnaLogin";
	}

	// Login logic
	@RequestMapping(value = "loginOutput", method = RequestMethod.POST)
	public String loginPro(HttpServletRequest request, Model model) {

//		model.addAttribute("request", request);
//		qnaService = new QnALoginService();
//		qnaService.execute(model);
		
		IDao dao = sqlSession.getMapper(IDao.class);
		Employee employee =  dao.login(request.getParameter("emNum"), request.getParameter("emPw"));
		// Employee employee = new Employee();
		System.out.println("employee :" + employee);
		if(employee != null) {
			HttpSession session = request.getSession();
			session.setAttribute("auth_id", employee);
			
			System.out.println("em : " + employee);
			System.out.println(session);
			System.out.println(employee.getEmName());
			System.out.println(employee.getEmCode());
			
		} 
		return "redirect:qnaList";
	}

	// Logout
	@RequestMapping(value = "logout")
	public String logout() {
		return "qna/logout";
	}

	// state of Button
	@RequestMapping(value = "buttonState", method = RequestMethod.POST)
	public String buttonState(HttpServletRequest request, Model model) {

//		model.addAttribute("request", request);
//		qnaService = new QnAUpdateState();
//		qnaService.execute(model);
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.updateState(Integer.parseInt(request.getParameter("stCode")), Integer.parseInt(request.getParameter("emCode")), Integer.parseInt(request.getParameter("qCode")));

		return "redirect:qnaList";
	}

	// change password form
	@RequestMapping(value = "changePw")
	public String changePw() {
		return "qna/qnaChangePw";
	}

	// Change password
	@RequestMapping(value = "changePwPro", method = RequestMethod.POST)
	public String changePwPro(HttpServletRequest request, Model model) {

//		model.addAttribute("request", request);
//		qnaService = new QnAChangePwService();
//		qnaService.execute(model);
		IDao dao =  sqlSession.getMapper(IDao.class);
		dao.changePw(request.getParameter("emNewPw"), request.getParameter("emName"), request.getParameter("emNum"));

		return "qna/qnaLogin";
	}

}
