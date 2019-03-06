package com.lonemeter.shoppingcart.good;

public class Goods{
	private String name;
	private  double price;
	private String photo;
	private String engname;
	
	

	Goods(){
		
	}
	
	Goods(String name, double price, String photo, String engname){
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.engname = engname;
	}
	


	public String getPhoto() {
		return photo;
	}


	public double getPrice() {
		return price;
	}


	public String getName() {
		return name;
	}
	
	public String getEngname() {
		return engname;
	}
	
}
