package com.test.board.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;

public class MailService implements QnAService {
	

	@Override
	public void execute(Model model) {
		 try {

			   MimeMessage mimeMsg = mailSender.createMimeMessage();

			   MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);

			   helper.setFrom(simpleMailMessage.getFrom());

			   helper.setTo(simpleMailMessage.getTo());

			   helper.setSubject("hello");

			   helper.setText(new String("great".getBytes("UTF-8"), "8859_1"),true);

			 

			   this.mailSender.send(mimeMsg);

			  } catch (Exception e) {

			   e.printStackTrace();

			  }
		
	}
		 

		 private JavaMailSender mailSender;

		 private SimpleMailMessage simpleMailMessage;

		 

		 public void setMailSender(JavaMailSender mailSender) {

		  this.mailSender = mailSender;

		 }

		 

		 public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {

		  this.simpleMailMessage = simpleMailMessage;

		 }



	

}
