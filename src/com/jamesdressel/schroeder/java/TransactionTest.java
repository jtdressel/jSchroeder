package com.jamesdressel.schroeder.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {
	SubTransaction one;
	SubTransaction two;
	Transaction example;
	
	@Before
	public void initialize(){
		one = new SubTransaction();
		two = new SubTransaction();
		one.setAmount(32432);
		two.setAmount(32);
		
		example = new Transaction();
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
		example.addSubTransaction(one);
		example.addSubTransaction(two);
		
		assertTrue(example.getSubTransactions().contains(one));
		assertTrue(example.getSubTransactions().contains(two));
	}

	@Test
	public void testRemoveSubTransaction(){
		example.addSubTransaction(one);
		example.addSubTransaction(two);
		
		assertTrue(example.getSubTransactions().contains(one));
		assertTrue(example.getSubTransactions().contains(two));
	
		example.removeSubTransaction(one);
		assertFalse(example.getSubTransactions().contains(one));
		assertTrue(example.getSubTransactions().contains(two));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveMissingSubTransaction(){
		example.addSubTransaction(one);
		example.addSubTransaction(two);
		SubTransaction aSubTransaction = new SubTransaction();
		
		assertFalse(example.getSubTransactions().contains(aSubTransaction));
		example.removeSubTransaction(aSubTransaction);
	}
	
	@Test
	public void testIsBalancedNotBalanced(){
		
	}
	
}
