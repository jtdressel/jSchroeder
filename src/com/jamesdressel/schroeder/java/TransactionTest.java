package com.jamesdressel.schroeder.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

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
		SubTransaction one = new SubTransaction();
		SubTransaction two = new SubTransaction();
		one.setAmount(32432);
		two.setAmount(32);
		
		Transaction example = new Transaction();
		example.addSubTransaction(one);
		example.addSubTransaction(two);
		
		assertTrue(example.getSubTransactions().contains(one));
		assertTrue(example.getSubTransactions().contains(one));
	}

}
