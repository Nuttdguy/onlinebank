package com.app.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoleDao;
import com.app.dao.UserDao;
import com.app.domain.User;
import com.app.domain.role.UserRole;
import com.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	
	
	public void createUser(User user) {
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));	
	}
	
	public User findByUsername(String username) { 
		return userDao.findByUsername(username);
	}

	public User findByEmail(String email) { 
		return userDao.findByEmail(email);
	}

	public boolean checkUserExists(String username, String email) {
		if (checkUsernameExists(username) || checkEmailExists(username) ) 
			return true;
		else
			return false;
	}

	public boolean checkUsernameExists(String username) {
		if (null != findByUsername(username)) {
			return true;
		}
		return false;
	}

	public boolean checkEmailExists(String email) {	
		if (null != findByEmail(email)) {
			return true;
		}
		return false;
	}

	public void saveUser(User user) {	
		userDao.save(user);
	}

	public List<User> findUserList() {
		return (List<User>) userDao.findAll();
	}

	public void enableUser(String username) {	
		User user = findByUsername(username);
		user.setEnabled(true);
		userDao.save(user);
	}

	public void disableUser(String username) {	
		User user =  findByUsername(username);
		user.setEnabled(false);
		System.out.println(user.isEnabled());
		userDao.save(user);
		System.out.println(username + " is disabled.");
	}

}
