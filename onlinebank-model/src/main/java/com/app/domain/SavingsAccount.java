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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "savings_account")
public class SavingsAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "savings_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "account_balance")
	private BigDecimal accountBalance;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	// maps by class-name, not table-name
	@OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SavingsTransaction> savingsTransactionList;

	public SavingsAccount() {
	}
	
	public SavingsAccount( BigDecimal accountBalance ) {
		setAccountNumber();
		setAccountBalance( accountBalance );
	}

	public SavingsAccount(String accountNumber, BigDecimal accountBalance,
			List<SavingsTransaction> savingsTransactionList) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.savingsTransactionList = savingsTransactionList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber() {
		String acctNum = "S01000090329";
		this.accountNumber = acctNum;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<SavingsTransaction> getSavingsTransactionList() {
		return savingsTransactionList;
	}

	public void setSavingsTransactionList(List<SavingsTransaction> savingsTransactionList) {
		this.savingsTransactionList = savingsTransactionList;
	}
	
}
