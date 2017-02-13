package com.app.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
//		Set<UserRole> userRoles = new HashSet<>();
//		userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));	
	}
	
	public User findByUsername(String username) { 
		return userRepository.findByUsername(username);
	}

	public User findByEmail(String email) { 
		return userRepository.findByEmail(email);
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
		userRepository.save(user);
	}

	public List<User> findUserList() {
		return (List<User>) userRepository.findAll();
	}

	public void enableUser(String username) {	
		User user = findByUsername(username);
		user.setEnabled(true);
		userRepository.save(user);
	}

	public void disableUser(String username) {	
		User user =  findByUsername(username);
		user.setEnabled(false);
		System.out.println(user.isEnabled());
		userRepository.save(user);
		System.out.println(username + " is disabled.");
	}

}
