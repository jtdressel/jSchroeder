package com.jamesdressel.schroeder.java;

/**
 * SubTransactions make up Transactions. A Transaction requires at least one 
 * SubTransacton debiting an account, and one depositing to another account.
 * @author jtdressel
 *
 */
public class SubTransaction {
	long amount;
	Account account;
	
	
	public SubTransaction(){
		amount = 0L;
	}
	
	public long getAmount(){
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
		
	}
	
	public void setAccount(Account account){
		
	}
	
	public Account getAccount(){
		return null;
	}
	
}
