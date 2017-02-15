package com.app.factory;

import java.util.Collection;
import java.util.Map;

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
	
	public boolean checkEmailExists(User user) {
		if (null != userService.findByEmail( user.getEmail() )) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkUsernameExists(User user) {
		if (null != userService.findByUsername(user.getUsername() )) {
			return true;
		} else {
			return false;
		}
	}
	
	public void saveUser(User user) {
		userService.createUser(user);
	}
	
}
