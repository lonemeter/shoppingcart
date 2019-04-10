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
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","METER","123456");
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
		/*
		if(name.equals("armor")){
			this.goods = armor;
		}
		if(name.equals("arms")){
			this.goods = arms;
		}
		if(name.equals("food")){
			this.goods = food;
		}
		*/
		
	}
	/*
	private Armor[] armor = {
			new Armor("¬ÞµP", 1000, "image/armor/¬ÞµP.jpg", "shied"),
			new Armor("¿Ç¤l", 2000, "image/armor/¿Ç¤l.jpg", "trousers"),
			new Armor("ñZ¥Ò", 3000, "image/armor/ñZ¥Ò.jpg", "clothes")
	};
	
	private Arms[] arms = {
			new Arms("¤½¨Æ¥]", 100, "image/arms/¤½¨Æ¥].jpg", "suitcase"),
			new Arms("¼C", 200, "image/arms/¼C.jpg", "sword"),
			new Arms("´Î²y´Ò", 300, "image/arms/´Î²y´Ò.jpg", "baseballbat")
	};
	
	private Food[] food = {
			new Food("¤û¥¤", 1, "image/food/¤û¥¤.jpg", "milk"),
			new Food("³J¿|", 2, "image/food/³J¿|.jpg", "cake")
	};
	*/
}
