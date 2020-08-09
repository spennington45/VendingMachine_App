package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CustomerBalanceTest {

	CustomerBalance customer = new CustomerBalance();
	
	@Test
	public void getCurrentBalenceTest() {
		assertEquals(new BigDecimal(0), customer.getCurrentBalance());
	}

	@Test
	public void addToCurrentBalanceTest() {
		customer.addToCurrentBalance(new BigDecimal(3.15));
		assertEquals(new BigDecimal(3.15), customer.getCurrentBalance());
	}
	
	@Test
	public void subFromCurrentBalanceTest() {
		customer.addToCurrentBalance(new BigDecimal(3.15));
		customer.subFromCurrentBalance(new BigDecimal(1.50));
		assertEquals(new BigDecimal(1.65), customer.getCurrentBalance());
	}
	
}
