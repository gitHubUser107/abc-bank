package com.abc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private  int accountType =0;
    private BigDecimal balance = new BigDecimal("0");
    
    private static final BigDecimal zero = new BigDecimal("0");
    private static final BigDecimal one = new BigDecimal("1");
    private static final BigDecimal twenty = new BigDecimal("20");
    private static final BigDecimal seventy = new BigDecimal("70");
    private static final BigDecimal oneThousand = new BigDecimal("1000");
    private static final BigDecimal twoThousand = new BigDecimal("2000");
    
    private static final BigDecimal pointOnePercentRate = new BigDecimal("0.001");
    private static final BigDecimal pointTwoPercentRate = new BigDecimal("0.002");
    private static final BigDecimal twoPercentRate = new BigDecimal("0.02");
    private static final BigDecimal fivePercentRate = new BigDecimal("0.05");
    private static final BigDecimal tenPercentRate = new BigDecimal("0.10");
    
    public List<Transaction> transactions;

    /**
    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }*/
    
    public Account(BigDecimal _balance) {
    	balance = balance.add(_balance);
    	this.transactions = new ArrayList<Transaction>();        
    } 

    public void deposit(BigDecimal amount) {
        //if (amount <= 0) {
        if(amount.compareTo(zero) <= 0){	
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
            balance = balance.add(amount);  
        }
    }

    public void withdraw(BigDecimal amount) {
    //if (amount <= 0) {
    	if(amount.compareTo(zero) <= 0){
    		throw new IllegalArgumentException("amount must be greater than zero");
    	} else {
    		//transactions.add(new Transaction(-amount));
    		transactions.add(new Transaction(amount.negate()));
    		balance = balance.subtract(amount);
    	}
    }

    public BigDecimal interestEarned() {    	
        BigDecimal amount = sumTransactions();
        switch(accountType){
            case SAVINGS:
//              if(amount <= 1000)
            	if(amount.compareTo(oneThousand) <= 0)
//					return amount * 0.001;
            		return amount.multiply(pointOnePercentRate);
                else
//                  return 1 + (amount-1000) * 0.002;
                	return one.add(((amount.subtract(oneThousand)).multiply(pointTwoPercentRate)));
//          case SUPER_SAVINGS:
//         		if (amount <= 4000)
//              	return 20;
            case MAXI_SAVINGS:
//            	if (amount <= 1000)
           		if(amount.compareTo(oneThousand) <= 0)
//					return amount * 0.02;
           			return amount.multiply(twoPercentRate);
//              if (amount <= 2000)
           		if(amount.compareTo(twoThousand) <= 0)
//                  return 20 + (amount-1000) * 0.05;
           			return twenty.add(((amount.subtract(oneThousand)).multiply(fivePercentRate)));
//              return 70 + (amount-2000) * 0.1;
           		return seventy.add(((amount.subtract(twoThousand)).multiply(tenPercentRate))); 
            default:
//              return amount * 0.001;
            	return amount.multiply(pointOnePercentRate);
        }
    }

    public BigDecimal sumTransactions() {
       return checkIfTransactionsExist(true);
    }
    // bad name for this method
    private BigDecimal checkIfTransactionsExist(boolean checkAll) {
        BigDecimal amount =  new BigDecimal("0");
        for (Transaction t: transactions)
            //amount += t.amount;
        	amount = amount.add(t.amount);
        return amount;
    }
    public BigDecimal getBalance() {
		return balance;
	}
    public void setBalance(BigDecimal _amount) {
		balance = _amount;
	}    
    
    public  String getAccountType() {
    	String str = this.getClass().getSimpleName();
    	String account_type = "";
    	if(str.equalsIgnoreCase("SavingsAccount"))
    		account_type = "Savings Account";
    	else if(str.equalsIgnoreCase("CheckingAccount"))
    		account_type = "Checking Account";
    	else
    		account_type = "Maxi Savings";
    	return account_type;
    }
    /**
    public int getAccountType() {
        return accountType;
    }*/
        
}
