package com.lonemeter.shoppingcart.good;

public class Armor extends Goods{
	private double discount;
	
	public Armor(String category, String name, double price, String photo, String engname){
		super(category, name, price, photo, engname);
	}
	
	public double getDiscount() {
		return discount;
	}

}

