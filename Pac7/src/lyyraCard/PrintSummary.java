package lyyraCard;

import java.util.Scanner;
import java.util.ArrayList;

public class PrintSummary {

	public static void optionsSummary() {
		System.out.println("LYYRACARD COMMANDS");
		System.out.println("Menu, BuyMenu, Load, CardSummary, CreateCard, CreateUser, End");
		System.out.println("Command:");
	}

	public static void printCardList() {
		System.out.println(Utility.carddb.getDBname() + " List");
		for (int i = 0; i < Utility.carddb.cardList().size(); i++) {
			System.out.println((i + 1) + "- " + Utility.carddb.getCard(i));
		}
	}

	public static void printUserCards(Person user) {
		System.out.println("\n" + user.getName() + "'s Card List");
		for (int i = 0; i < user.getUserCard().size(); i++) {
			System.out.println((i + 1) + "- " + user.getLyyra(i));
		}
	}

	public static void printCardSummary() {
		System.out.println(Utility.carddb.getDBname() + " List");
		for (LyyraCard card : Utility.carddb.cardList()) {
			System.out.println(card);
		}
		System.out.println();
	}

	public static void printUserList() {
		System.out.println("\n" + Utility.peopledb.getDBname() + " List");
		for (int i = 0; i < Utility.peopledb.peopleList().size(); i++) {
			System.out.println((i + 1) + "- " + Utility.peopledb.getPerson(i));
		}
		System.out.println();
	}

	public static void printMenu(MenuDB menu) {
		System.out.println("\n" + menu.getName());
		System.out.println("\n -- Starters --");
		printMenuDish(menu, 1);
		System.out.println("\n -- Main Courses --");
		printMenuDish (menu, 2);
		System.out.println("\n -- Desserts --");
		printMenuDish (menu, 3);
		System.out.println("\n -- Drinks --");
		printMenuDish (menu, 4);
		System.out.println();
	}

	public static ArrayList<Dish> printMenuDish(MenuDB menu, int orderDish) {
		ArrayList<Dish> helper = new ArrayList<Dish>();
		int j = 0;
		for (int i = 0; i < menu.getDishList().size(); i++) {
			if (menu.getDish(i).getOrder() == orderDish) {
				j++;
				helper.add(menu.getDish(i));
				System.out.println((j) + "- " + menu.getDish(i).toString());
			}
		}
		return helper;
	}
}
