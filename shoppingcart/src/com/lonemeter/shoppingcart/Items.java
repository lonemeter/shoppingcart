package com.lonemeter.shoppingcart;

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
	List<Goods> goods;
	public Items(){
		
		Connection cn;
		Statement st;
		ResultSet rs;
		List<Goods> goods = new ArrayList();
		try {
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb","METER","123456");
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM GOOD");
			while(rs.next()){
				goods.add(new Goods(rs.getString("NAME"), 
									rs.getDouble("PRICE"), 
									rs.getString("PHOTO"), 
									rs.getString("ENGNAME")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.goods = goods;
		
		/*
		int i = 0;
		Goods[] all = new Goods[armor.length + arms.length + food.length];
		System.arraycopy(armor, 0, all, i, armor.length);
		i += armor.length;
		System.arraycopy(arms, 0, all, i, arms.length);
		i += arms.length;
		System.arraycopy(food, 0, all, i, food.length);
		i += food.length;
		this.goods = all;
		*/
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
				if(rs.getString("CLASSIFICATION").equals(name)){
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
			new Armor("�޵P", 1000, "image/armor/�޵P.jpg", "shied"),
			new Armor("�Ǥl", 2000, "image/armor/�Ǥl.jpg", "trousers"),
			new Armor("�Z��", 3000, "image/armor/�Z��.jpg", "clothes")
	};
	
	private Arms[] arms = {
			new Arms("���ƥ]", 100, "image/arms/���ƥ].jpg", "suitcase"),
			new Arms("�C", 200, "image/arms/�C.jpg", "sword"),
			new Arms("�βy��", 300, "image/arms/�βy��.jpg", "baseballbat")
	};
	
	private Food[] food = {
			new Food("����", 1, "image/food/����.jpg", "milk"),
			new Food("�J�|", 2, "image/food/�J�|.jpg", "cake")
	};
	*/
}
