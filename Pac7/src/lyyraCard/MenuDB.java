package lyyraCard;

import java.util.ArrayList;

public class MenuDB {

	private String name;
	static ArrayList<Dish> menuList;

	public MenuDB(String name) {
		this.name = name;
		menuList = new ArrayList<Dish>();
	}

	public static void createDish (String name, int order, double price) {
			Dish dish = new Dish (name, order, price);
			menuList.add(dish);
	}
	
	public static Dish getDish (int input) {
		return menuList.get(input);
	}
	
	public static ArrayList<Dish> getDishList (){
		return menuList;
	}
	
	
	
	
}
