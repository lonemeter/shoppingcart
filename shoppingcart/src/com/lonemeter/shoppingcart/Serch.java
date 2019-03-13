package com.lonemeter.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import com.lonemeter.shoppingcart.good.*;
public class Serch {
	
	
	public static List<Goods> GoodsSerch(List<Goods> goods, String serch){
		List<Goods> goods2 = new ArrayList();
		for(Goods good: goods){
			if(subString(good.getName(), serch)){
				goods2.add(good);
			}
		}
		return goods2;
	}
	
	public static boolean subString(String name, String serch){
		if(serch.length() > name.length()){
			return false;
		}else{
			for(int i=0; i<name.length()-serch.length()+1; i++){
				if(serch.equals(name.substring(i, i+serch.length()))){
					return true;
				}
			}
		}
		return false;
	}
	
}
