package shoppingcart;

import java.io.PrintWriter;

public class test {
	public static void main(String[] arg){
		for(Goods good : items.food)
		{
			System.out.printf("%s:%.2f,%s%n", good.name, good.price, good.photo);
		};

		System.out.printf("<img src='image/arms/%s.jpg'><br>%s　<button type='button' onclick='button(","milk", "milk");
		System.out.printf("\"%s\"","milk");
		System.out.printf(")'>加入購物車</button><br>");
	}
}
