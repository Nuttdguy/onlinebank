package com.app.onlinebank.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.onlinebank.domain.role.UserRole;


public class User {

	private Long userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	private String email;
	private String phone;
	
	private PrimaryAccount primaryAccount;
	
	private SavingsAccount savingsAccount;
	
	private List<Appointment> appointmentList;
	
	private List<Recipient> recipientList;
	
	private Set<UserRole> userRoles = new HashSet<>();
	
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }
	
}
