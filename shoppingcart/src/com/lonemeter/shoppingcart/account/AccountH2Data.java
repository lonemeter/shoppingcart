package com.lonemeter.shoppingcart.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class AccountH2Data {
	private AccountDAO loginuser;
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public boolean check(String name, String password){
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM User");
			while(rs.next()){
				if(rs.getString("UserName").equals(name) && rs.getString("password").equals(password)){
					AccountDAO user = new AccountDAO(rs.getString("UserName"),rs.getString("password"),rs.getDouble("money"));
					this.loginuser = user;
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean register(String name, String password){
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
			st = cn.createStatement();
			/*
			rs = st.executeQuery("SELECT * FROM ACCOUNT");
			while(rs.next()){
				if(rs.getString("name").equals(name)){
					return false;
				}
			}
			*/
			//Account user = new Account(name,password,0);
			st.executeUpdate("INSERT INTO User VALUES ('" + name + "','" + password + "',0.0)");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("µLªkµù¥U");
			e.printStackTrace();
			return false;
		}
	}
	
	public AccountDAO getLoginUser() {
		return loginuser;
	}
	
}
