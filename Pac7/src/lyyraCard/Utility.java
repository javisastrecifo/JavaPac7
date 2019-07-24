package lyyraCard;

import java.util.Scanner;

public class Utility {

	public static void createFirstPerson () {
		Person jane = new Person ("Jane");
	}
	
	public static void returnAction (Scanner reader, String command, LyyraCardDB db) {
		if (command.equalsIgnoreCase("End")) {
			System.out.println("Closing the program.");
			System.exit(0);
			
		} else if (command.equalsIgnoreCase("CreateCard")) {
			
		} else if (command.equalsIgnoreCase("Pay")) {
			
		} else if (command.equalsIgnoreCase("Load")) {
			
		} else if (command.equalsIgnoreCase("Summary")) {
			
		} else {
			System.out.println("Unidentified command.");
		}
	}
	
	
	public static void printMenu () {
		System.out.println ("LYYRACARD COMMANDS");
		System.out.println ("CreateCard, Pay, Load, Summary, End");
		System.out.println ("Command:");
	}
}
