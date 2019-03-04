package shoppingcart;

public class Account implements Store, Consume{
	private String name;
	private String password;
	private double money;
	Account(String name, String password, double money){
		this.name = name;
		this.password = password;
		this.money = money;
	}
	@Override
	public void Store(double num){
		this.money += num;
	}
	@Override
	public void Consume(double num){
		this.money -= num;
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
}
