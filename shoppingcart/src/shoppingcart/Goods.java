package shoppingcart;

public class Goods{
	protected String name;
	protected  double price;
	protected String photo;
	protected String engname;
	
	public String getEngname() {
		return engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	Goods(){
		
	}
	
	Goods(String name, double price, String photo, String engname){
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.engname = engname;
	}
	

	public void setName(String name){
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
}
