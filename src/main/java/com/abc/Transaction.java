package com.abc;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
	
//  public final double amount;
    public BigDecimal  amount = new BigDecimal("0");

    private Date transactionDate;

    public Transaction(BigDecimal _amount) {
        amount = amount.add(_amount);
        this.transactionDate = DateProvider.getInstance().now();
    }
    
    /**
    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }*/

}
