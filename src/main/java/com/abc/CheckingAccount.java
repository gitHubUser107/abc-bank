package com.abc;

import java.math.BigDecimal;

public class CheckingAccount extends Account{
	
	private static final BigDecimal pointOnePercentRate = new BigDecimal("0.001");

	public CheckingAccount(BigDecimal balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal interestEarned() {
//      BigDecimal amount = sumTransactions();
//		Incorrect.  Interest earned should be based on balance, not transaction total..Fixed        
// 		return amount * 0.001;
//      return amount.multiply(pointOnePercentRate);
        return getBalance().multiply(pointOnePercentRate);
	}

}
