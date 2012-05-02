package com.jamesdressel.schroeder.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubTransactionTest {

	@Test
	public void testDefaultAmountZero() {
		SubTransaction anExample = new SubTransaction();
		assertEquals(anExample.getAmount(),0L);
	}
	
	@Test
	public void testAmountMore(){
		SubTransaction anExample = new SubTransaction();
		anExample.setAmount(3L);
		assertEquals(anExample.getAmount(), 3L);
	}



}
