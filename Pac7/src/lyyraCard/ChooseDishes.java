package lyyraCard;

import java.util.Scanner;

public class ChooseDishes {
	
	public static double chooseDishes (Scanner reader, MenuDB menu) {
		double menuPrice = 0;
		System.out.println("Total Price = " + menuPrice + "\nChoose a starter:\n");
		Dish dish = PrintSummary.printMenuDish(menu, 1).get(Integer.parseInt(reader.nextLine())-1);
		System.out.println("You have chosen the dish " + dish.toString());
		menuPrice += dish.getPrice();
		
		System.out.println("\nTotal Price = " + menuPrice + "\nChoose a main course:\n");
		dish = PrintSummary.printMenuDish(menu, 2).get(Integer.parseInt(reader.nextLine())-1);
		System.out.println("You have chosen the dish " + dish.toString());
		menuPrice += dish.getPrice();
		
		System.out.println("\nTotal Price = " + menuPrice + "\nChoose a dessert:\n");
		dish = PrintSummary.printMenuDish(menu, 3).get(Integer.parseInt(reader.nextLine())-1);
		System.out.println("You have chosen the dish " + dish.toString());
		menuPrice += dish.getPrice();
		
		System.out.println("\nTotal Price = " + menuPrice + "\nChoose something to drink:\n");
		dish = PrintSummary.printMenuDish(menu, 4).get(Integer.parseInt(reader.nextLine())-1);
		System.out.println("You have chosen the dish " + dish.toString());
		menuPrice += dish.getPrice();
		
		return menuPrice;
	}
	
}
