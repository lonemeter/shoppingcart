package com.lonemeter.shoppingcart.account;

public class AccountInfo {
	private String name;
	private String password;
	private double money;
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public double getMoney() {
		return money;
	}
	public AccountInfo() {}
	public AccountInfo(String name, String password, double money){
		this.name = name;
		this.password = password;
		this.money = money;
	}
	
	public void store(double storemoney) {
		this.money += storemoney;
	}
	public void consum(double sum) {
		// TODO Auto-generated method stub
		this.money -= sum;
	}
	public void changePassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
}
