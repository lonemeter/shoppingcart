package com.lonemeter.shoppingcart.good;

public class Arms extends Goods {
	private double discount;

	public Arms(String category, String name, double price, String photo, String engname){
		super(category, name, price, photo, engname);
	}
	
	public double getDiscount() {
		return discount;
	}

}
