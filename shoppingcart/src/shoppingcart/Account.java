package shoppingcart;

public class Account {
	private String name;
	private String password;
	private double money;
	Account(String name, String password, double money){
		this.name = name;
		this.password = password;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
