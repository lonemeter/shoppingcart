package shoppingcart;

public class Items {
	public static Goods[] all = {
			new Armor("�޵P", 1000, "image/armor/�޵P.jpg", "shied"),
			new Armor("�Ǥl", 2000, "image/armor/�Ǥl.jpg", "trousers"),
			new Armor("�Z��", 2000, "image/armor/�Z��.jpg", "clothes"),
			
			new Armor("�޵P", 1000, "image/armor/�޵P.jpg", "shied"),
			new Armor("�Ǥl", 2000, "image/armor/�Ǥl.jpg", "trousers"),
			new Armor("�Z��", 3000, "image/armor/�Z��.jpg", "clothes"),
			
			new Food("����", 1, "image/food/����.jpg", "milk"),
			new Food("�J�|", 2, "image/food/�J�|.jpg", "cake")
	};
		
	public static Armor[] armor = {
			new Armor("�޵P", 1000, "image/armor/�޵P.jpg", "shied"),
			new Armor("�Ǥl", 2000, "image/armor/�Ǥl.jpg", "trousers"),
			new Armor("�Z��", 3000, "image/armor/�Z��.jpg", "clothes")
	};
	
	public static Arms[] arms = {
			new Arms("���ƥ]", 100, "image/arms/���ƥ].jpg", "suitcase"),
			new Arms("�C", 200, "image/arms/�C.jpg", "sword"),
			new Arms("�βy��", 300, "image/arms/�βy��.jpg", "baseballbat")
	};
	
	public static Food[] food = {
			new Food("����", 1, "image/food/����.jpg", "milk"),
			new Food("�J�|", 2, "image/food/�J�|.jpg", "cake")
	};
	
}
