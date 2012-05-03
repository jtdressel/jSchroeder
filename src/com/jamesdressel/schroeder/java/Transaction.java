package com.jamesdressel.schroeder.java;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.util.UUID;

/* The transaction class is used to represent a single transaction, such as 
 * buying groceries, or getting paid. There are at least two SubTransactions
 * one debiting an account, one crediting an account. In addition there is a 
 * memo line, date/time,  and guid.
 */
public class Transaction {
	Set<SubTransaction> subTransactions;
	String memo;
	UUID id;
	Date date;
	
	public Transaction(){
		subTransactions = new HashSet<SubTransaction>();
		memo = "";
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	public void addSubTransaction(SubTransaction subTrans){
		subTransactions.add(subTrans);
	}
	
	public Set<SubTransaction> getSubTransactions(){
		return subTransactions;
	}
	
	
}
