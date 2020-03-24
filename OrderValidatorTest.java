package com.tavisca.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tavisca.test.model.beverages.Chai;
import com.tavisca.test.model.ingredients.Ingredient;
import com.tavisca.test.model.ingredients.Milk;
import com.tavisca.test.model.ingredients.Sugar;
import com.tavisca.test.model.ingredients.Water;
import com.tavisca.test.order.OrderValidator;

public class OrderValidatorTest {
	
	@Test
	public void testInvalidOrder() {
		List<Ingredient> list = new ArrayList<Ingredient>();
		list.add(new Water());
		list.add(new Sugar());
		list.add(new Milk());
		
		assertFalse(OrderValidator.isValidOrder(new Chai().getIngredients(), list));
	}
	
	@Test
	public void testValidOrder() {
		List<Ingredient> list = new ArrayList<Ingredient>();
		list.add(new Water());
		list.add(new Sugar());
		
		assertTrue(OrderValidator.isValidOrder(new Chai().getIngredients(), list));
	}

}
