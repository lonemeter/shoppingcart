package com.lonemeter.shoppingcart.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonemeter.shoppingcart.good.Goods;
@Component
public class AccountDAO implements Account{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void store(String name, double money, double num) throws SQLException{
		jdbcTemplate.update("UPDATE User SET MONEY = MONEY+"+ num +" WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User WHERE UserName='"+name+"'");
		Iterator<Map<String, Object>>  it = rows.iterator();
		Map<String, Object> userMap = (Map<String, Object>)it.next();
		money = Double.parseDouble(userMap.get("MONEY").toString());
		/*
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE User SET MONEY = MONEY+"+ num +" WHERE UserName='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE UserName='"+this.name+"'");
		rs.next();
		this.money = rs.getDouble("MONEY");
		//this.money += num;
		 */
	}
	
	@Override
	public void consume(String name, double money, double num) throws SQLException{
		jdbcTemplate.update("UPDATE User SET MONEY = MONEY-"+ num +" WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User WHERE UserName='"+name+"'");
		Iterator<Map<String, Object>>  it = rows.iterator();
		Map<String, Object> userMap = (Map<String, Object>)it.next();
		money = Double.parseDouble(userMap.get("MONEY").toString());
		/*
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE User SET MONEY = MONEY-"+ num +" WHERE UserName='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE UserName='"+this.name+"'");
		rs.next();
		this.money = rs.getDouble("MONEY");
		//this.money -= num;
		 */
	}
	
	public void addOrders(String name) throws SQLException{
		jdbcTemplate.update("INSERT INTO ORDERS(UserName) VALUES ('"+name+"')");

		/*
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("INSERT INTO ORDERS(UserName) VALUES ('"+this.name+"')");
		*/
	}
	
	public void addOrdersINFO(String name, Goods good) throws SQLException{
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT ORDERID FROM ORDERS WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows2 = jdbcTemplate.queryForList("SELECT GoodID FROM GOOD WHERE ENGNAME='"+good.getEngname()+"'");
		Map<String, Object> userMap = (Map<String, Object>) rows.get(rows.size()-1);
		Map<String, Object> userMap2 = (Map<String, Object>) rows2.get(rows2.size()-1);
		int OrderID =  Integer.parseInt(userMap.get("ORDERID").toString());
		int GoodID =  Integer.parseInt(userMap2.get("GoodID").toString());
		jdbcTemplate.update("INSERT INTO R1 VALUES ('"+OrderID+"','"+GoodID+"')");
		
		/*
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
		*/
	}
	
	public void changePassword(String name,String password, String newpassword) throws SQLException{
		jdbcTemplate.update("UPDATE User SET PASSWORD ='"+ newpassword +"' WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User WHERE UserName='"+name+"'");
		Map<String, Object> userMap = (Map<String, Object>) rows.get(0);
		password = userMap.get("PASSWORD").toString();
		/*
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		st.executeUpdate("UPDATE User SET PASSWORD ='"+ newpassword +"' WHERE UserName='"+this.name+"'");
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE UserName='"+this.name+"'");
		rs.next();
		this.password = rs.getString("PASSWORD");
		*/
	}
	
	public double getLoginUserMoney(String name, String password) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User");
		Iterator<Map<String, Object>>  it = rows.iterator(); 
		double money = 0;
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) it.next();
			if(userMap.get("UserName").toString().equals(name) && userMap.get("password").toString().equals(password)){
				money = Double.parseDouble(userMap.get("money").toString());
			}
		}
		return money;
	}
	
	public boolean check(String name, String password){
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User");
		Iterator<Map<String, Object>>  it = rows.iterator(); 
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) it.next();
			if(userMap.get("UserName").toString().equals(name) && userMap.get("password").toString().equals(password)){
				return true;
			}
		}
		return false;
		/*
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM User");
			while(rs.next()){
				if(rs.getString("UserName").equals(name) && rs.getString("password").equals(password)){
					AccountInfo user = new AccountInfo(rs.getString("UserName"),rs.getString("password"),rs.getDouble("money"));
					this.loginuser = user;
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		*/
	}
	
	public boolean register(String name, String password){
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User");
		Iterator<Map<String, Object>>  it = rows.iterator(); 
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) it.next();
			if(userMap.get("username").toString().equals(name)){
				return false;
			}
		}
		jdbcTemplate.update("INSERT INTO User VALUES ('" + name + "','" + password + "',0.0)");
		return true;
		/*
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
			//Account user = new Account(name,password,0);
			st.executeUpdate("INSERT INTO User VALUES ('" + name + "','" + password + "',0.0)");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("µLªkµù¥U");
			e.printStackTrace();
			return false;
		}
		*/
	}
}
