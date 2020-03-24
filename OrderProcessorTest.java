package com.tavisca.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tavisca.test.model.beverages.Chai;
import com.tavisca.test.order.OrderProcessor;

public class OrderProcessorTest {
	
	OrderProcessor orderProcessor;
	
	@BeforeEach
    public void setUp() {
		orderProcessor = new OrderProcessor();
    }
	
	@Test
	public void testOrderProcessorWithNullBeverage() {
		orderProcessor.processOrder(null);
		assertEquals(0, orderProcessor.getNumberOfItemsInOrder());
	}
	
	@Test
	public void testOrderProcessorWithValidBeverage() {
		orderProcessor.processOrder(new Chai());
		assertEquals(1, orderProcessor.getNumberOfItemsInOrder());
	}

	@Test
	public void testGetOrderPrice() {
		Chai chai = new Chai();
		orderProcessor.processOrder(chai);
		assertEquals(chai.getCost(), orderProcessor.getOrderPrice());
	}

}
