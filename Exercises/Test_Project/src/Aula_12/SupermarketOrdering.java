package Aula_12;

import static java.lang.System.*;

public class SupermarketOrdering<E> {
	
	private KeyValueList<E>[] warehouse;
	private String key = "1";
	private int size = 0;
	
	// Create a new order
	public boolean enterOrder(Order order) {
		//boolean newelem = warehouse[size].set(key, order);
		//if (newelem) { size++; key++;}

		assert query(order.prodName);
		//return newelem;
		return false;
	}
	
	// liquidate the oldest order and returns it
	public void serveOrder(Order order) {
		
	}
	
	// returns the number of units of a given product that are filled in the current orders
	public boolean query(String product) {
		
		return false;
	}
	
	// prints all orders, by newest to oldest and the total number of units ordered of every product
	public void displayOrders() {
		
	}
}
