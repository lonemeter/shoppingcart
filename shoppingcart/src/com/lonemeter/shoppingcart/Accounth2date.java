package com.lonemeter.shoppingcart;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import sql.AddSQL;
import sql.SearchSQLPath;

public class Accounth2date {
	private Account loginuser;
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public Accounth2date() throws InstantiationException, IllegalAccessException ,IOException{
		new AddSQL("Account.sql");
	}
	
	public boolean check(String name, String password){
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","geordie","1234");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM GEORDIE");
			while(rs.next()){
				if(rs.getString("name").equals(name) && rs.getString("password").equals(password)){
					Account user = new Account(rs.getString("name"),rs.getString("password"),rs.getDouble("money"));
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

	public Account getLoginuser() {
		return loginuser;
	}
	
}
