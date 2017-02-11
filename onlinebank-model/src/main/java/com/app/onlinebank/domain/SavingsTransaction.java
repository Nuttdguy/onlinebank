package com.app.onlinebank.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SavingsTransaction {

	private Long id;
	private Date date;
	private String description;
	private String type;
	private String status;
	private double amount;
	private BigDecimal availableBalance;
	
	private SavingsAccount savingsAccount;
}
