package com.abc;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new CheckingAccount(new BigDecimal("0.0")));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new CheckingAccount(new BigDecimal("0.0"));
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(new BigDecimal("100.0"));
        
//      assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
        assertEquals(new BigDecimal("0.1000"), bank.totalInterestPaid());
    }    

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account savingsAccount = new SavingsAccount(new BigDecimal("0.0"));
        bank.addCustomer(new Customer("Bill").openAccount(savingsAccount));

        savingsAccount.deposit(new BigDecimal("1500.0"));
        
//		assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
        assertEquals(new BigDecimal("2.0000"), bank.totalInterestPaid());
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account maxiSavingsAccount = new MaxiSavingsAccount(new BigDecimal("0.0"));
                                         
        bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccount));

        maxiSavingsAccount.deposit(new BigDecimal("3000.0"));
        
//		assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
        assertEquals(new BigDecimal("170.000"), bank.totalInterestPaid());
    }
}
