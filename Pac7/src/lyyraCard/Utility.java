package lyyraCard;

import java.util.Scanner;
import java.util.ArrayList;

public class Utility {

	// INICI
	static LyyraCardDB carddb = new LyyraCardDB("Cards");
	static PersonDB peopledb = new PersonDB("Users");
	static MenuDB lunchMenu = new MenuDB("Lunch Menu");

//	static ArrayList<LyyraCard> comodin = new ArrayList <LyyraCard>();

	// OPTIONS

	public static void returnAction(Scanner reader, String command) {
		if (command.equalsIgnoreCase("Menu")) {
			PrintSummary.printMenu(lunchMenu);
			
		} else if (command.equalsIgnoreCase("BuyMenu")) {
			System.out.println("\nFirst, choose your lunch:\n");
			double menuPrice = ChooseDishes.chooseDishes(reader, lunchMenu);
			System.out.println("\nYour meal will cost " + menuPrice + ".\n");
			Person user = chooseUser(reader);
			LyyraCard target = chooseCard(user, reader);
			while (true) {
//				 menuPrice = 2.5;
				if (target.enoughMoney(menuPrice)) {
					target.payMoney(menuPrice);
					System.out.println("Operation completed.\n");
					break;
				} else {
					System.out.println("There is not enough money in this card.");
					System.out.println("Please, insert a new amount.\n");
				}
			}
			PrintSummary.printCardSummary();

		} else if (command.equalsIgnoreCase("Load")) {
			Person user = chooseUser(reader);
			LyyraCard target = chooseCard(user, reader);
			double amount = askDouble("How much would you like to load? ", reader);
			target.loadMoney(amount);
			System.out.println("Operation completed.\n");
			PrintSummary.printCardSummary();

		} else if (command.equalsIgnoreCase("CardSummary")) {
			PrintSummary.printCardSummary();

		} else if (command.equalsIgnoreCase("CreateCard")) {
			Person user = chooseUser(reader);
			String cardName = askString("Insert card name: ", reader);
			LyyraCardDB.createCard(user, cardName);
			System.out.println("\nCard created!\n");
			PrintSummary.printCardSummary();

		} else if (command.equalsIgnoreCase("CreateUser")) {
			String userName = askString("Insert user name: ", reader);
			PersonDB.createPerson(userName);
			System.out.println("\nUser created!");
			PrintSummary.printUserList();

		} else {
			System.out.println("Unidentified command.");
		}
	}

	public static boolean finishProgram(String command) {
		if (command.equalsIgnoreCase("end")) {
			System.out.print("Closing the program.");
			return true;
		} else {
			return false;
		}
	}

	// ASKING METHODS

	public static Person chooseUser(Scanner reader) {
		int user = askUser("Select the user from the list: ", reader);
		return PersonDB.getPerson(user);
	}

	public static int askUser(String question, Scanner reader) {
		System.out.print(question);
		PrintSummary.printUserList();
		int user = Integer.parseInt(reader.nextLine());
		return user - 1;
	}

	public static LyyraCard chooseCard(Person user, Scanner reader) {
		LyyraCard card = LyyraCardDB.getCard(askCard("To operate, select the card from the list: \n", user, reader));
		System.out.println("You have chosen the account: \n" + card.toString() + "\n");
		return card;
	}

	public static int askCard(String question, Person user, Scanner reader) {
		System.out.print(question);
		PrintSummary.printUserCards(user);
		int card = Integer.parseInt(reader.nextLine());
		return card - 1;
	}

	public static String askString(String question, Scanner reader) {
		System.out.print(question);
		String answer = reader.nextLine();
		return answer;
	}

	public static double askDouble(String question, Scanner reader) {
		System.out.print(question);
		double answer = Double.parseDouble(reader.nextLine());
		return answer;
	}
}