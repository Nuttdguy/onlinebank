package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.domain.User;
import com.app.domain.role.UserRole;

public interface UserService {

	User findByUsername(String username);
	
	User findByEmail(String email);
	
	boolean checkUserExists(String username, String email);
	
	boolean checkUsernameExists(String username);
	
	boolean checkEmailExists(String email);
	
	void Save(User user);
	
	User getNewUser();
	
	void createUser(User user);
	
	User saveUser(User user);
	
	List<User> findUserList();
	
	void enableUser(String username);
	
	void disableUser(String username);	
	
}
















