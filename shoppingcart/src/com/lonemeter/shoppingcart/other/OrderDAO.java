package com.lonemeter.shoppingcart.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonemeter.shoppingcart.good.Goods;
@Component
public class OrderDAO {
	@Autowired
	static JdbcTemplate jdbcTemplate;
	
	public static List<Order> getOrders() throws SQLException{
		List<Order> orders = new ArrayList<>();
		
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM ORDERS");
		while(rs.next()) {
			orders.add(new Order(rs.getInt("ORDERID"),rs.getString("UserName")));
		}
		return orders;
		/*
		List<Order> orders = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM ORDERS");
		Iterator<Map<String, Object>> it = rows.iterator();
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) it.next();
			orders.add(new Order(Integer.parseInt(userMap.get("ORDERID").toString()),userMap.get("UserName").toString()));
		}
		return orders;
		*/
	}
	
	public static List<Goods> getOrderInfo(int orderID) throws SQLException{
		List<Goods> orderInfo = new ArrayList<>();
		
		Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM R1 WHERE ORDERID = "+orderID);
		while(rs.next()) {
			int goodID = rs.getInt("GoodID");
			Statement st2 = cn.createStatement();
			ResultSet rs2 = st2.executeQuery("SELECT * FROM GOOD WHERE GoodID = "+ goodID);
			rs2.next();
			int categoryID = rs2.getInt("categoryID");
			Statement st3 = cn.createStatement();
			ResultSet rs3 = st3.executeQuery("SELECT * FROM CATEGORY WHERE CategoryID = "+ categoryID);
			rs3.next();
			String category = rs3.getString("CategoryName");
			Goods good = new Goods(
					category, 
					rs2.getString("name"), 
					rs2.getDouble("price"), 
					rs2.getString("photo"), 
					rs2.getString("engname")
					);
			orderInfo.add(good);
		}
		return orderInfo;
	}
}
