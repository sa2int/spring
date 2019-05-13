package com.test.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ccc")
public class SampleContorller {

	
	@RequestMapping("/vv")
	public String view() {
		
		return "test";
	}
	
}
