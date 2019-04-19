package com.lonemeter.shoppingcart.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import com.lonemeter.shoppingcart.good.Goods;

public class AccountDAO implements Account{
	private String name;
	private String password;
	private double money;
	public AccountDAO(String name, String password, double money){
		this.name = name;
		this.password = password;
		this.money = money;
	}
	@Override
	public void store(double num) throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE User SET MONEY = MONEY+"+ num +" WHERE UserName='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE UserName='"+this.name+"'");
		rs.next();
		this.money = rs.getDouble("MONEY");
		//this.money += num;
	}
	@Override
	
	public void consume(double num) throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE User SET MONEY = MONEY-"+ num +" WHERE UserName='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE UserName='"+this.name+"'");
		rs.next();
		
		
		
		this.money = rs.getDouble("MONEY");
		//this.money -= num;
	}
	
	public void addOrders() throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("INSERT INTO ORDERS(UserName) VALUES ('"+this.name+"')");

	}
	
	public void addOrdersINFO(Goods good) throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		Statement st2 = cn.createStatement();
		Statement st3 = cn.createStatement();
		ResultSet rs2 = st2.executeQuery("SELECT ORDERID FROM ORDERS WHERE UserName='"+this.name+"'");
		ResultSet rs3 = st3.executeQuery("SELECT GoodID FROM GOOD WHERE ENGNAME='"+good.getEngname()+"'");
		rs2.last();
		rs3.last();
		int OrderID =  rs2.getInt("ORDERID");
		int GoodID =  rs3.getInt("GoodID");
		st.executeUpdate("INSERT INTO R1 VALUES ('"+OrderID+"','"+GoodID+"')");
	}
	
	public void changePassword(String newpassword) throws SQLException{
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE User SET PASSWORD ='"+ newpassword +"' WHERE UserName='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE UserName='"+this.name+"'");
		rs.next();
		this.password = rs.getString("PASSWORD");
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
