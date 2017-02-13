package com.app.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "primary_transaction")
public class PrimaryTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "primary_transaction_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "description")
	private String description;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	private String status;

	@Column(name = "amount")
	private double amount;

	@Column(name = "available_balance")
	private BigDecimal availableBalance;

	@ManyToOne
	@JoinTable(name = "primary_account_id")
	private PrimaryAccount primaryAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public PrimaryAccount getPrimaryAccount() {
		return primaryAccount;
	}

	public void setPrimaryAccount(PrimaryAccount primaryAccount) {
		this.primaryAccount = primaryAccount;
	}

}
