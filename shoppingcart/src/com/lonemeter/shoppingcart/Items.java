package com.lonemeter.shoppingcart;

import com.lonemeter.shoppingcart.good.*;

public class Items {
	Goods[] goods;
	public Items(){
		int i = 0;
		Goods[] all = new Goods[armor.length + arms.length + food.length];
		System.arraycopy(armor, 0, all, i, armor.length);
		i += armor.length;
		System.arraycopy(arms, 0, all, i, arms.length);
		i += arms.length;
		System.arraycopy(food, 0, all, i, food.length);
		i += food.length;
		this.goods = all;
	}
	public Items(String name){
		if(name.equals("armor")){
			this.goods = armor;
		}
		if(name.equals("arms")){
			this.goods = arms;
		}
		if(name.equals("food")){
			this.goods = food;
		}
		
	}
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
	
}
