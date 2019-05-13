package com.test.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@RequestMapping("/view")
	public String view() {
		
		return "view";
	}
	
	
	@RequestMapping(value="/content/contentView")
	public String content(Model model) {
		model.addAttribute("id", 30);
		
		return "content/contentView";
	}
	
	@RequestMapping("/model/modelEX")
	public String modelEX(Model model) {
		model.addAttribute("data", "abcdef");
		
		return "model/modelEX";
	}
	
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView() {
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("id", "abdf");
		mv.setViewName("/model/modelAndView");
		return mv;
	}
	
	@RequestMapping("/member/memberView")
	public String viewMember(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		
		return "model/modelView";
	}
	
	@RequestMapping("/member/RememberView")
	public String viewMembers(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		
		model.addAttribute("idd", id);
		model.addAttribute("pww", pw);
		
		return "model/remodelView";
	}
	
	@RequestMapping("/member/memInfo")
	public String mem(@RequestParam("name") String name, @RequestParam("id") String id, 
			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		
		Member member =  new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member", member);
		System.out.println("ss");
		System.out.println(name);
		return "member/mem";
	}
	
	
	@RequestMapping("/member/memInfo2")
	public String mem(Member member) {
		
		return "member/mem2";
	}
	
	@RequestMapping("/member/memInfo3")
	public String mem2(@ModelAttribute("mem") Member member) {
		
		return "member/mem3";
	}
	
//	@RequestMapping("/index")
//	public String indexForm() {
//		
//		
//		
//		return "form/indexForm";
//	}

	@RequestMapping(value = "/student", method=RequestMethod.GET)
	public String atudentId(HttpServletRequest httpServletRequest, Model model){
		
		String id = httpServletRequest.getParameter("id");
		model.addAttribute("idd", id);
		
		
		return "form/indexForm2";
		
	}
	
	@RequestMapping(value = "/student", method=RequestMethod.POST)
	public ModelAndView atudentId(HttpServletRequest httpServletRequest){
		
		String id = httpServletRequest.getParameter("id");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form/indexForm2");
		mv.addObject("idd", id);
//		model.addAttribute("idd", id);
				
		return mv;

	}
	
	@RequestMapping("/redirectConfirm")
	public String redirect(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		
		if(id.equals("abc")){
			return "redirect:redirectOK";
		}
		
		return "redirect:redirectNG";
	}
	
	@RequestMapping("/redirectOK")
	public String redirectOK() {
		
		return "redirect/redirectOK";
	}
	
	@RequestMapping("/redirectNG")
	public String redirectNG() {
		
		return "redirect:redirectNG";
		//return "redirect:http://localhost:8080/board/redirectNG";
	}
	
}
