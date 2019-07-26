package lyyraCard;

import java.util.Scanner;

public class DisplaySummary {

	public static void printUserList() {
		System.out.println("\n" + Utility.peopledb.getDBname() + " List");
		for (int i = 0; i < Utility.peopledb.peopleList().size(); i++) {
			System.out.println((i + 1) + "- " + Utility.peopledb.getPerson(i));
		}
		System.out.println();
	}
	
	public static void printCardSummary() {
		System.out.println(Utility.carddb.getDBname() + " List");
		for (LyyraCard card : Utility.carddb.cardList()) {
			System.out.println(card);
		}
		System.out.println();
	}
}
