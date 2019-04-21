package com.lonemeter.shoppingcart.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonemeter.shoppingcart.good.*;

@Component
public class Items {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Bean
	public List<Goods> goods(){
		List<Goods> goods = new ArrayList<>();
		List<Map<String, Object>>  rows = jdbcTemplate.queryForList("SELECT * FROM GOOD");
		Iterator<Map<String, Object>>  it = rows.iterator(); 
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>) it.next();
			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList("SELECT * FROM CATEGORY WHERE CATEGORYID="+userMap.get("CATEGORYID").toString());
			Iterator<Map<String, Object>> it2 = rows2.iterator(); 
			if(it2.hasNext()) {
				Map<String, Object> userMap2 = (Map<String, Object>) it2.next();
				goods.add(new Goods(userMap2.get("CATEGORYNAME").toString(),
						userMap.get("NAME").toString(), 
						Double.parseDouble(userMap.get("PRICE").toString()),
						userMap.get("PHOTO").toString(), 
						userMap.get("ENGNAME").toString())
						);
			}
		}
		/*
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
			st = cn.createStatement();
			st2 = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM GOOD");
			
			while(rs.next()){
				rs2 = st2.executeQuery("SELECT * FROM CATEGORY WHERE CATEGORYID="+rs.getInt("CATEGORYID"));
				if(rs2.next()) {
					goods.add(new Goods(rs2.getString("CATEGORYNAME"),
							rs.getString("NAME"), 
							rs.getDouble("PRICE"), 
							rs.getString("PHOTO"), 
							rs.getString("ENGNAME")));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return goods;	
	}
}
