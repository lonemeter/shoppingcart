package com.lonemeter.shoppingcart.account;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lonemeter.shoppingcart.sql.AddSQL;
import com.lonemeter.shoppingcart.sql.GetSQLPath;

public class Accounth2date {
	private Account loginuser;
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public boolean check(String name, String password){
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","METER","123456");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM ACCOUNT");
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