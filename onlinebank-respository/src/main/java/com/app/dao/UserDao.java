package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.domain.User;

public interface UserDao extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}