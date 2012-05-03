package com.jamesdressel.schroeder.java;

import java.util.UUID;
import java.util.Set;
import java.util.HashSet;


public class Account {
	private UUID id;
	private String name;
	private Set<Transaction> transactions;
	
	
	public Account(){
		setName("");
		id = UUID.randomUUID();
		transactions = new HashSet<Transaction>();
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
	
	public UUID getID(){
		return id;
	}
	
	public void addTransaction(Transaction trans){
		
	}
	
	public Set getTransactions(){
		return null;
	}
	

	
	
}
