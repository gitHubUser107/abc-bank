package com.abc;

import java.math.BigDecimal;

public class MaxiSavingsAccount extends Account{
	
	private static final BigDecimal twenty = new BigDecimal("20");
	private static final BigDecimal seventy = new BigDecimal("70");
	private static final BigDecimal oneThousand = new BigDecimal("1000");
	private static final BigDecimal twoThousand = new BigDecimal("2000");
	
	private static final BigDecimal twoPercentRate = new BigDecimal("0.02");
	private static final BigDecimal fivePercentRate = new BigDecimal("0.05");
	private static final BigDecimal tenPercentRate = new BigDecimal("0.10");
		

	public MaxiSavingsAccount(BigDecimal _balance) {
		super(_balance);
		//balance = balance.add(_balance);	 
		//this.transactions = new ArrayList<Transaction>();
	}
	
	public BigDecimal interestEarned() {
//      BigDecimal amount = sumTransactions();       
//		Incorrect.  Interest earned should be based on balance, not transaction total..Fixed      
//		if (amount <= 1000)
//     	if(amount.compareTo(oneThousand) <= 0)
		if(getBalance().compareTo(oneThousand) <= 0)
//			return amount * 0.02;
//     		return amount.multiply(twoPercentRate);
			return getBalance().multiply(twoPercentRate);
//      if (amount <= 2000)
//     	if(amount.compareTo(twoThousand) <= 0)
		else if(getBalance().compareTo(twoThousand) <= 0)
//          return 20 + (amount-1000) * 0.05;
//     		return twenty.add(((amount.subtract(oneThousand)).multiply(fivePercentRate)));
	 		return twenty.add(((getBalance().subtract(oneThousand)).multiply(fivePercentRate)));
//      return 70 + (amount-2000) * 0.1;
//     	return seventy.add(((amount.subtract(twoThousand)).multiply(tenPercentRate))); 
		else 
			return seventy.add(((getBalance().subtract(twoThousand)).multiply(tenPercentRate))); 
   }
}
