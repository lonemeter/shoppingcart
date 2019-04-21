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
	JdbcTemplate jdbcTemplate;
	
	public List<Order> getOrders() throws SQLException{
		List<Order> orders = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM ORDERS");
		Iterator<Map<String, Object>> it = rows.iterator();
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) it.next();
			orders.add(new Order(Integer.parseInt(userMap.get("ORDERID").toString()),userMap.get("UserName").toString()));
		}
		return orders;
	}
	
	public List<Goods> getOrderInfo(int orderID) throws SQLException{
		List<Goods> orderInfo = new ArrayList<>();
		List<Map<String, Object>> rowsOfR1 = jdbcTemplate.queryForList("SELECT * FROM R1 WHERE ORDERID ="+orderID);
		Iterator<Map<String, Object>> itR1 = rowsOfR1.iterator();
		while(itR1.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) itR1.next();
			int goodID = Integer.parseInt(userMap.get("GoodID").toString());
			
			List<Map<String, Object>> rowsOfGood = jdbcTemplate.queryForList("SELECT * FROM GOOD WHERE GoodID = "+ goodID);
			Iterator<Map<String, Object>> itGood = rowsOfGood.iterator();
			Map<String, Object> userMap2 = (Map<String, Object>) itGood.next();
			//取得分類ID
			int categoryID = Integer.parseInt(userMap2.get("categoryID").toString());
			
			List<Map<String, Object>> rowsOfCategory = jdbcTemplate.queryForList("SELECT * FROM CATEGORY WHERE CategoryID = "+ categoryID);
			Iterator<Map<String, Object>> itCategory = rowsOfCategory.iterator();
			Map<String, Object> userMap3 = (Map<String, Object>) itCategory.next();
			//取得分類名稱
			String category = userMap3.get("CategoryName").toString();
			
			//取得訂單內容
			Goods good = new Goods(
					category, 
					userMap2.get("name").toString(), 
					Double.parseDouble(userMap2.get("price").toString()), 
					userMap2.get("photo").toString(), 
					userMap2.get("engname").toString()
					);
			//加入訂單資訊
			orderInfo.add(good);
		}	
		return orderInfo;
	}
}
