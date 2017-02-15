package com.app.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.domain.User;
import com.app.domain.role.UserRole;
import com.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public void createUser(User user) {
//		User localUser = userDao.findByUsername(user.getUsername());
		
//		if (localUser != null) {
//			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
//		} else {
//			String encryptedPassword = passwordEncoder.encode(user.getPassword() );
//			user.setPassword(encryptedPassword);
			
//			for (UserRole ur : userRoles ) {
//				roleDao.save(ur.getRole());
//			}
//			user.getUserRoles().addAll(userRoles());
			
//			user.setPrimaryAccount(accountService.createPrimaryAccount());
//			user.setSavingsAccount(accountService.createSavingsAccount());
			
//			localUser = 
					userDao.save(user);
			
//		}
	}
	
	public User findByUsername(String username) { 
		return userDao.findByUsername(username);
	}

	public User findByEmail(String email) { 
		return userDao.findByEmail(email);
	}

//	public boolean checkUserExists(String username, String email) {
//		if (checkUsernameExists(username) || checkEmailExists(email) ) 
//			return true;
//		else
//			return false;
//	}

	public boolean checkUsernameExists(User user) {
		if (null != findByUsername(user.getUsername())) {
			return true;
		}
		return false;
	}

	public boolean checkEmailExists(User user) {	
		if (null != findByEmail(user.getEmail())) {
			return true;
		}
		return false;
	}

	public void saveUser(User user) {	
		userDao.save(user);
	}

//	public List<User> findUserList() {
//		return (List<User>) userDao.findAll();
//	}

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
