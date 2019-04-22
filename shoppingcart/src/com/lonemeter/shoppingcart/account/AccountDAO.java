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
	}
	
	@Override
	public void consume(String name, double money, double num) throws SQLException{
		jdbcTemplate.update("UPDATE User SET MONEY = MONEY-"+ num +" WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User WHERE UserName='"+name+"'");
		Iterator<Map<String, Object>>  it = rows.iterator();
		Map<String, Object> userMap = (Map<String, Object>)it.next();
		money = Double.parseDouble(userMap.get("MONEY").toString());
	}
	
	public void addOrders(String name) throws SQLException{
		jdbcTemplate.update("INSERT INTO ORDERS(UserName) VALUES ('"+name+"')");
	}
	
	public void addOrdersINFO(String name, Goods good) throws SQLException{
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT ORDERID FROM ORDERS WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows2 = jdbcTemplate.queryForList("SELECT GoodID FROM GOOD WHERE ENGNAME='"+good.getEngname()+"'");
		Map<String, Object> userMap = (Map<String, Object>) rows.get(rows.size()-1);
		Map<String, Object> userMap2 = (Map<String, Object>) rows2.get(rows2.size()-1);
		int OrderID =  Integer.parseInt(userMap.get("ORDERID").toString());
		int GoodID =  Integer.parseInt(userMap2.get("GoodID").toString());
		jdbcTemplate.update("INSERT INTO R1 VALUES ('"+OrderID+"','"+GoodID+"')");
	}
	
	public void changePassword(String name,String password, String newpassword) throws SQLException{
		jdbcTemplate.update("UPDATE User SET PASSWORD ='"+ newpassword +"' WHERE UserName='"+name+"'");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM User WHERE UserName='"+name+"'");
		Map<String, Object> userMap = (Map<String, Object>) rows.get(0);
		password = userMap.get("PASSWORD").toString();
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
	}
}
