package com.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.domain.role.Role;


public interface RoleDao extends CrudRepository<Role, Integer>{

	Role findByName(String name);
	
}
