package lyyraCard;

import java.util.Scanner;
import java.util.ArrayList;

public class Utility {

	// INICI
	static LyyraCardDB carddb = new LyyraCardDB("Cards");
	static PersonDB peopledb = new PersonDB("Users");
//	static ArrayList<LyyraCard> comodin = new ArrayList <LyyraCard>();

	public static void createFirstSteps() {
		PersonDB.createPerson("Jane");
		PersonDB.createPerson("Andrew");
		LyyraCardDB.createCard(PersonDB.getPerson(0), "Morning");
		LyyraCardDB.createCard(PersonDB.getPerson(0), "Evening");
		LyyraCardDB.createCard(PersonDB.getPerson(1), "Personal Card");
		LyyraCardDB.getCard(0).loadMoney(30);
		LyyraCardDB.getCard(1).loadMoney(80);
		LyyraCardDB.getCard(2).loadMoney(25);
	}

	// OPTIONS

	public static void returnAction(Scanner reader, String command) {
		if (command.equalsIgnoreCase("Pay")) {
			Person user = chooseUser(reader);
			LyyraCard target = chooseCard(user, reader);
			while (true) {
				double amount = 2.5;
				if (target.enoughMoney(amount)) {
					target.payMoney(amount);
					System.out.println("Operation completed.");
					break;
				} else {
					System.out.println("There is not enough money in this card.");
					System.out.println("Please, insert a new amount.\n");
				}
			}
			printCardSummary();

		} else if (command.equalsIgnoreCase("Load")) {
			Person user = chooseUser(reader);
			LyyraCard target = chooseCard(user, reader);
			double amount = askDouble("How much would you like to load? ", reader);
			target.loadMoney(amount);
			System.out.println("Operation completed.");
			printCardSummary();

		} else if (command.equalsIgnoreCase("Summary")) {
			printCardSummary();

		} else if (command.equalsIgnoreCase("CreateCard")) {
			Person user = chooseUser(reader);
			String cardName = askString("Insert card name: ", reader);
			LyyraCardDB.createCard(user, cardName);
			System.out.println("\nCard created!\n");
			printCardSummary();

		} else if (command.equalsIgnoreCase("CreateUser")) {
			String userName = askString("Insert user name: ", reader);
			PersonDB.createPerson(userName);
			System.out.println("\nUser created!");
			printUserList();

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
		printUserList();
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
		printUserCards (user);
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

	// MENU & SUMMARY

	public static void printMenu() {
		System.out.println("LYYRACARD COMMANDS");
		System.out.println("Pay, Load, Summary, CreateCard, CreateUser, End");
		System.out.println("Command:");
	}

	public static void printCardList() {
		System.out.println(carddb.getDBname() + " List");
		for (int i = 0; i < carddb.cardList().size(); i++) {
			System.out.println((i + 1) + "- " + carddb.getCard(i));
		}
	}

	public static void printUserCards(Person user) {
		System.out.println("\n" + user.getName() + "'s Card List");
		for (int i = 0; i < user.getUserCard().size(); i++) {
			System.out.println((i + 1) + "- " + user.getLyyra(i));
		}
	}

	public static void printCardSummary() {
		System.out.println(carddb.getDBname() + " List");
		for (LyyraCard card : carddb.cardList()) {
			System.out.println(card);
		}
		System.out.println();
	}

	public static void printUserList() {
		System.out.println("\n" + peopledb.getDBname() + " List");
		for (int i = 0; i < peopledb.peopleList().size(); i++) {
			System.out.println((i + 1) + "- " + peopledb.getPerson(i));
		}
		System.out.println();
	}
}
