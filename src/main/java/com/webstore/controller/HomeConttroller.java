package com.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeConttroller {
	
	@RequestMapping("/")
	public String welcome(Model model){
		model.addAttribute("greeting","Hello in webstore");
		model.addAttribute("tagline","Special shop");
		return "forward:/welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting(){
		return "welcome";
	}
	

}
