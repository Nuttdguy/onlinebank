package com.app.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.app.domain.User;
import com.app.service.UserService;

@Component
public class UserFactory {
	
	@Autowired
	private UserService userService;

	public User createUser() {
		return new User();
	}
	
	
}
