package com.app.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "primary_account")
public class PrimaryAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "primary_account_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "account_number")
	private int accountNumber;

	@Column(name = "account_balance")
	private BigDecimal accountBalance;

	// maps by class-name, not table-name
	@OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PrimaryTransaction> primaryTransactions;

	public PrimaryAccount() {
	}

	public PrimaryAccount(int accountNumber, BigDecimal accountBalance, List<PrimaryTransaction> primaryTransactions) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.primaryTransactions = primaryTransactions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<PrimaryTransaction> getPrimaryTransactions() {
		return primaryTransactions;
	}

	public void setPrimaryTransactions(List<PrimaryTransaction> primaryTransactions) {
		this.primaryTransactions = primaryTransactions;
	}

}
