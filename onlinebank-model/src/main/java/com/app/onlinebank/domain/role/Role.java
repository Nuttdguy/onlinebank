package com.app.onlinebank.domain.role;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private int roleId;
	private String name;
	private Set<UserRole> userRoles = new HashSet<>();	
	
}
