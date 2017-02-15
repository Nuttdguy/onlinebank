package com.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recipient")
public class Recipient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipient_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	public Recipient() {
	}
	
	public Recipient(String name, String email, String phone, String accountNumber, String description) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountNumber = accountNumber;
		this.description = description;
	}

	public Recipient(String name, String email, String phone, String accountNumber, String description, User user) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountNumber = accountNumber;
		this.description = description;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
