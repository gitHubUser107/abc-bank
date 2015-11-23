package com.abc;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SavingsAccount extends Account{
	private static final BigDecimal one = new BigDecimal("1");
	private static final BigDecimal oneThousand = new BigDecimal("1000");
	private static final BigDecimal pointOnePercentRate = new BigDecimal("0.001");
	private static final BigDecimal pointTwoPercentRate = new BigDecimal("0.002");
	
	public SavingsAccount(BigDecimal _balance) {
		super(_balance);
		//balance = balance.add(_balance);	 
		//this.transactions = new ArrayList<Transaction>();
	}
	
	public BigDecimal interestEarned() {
//		Incorrect.  Interest earned should be based on balance, not transaction total..Fixed
//      BigDecimal amount = sumTransactions();                   
//      if(amount <= 1000)
//    	if(amount.compareTo(oneThousand) <= 0)
        if(getBalance().compareTo(oneThousand) <= 0)
//			return amount * 0.001;
//    		return amount.multiply(pointOnePercentRate);
        	return getBalance().multiply(pointOnePercentRate);
        else
//          return 1 + (amount-1000) * 0.002;
//        	return one.add(((amount.subtract(oneThousand)).multiply(pointTwoPercentRate)));        
        	return one.add(((getBalance().subtract(oneThousand)).multiply(pointTwoPercentRate)));
	}
}
