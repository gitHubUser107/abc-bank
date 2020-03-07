package com.abc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InsufficientResourcesException;

import static java.lang.Math.abs;


/**This should just be a customer model.  Why so many business logic here??*/
public class Customer {
	
	private static final BigDecimal zero = new BigDecimal("0");
    
	private String name;
    
	private List<Account> accounts;


    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }
    /**
    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }*/

    public BigDecimal totalInterestEarned() {
        BigDecimal total = new BigDecimal("0");
        for (Account a : accounts){
//			total += a.interestEarned();
        	System.out.println("Interest earned for " + a.getAccountType() + " is " +  toDollars(a.interestEarned()));
        	
        	total = total.add(a.interestEarned());}
        return total;
    }
    /**
     * This method generates a statement for for each customers account
     * @return
     */
    public String getStatement() {
    	String statement =  "Statement for " + getName() + "\n";
//      BigDecimal total = new BigDecimal("0");
        BigDecimal _balance = new BigDecimal("0");
       
        for (Account a : accounts) {        	
            statement += "\n" + statementForAccount(a) + "\n";
//          total += a.sumTransactions();
//			total = total.add(a.sumTransactions());
			_balance = _balance.add(a.getBalance());
        }              
//		This is incorrect.  Total in all accounts changed to balance
//		statement += "\nTotal In All Accounts " + toDollars(total);
        statement += "\nTotal In All Accounts " + toDollars(_balance)+ "\n";
        return statement;
    }
    
    /** 
     * This method sums up all the transactions for a customers account
     * @param Account
     * @return
     */
    private String statementForAccount(Account a) {
        String s = "";
       //Translate to pretty account type                               
/**     switch(a.getAccountType()){
            case Account.CHECKING:
                s += "Checking Account\n";
                break;
            case Account.SAVINGS:
                s += "Savings Account\n";
                break;
            case Account.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;        }   
*/    
        s+= a.getAccountType() + "\n";
        //Now total up all the transactions
//      double total = 0.0;
        BigDecimal total = new BigDecimal("0");
        for (Transaction t : a.transactions) {
            s += "  " + (/**t.amount < 0*/(t.amount).compareTo(zero) < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
//          if(t.amount < 0){
            if((t.amount).compareTo(zero) < 0)
//            	total -= t.amount;}
            	total = total.subtract(t.amount);
            else
//            	total += t.amount;
            	total = total.add(t.amount);
        }          
// 			s += "Total sum of all transactions " + toDollars(total);
//        	s += "Total sum in " + a.getAccountType() + " is " + toDollars(a.getBalance());
        	s += "Total " + toDollars(a.getBalance());
        return s;
    }    

    public  String toDollars(BigDecimal d){
    	return String.format("$%,.2f", d);
//      return String.format("$%,.2f", abs(d));
    }
    /**
     * This method transfers funds between a customers account
     * @param source
     * @param destination
     * @param amount
     */
	public void transferFunds(Account source, Account destination, BigDecimal amount) {			
		if(amount.compareTo(source.getBalance()) > 0){
			System.out.println("Insufficient funds \n");
		}
		else{
			
			source.setBalance(source.getBalance().subtract(amount));
			destination.setBalance(destination.getBalance().add(amount));
			
			System.out.println("Amount successfully transfered \n");
		}
	}
}
