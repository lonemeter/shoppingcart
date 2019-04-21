package com.lonemeter.shoppingcart.other;

public class Order {
	private int orderID;
	private String userName;

	public Order(int orderID, String userName) {
		this.orderID = orderID;
		this.userName = userName;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public String getUserName() {
		return userName;
	}
}
