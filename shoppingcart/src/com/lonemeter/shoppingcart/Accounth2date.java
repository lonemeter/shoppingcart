package com.lonemeter.shoppingcart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Accounth2date {
	private Account loginuser;
	Connection cn;
	Statement st;
	ResultSet rs;

	
	public Accounth2date() {
		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection("jdbc:h2:tcp://localhost/c:/JDBC/meter","meter","123456");
			st = cn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean check(String name, String password){
		try {
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
