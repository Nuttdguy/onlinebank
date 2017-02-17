package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.domain.User;
import com.app.factory.UserFactory;

@Controller
public class HomeController {
	
	@Autowired
	private UserFactory userFactory;

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
		model.addAttribute("user", userFactory.createUser() );
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {
		String loadUrl = "";
		
		if (userFactory.checkUserExists(user.getUsername(), user.getEmail())) {
		
			if (userFactory.checkEmailExists( user.getEmail() ))
				model.addAttribute("emailExists", true);
			if (userFactory.checkUsernameExists( user.getUsername() ))
				model.addAttribute("usernameExists", true);
			loadUrl = "signup";			
		} else {	
			try {
				userFactory.saveUser(user);
				return "redirect:/";
			} catch (Exception sqlex) {
				loadUrl = "signup";
			}
		}
		return loadUrl;

	}

}

//if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
//
//	if (userService.checkEmailExists(user.getEmail()))
//		model.addAttribute("emailExists", true);
//	if (userService.checkUsernameExists(user.getUsername())) {
//		model.addAttribute("usernameExists", true);
//	}
//	return "signup";
//} else {
//	
////	userService.createUser(user);
//	userService.save(user);
//	return "redirect:/";
//}
	
	
	
	//		boolean isEmailExist = userFactory.checkEmailExists(user);
//	boolean isUsernameExist = userFactory.checkUsernameExists(user);
//	
//	if ( isEmailExist || isUsernameExist ) {
//		model.addAttribute("emailExists", isEmailExist);
//		model.addAttribute("usernameExists", isUsernameExist);
//		return "signup";
//	} else { 
//		userFactory.saveUser(user);
//		return "redirect:/";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	