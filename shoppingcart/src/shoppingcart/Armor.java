package shoppingcart;

public class Armor extends Goods{
	double discount;
	
	Armor(String name, double price, String photo, String engname){
		super(name, price, photo, engname);
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}

