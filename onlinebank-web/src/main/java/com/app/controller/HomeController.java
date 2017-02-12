package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.onlinebank.domain.User;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
		
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(Model model) {
	
		// Create user object for form
		User user = new User();
		model.addAttribute("user", user);	
		return "signup";
	}
}