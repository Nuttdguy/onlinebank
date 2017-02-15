package com.app.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.domain.role.Authority;
import com.app.domain.role.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_table")
public class User implements UserDetails {

	private static final long serialVersionUID = 1770572064258133985L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "enabled")
	private boolean enabled = true;

	@OneToOne(cascade = CascadeType.ALL)
	private PrimaryAccount primaryAccount;

	@OneToOne(cascade = CascadeType.ALL)
	private SavingsAccount savingsAccount;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Transient
	private List<Appointment> appointmentList;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Transient
	private List<Recipient> recipientList;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Transient
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

	public User() {
	}

	public User(String username, String password, String firstName, String lastName, String email, String phone,
			boolean enabled) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
	}

	public User(String username, String password, String firstName, String lastName, String email, String phone,
			boolean enabled, PrimaryAccount primaryAccount, SavingsAccount savingsAccount,
			List<Appointment> appointmentList, List<Recipient> recipientList, Set<UserRole> userRoles) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.primaryAccount = primaryAccount;
		this.savingsAccount = savingsAccount;
		this.appointmentList = appointmentList;
		this.recipientList = recipientList;
		this.userRoles = userRoles;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public Long getUserId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PrimaryAccount getPrimaryAccount() {
		return primaryAccount;
	}

	public void setPrimaryAccount(PrimaryAccount primaryAccount) {
		this.primaryAccount = primaryAccount;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public List<Recipient> getRecipientList() {
		return recipientList;
	}

	public void setRecipientList(List<Recipient> recipientList) {
		this.recipientList = recipientList;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return id + " - " + username + " - " + password + " - " + firstName + " - " + lastName + " - " + email
				+ " - " + phone + " - " + enabled + " - " + primaryAccount + " - " + savingsAccount + " - "
				+ appointmentList + " - " + recipientList + " - " + userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
