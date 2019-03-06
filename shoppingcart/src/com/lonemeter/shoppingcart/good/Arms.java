package com.lonemeter.shoppingcart.good;

public class Arms extends Goods {
	private double discount;

	public Arms(String name, double price, String photo, String engname){
		super(name, price, photo, engname);
	}
	
	public double getDiscount() {
		return discount;
	}

}
