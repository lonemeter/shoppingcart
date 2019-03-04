package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Serch {
	
	
	public static List<Goods> GoodsSerch(Goods[] goods, String serch){
		List<Goods> goods2 = new ArrayList();
		for(Goods good: goods){
			if(SubString(good.name, serch)){
				goods2.add(good);
			}
		}
		return goods2;
	}
	
	public static boolean SubString(String name, String serch){
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
