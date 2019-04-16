package com.lonemeter.shoppingcart.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.good.*;

public class Items {
	public List<Goods> goods;
	public Items() {
	}
	
	public Items(String name){
		Connection cn;
		Statement st;
		ResultSet rs;
		List<Goods> goods = new ArrayList();
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM GOOD");
			while(rs.next()){
				if(name == null || "shoppingcart".equals(name)) {
					goods.add(new Goods(rs.getString("NAME"), 
							rs.getDouble("PRICE"), 
							rs.getString("PHOTO"), 
							rs.getString("ENGNAME")));
				}else if(rs.getString("CLASSIFICATION").equals(name)){
					goods.add(new Goods(rs.getString("NAME"), 
										rs.getDouble("PRICE"), 
										rs.getString("PHOTO"), 
										rs.getString("ENGNAME")));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.goods = goods;	
	}
}
