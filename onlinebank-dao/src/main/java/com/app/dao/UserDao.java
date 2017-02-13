package com.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.domain.User;


public interface UserDao extends CrudRepository<User, Long> {
	
//	@Query("select u from User u where u = u.firstName")
	User findByUsername(String username);
	
//	@Query("select u from User u where u = u.email")
	User findByEmail(String email);
}
