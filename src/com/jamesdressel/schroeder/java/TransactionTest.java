package com.jamesdressel.schroeder.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void testDefaultMemo() {
		Transaction example = new Transaction();
		assertEquals(example.getMemo(), "");
	}

}
