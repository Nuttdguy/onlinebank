package com.app.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.RoleDao;
import com.app.domain.User;
import com.app.domain.role.UserRole;
import com.app.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	RoleDao roleDao;

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
	public void createUser(User user) {
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));	
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
