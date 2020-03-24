package com.tavisca.test.order;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.tavisca.test.model.beverages.Beverage;
import com.tavisca.test.model.ingredients.Ingredient;

public class OrderProcessor {

	Order order = new Order();
	ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public void processOrder(Beverage beverage) {
		readWriteLock.readLock().lock();
		try {		
			if (null != beverage) {
				order.getOrderMap().put(beverage, null);
			}
		} catch(Exception e) {	
			System.out.println(e.getMessage());		
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

	public void processOrder(Beverage beverage, List<Ingredient> list) {
		readWriteLock.readLock().lock();	
		try {		
			if (null != beverage) {
				order.getOrderMap().put(beverage, list);	
			}
		} catch(Exception e) {	
			System.out.println(e.getMessage());		
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

	public double getOrderPrice() {
		double price = 0;
		for (Entry<Beverage, List<Ingredient>> entry : order.getOrderMap().entrySet()) {
			price += entry.getKey().getCost();
			if (entry.getValue() != null) {
				price -= entry.getValue().stream().mapToDouble(Ingredient::getCost).sum();
			} 
		}
		return price;
	}


	public int getNumberOfItemsInOrder() {
		return order.getOrderMap().size();
	}
}
