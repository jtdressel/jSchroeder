package com.jamesdressel.schroeder.java;

public class SubTransaction {
	long amount;
	
	public SubTransaction(){
		amount = 0L;
	}
	
	public long getAmount(){
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
		
	}
	
}
