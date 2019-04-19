package com.lonemeter.shoppingcart.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.lonemeter.shoppingcart.good.*;

@Component
public class Items {
	@Bean
	public List<Goods> goods(){
		Connection cn;
		Statement st;
		Statement st2;
		ResultSet rs;
		ResultSet rs2;
		List<Goods> goods = new ArrayList<>();
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
		return goods;	
	}
}
