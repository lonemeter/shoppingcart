package shoppingcart;


public class Accountdate {
	
	private Account loginuser;
	private Account[] date = {
			new Account("meter", "123456", 0),
			new Account("geordie", "1234", 0),
			new Account("sosky", "1111", 0),
	};
	
	public Boolean check(String name, String password){
		for(int i=0; i<date.length; i++){
			if(name.equals(date[i].getName()) && password.equals(date[i].getPassword())){
				this.loginuser = date[i];
				return true;
			}
		}
		return false;
	}
	public Account getLoginuser(){
		return loginuser;
	}
}
