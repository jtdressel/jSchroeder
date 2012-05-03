package com.jamesdressel.schroeder.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AccountTest {
	SubTransaction one;
	SubTransaction two;
	SubTransaction three;
	SubTransaction four;
	Transaction trans;
	Transaction secondTrans;
	Account from;
	Account to;
	
	@Before
	public void initalize(){
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
	public void testAddTransaction() {
		to.addTransaction(trans);
		assertTrue(to.getTransactions().contains(trans));
	}
	
	
}
