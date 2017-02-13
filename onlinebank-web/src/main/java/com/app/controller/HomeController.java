package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.domain.User;
import com.app.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		// get user object for sign-up form
		User user = userService.getNewUser();
		model.addAttribute("user", user);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {

		if (userService.checkUserExists(user.getUsername(), user.getEmail())) {

			if (userService.checkEmailExists(user.getEmail()))
				model.addAttribute("emailExists", true);
			if (userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			return "signup";
		} else {
			
//			userService.createUser(user);
			userService.save(user);
			return "redirect:/";
		}

	}

}