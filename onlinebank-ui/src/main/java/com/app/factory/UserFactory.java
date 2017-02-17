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
	
	public boolean checkUserExists(String username, String email) {
		if ( checkUsernameExists(username) || checkEmailExists(email) )
			return true;
		else
			return false;
	}
	
	public boolean checkEmailExists(String email) {
		if (null != userService.findByEmail( email )) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkUsernameExists(String username) {
		if (null != userService.findByUsername( username  )) {
			return true;
		}

		return false;
	}
	
	public void saveUser(User user) {
		userService.createUser(user);
	}
	
}
