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
	
}
