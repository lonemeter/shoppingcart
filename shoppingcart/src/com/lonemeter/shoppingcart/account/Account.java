package com.lonemeter.shoppingcart.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account implements Store, Consume{
	private String name;
	private String password;
	private double money;
	Account(String name, String password, double money){
		this.name = name;
		this.password = password;
		this.money = money;
	}
	@Override
	public void Store(double num) throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","meter","123456");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE ACCOUNT SET MONEY = MONEY+"+ num +" WHERE NAME='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNT WHERE NAME='"+this.name+"'");
		rs.next();
		this.money = rs.getDouble("MONEY");
		//this.money += num;
	}
	@Override
	public void Consume(double num) throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","meter","123456");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE ACCOUNT SET MONEY = MONEY-"+ num +" WHERE NAME='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNT WHERE NAME='"+this.name+"'");
		rs.next();
		this.money = rs.getDouble("MONEY");
		//this.money -= num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
}
