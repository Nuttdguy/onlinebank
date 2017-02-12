package com.app.serviceImpl;

import java.util.List;
import java.util.Set;

import com.app.onlinebank.domain.User;
import com.app.onlinebank.domain.role.UserRole;
import com.app.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUserExists(String username, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUsernameExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmailExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getNewUser() {
		return new User();
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableUser(String username) {
		// TODO Auto-generated method stub
		
	}

}
