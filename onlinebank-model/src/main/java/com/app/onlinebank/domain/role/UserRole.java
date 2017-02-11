package com.app.onlinebank.domain.role;

import com.app.onlinebank.domain.User;

public class UserRole {

	private Long userRoleId;
    private User user;
	private Role role;
	
	public UserRole() {
		
	}
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
