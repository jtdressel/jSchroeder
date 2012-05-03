package com.jamesdressel.schroeder.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {
	SubTransaction one;
	SubTransaction two;
	SubTransaction three;
	SubTransaction four;
	Transaction trans;
	Transaction secondTrans;
	Account from;
	Account to;
	
	@Before
	public void initialize(){
		from = new Account();
		to = new Account();
		
		one = new SubTransaction();
		two = new SubTransaction();
		three = new SubTransaction();
		four = new SubTransaction();
		
		one.setAccount(from);
		two.setAccount(to);
		
		three.setAccount(to);
		four.setAccount(from);
		
		one.setAmount(-32);
		two.setAmount(32);
		three.setAmount(9);
		four.setAmount(-9);	
		
		trans = new Transaction();
		trans.addSubTransaction(one);
		trans.addSubTransaction(two);
		
		secondTrans = new Transaction();
		secondTrans.addSubTransaction(three);
		secondTrans.addSubTransaction(four);
		
	}
	
	@Test
	public void testDefaultMemo() {
		Transaction example = new Transaction();
		assertEquals(example.getMemo(), "");	
	}
	
	@Test
	public void testGroceryMemo(){
		Transaction example = new Transaction();
		example.setMemo("Groceries");
		assertEquals("Groceries", example.getMemo());
	}
	
	@Test
	public void testSetSubTransactions(){
		trans.addSubTransaction(one);
		trans.addSubTransaction(two);
		
		assertTrue(trans.getSubTransactions().contains(one));
		assertTrue(trans.getSubTransactions().contains(two));
	}

	@Test
	public void testRemoveSubTransaction(){
		trans.addSubTransaction(one);
		trans.addSubTransaction(two);
		
		assertTrue(trans.getSubTransactions().contains(one));
		assertTrue(trans.getSubTransactions().contains(two));
	
		trans.removeSubTransaction(one);
		assertFalse(trans.getSubTransactions().contains(one));
		assertTrue(trans.getSubTransactions().contains(two));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveMissingSubTransaction(){
		trans.addSubTransaction(one);
		trans.addSubTransaction(two);
		SubTransaction aSubTransaction = new SubTransaction();
		
		assertFalse(trans.getSubTransactions().contains(aSubTransaction));
		trans.removeSubTransaction(aSubTransaction);
	}
	
	@Test
	public void testIsBalancedNotBalanced(){
		trans.addSubTransaction(one);
		trans.addSubTransaction(three);
		
		assertFalse(trans.isBalanced());
	}
	
	@Test
	public void testIsBalancedBalanced(){
		trans.addSubTransaction(one);
		trans.addSubTransaction(two);
		
		assertTrue(trans.isBalanced());
	}
	
	@Test
	public void testProcessHappyPath(){
		//Accounts should not have the transactions in them yet
		assertFalse(from.getTransactions().contains(trans));
		assertFalse(to.getTransactions().contains(trans));
		one.setAccount(from);
		two.setAccount(to);
		trans.addSubTransaction(one);
		trans.addSubTransaction(two);
		assertTrue(trans.isBalanced());//TODO remove this line, does not belong here. 
		
		trans.process();
		assertTrue(from.getTransactions().contains(trans));
		assertTrue(to.getTransactions().contains(trans));	
		
	}
}
