package com.jamesdressel.schroeder.java;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.util.UUID;
import java.util.Dictionary;
import java.util.Hashtable;
/* The transaction class is used to represent a single transaction, such as 
 * buying groceries, or getting paid. There are at least two SubTransactions
 * one debiting an account, one crediting an account. In addition there is a 
 * memo line, date/time, and UUID.
 */
public class Transaction {
	Set<SubTransaction> subTransactions;
	String memo;
	UUID id;
	Date date;
	Dictionary<Device, Date> syncedDate;
	
	public Transaction(){
		subTransactions = new HashSet<SubTransaction>();
		memo = "";
		syncedDate = new Hashtable<Device, Date>();
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
	
	/**
	 * Removes a SubTransaction from the transaction.
	 * @param subTrans to be removed. 
	 * @throws IllegalArgumentException if subTrans is not in the transaction.
	 */
	public void removeSubTransaction(SubTransaction subTrans){
		if(!subTransactions.contains(subTrans)){
			throw new IllegalArgumentException("The provided subtransaction is not part of the transaction.");
		}
		
		subTransactions.remove(subTrans);
	}
	
	/**
	 * Test to see if all of the subTransactions balance. 
	 * @return true if the transaction is balanced, otherwise false.
	 */
	public boolean isBalanced(){
		long total = 0L;
		for(SubTransaction trans: subTransactions){
			total += trans.getAmount();
		}
		if(total == 0L){
			return true;
		}
		return false;
	}
	
	/**
	 * Takes the Transaction, checks that its balanced, and then adds it to the effected accounts. 
	 * @throws IllegalStateException if the transaction is not balanced
	 */
	public void process(){
		if(isBalanced()){
			for(SubTransaction sub: subTransactions){
				sub.getAccount().addTransaction(this);
			}
		} else {
			throw new IllegalStateException("Transactions must be balanced before they can be processed");
		}
	}
	
	public void sync(Device device){
		syncedDate.put(device, new Date());
		//TODO Add the actual synching code. Currently it just pretends. 
	}
}
