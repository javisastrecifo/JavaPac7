package lyyraCard;

import java.util.Scanner;

public class Utility {

	// INICI
	static LyyraCardDB carddb = new LyyraCardDB ("Cards");
	static PersonDB peopledb = new PersonDB ("Users");
	
	public static void createFirstSteps() {
		PersonDB.createPerson("Jane");
		PersonDB.createPerson("Andrew");
		LyyraCardDB.createCard(PersonDB.getPeopleList(0), "Morning");
		LyyraCardDB.createCard(PersonDB.getPeopleList(0), "Evening");
		LyyraCardDB.createCard(PersonDB.getPeopleList(1), "Personal Card");
		LyyraCardDB.getCardList(0).loadMoney(30);
		LyyraCardDB.getCardList(1).loadMoney(80);
		LyyraCardDB.getCardList(2).loadMoney(25);
	}

	// OPTIONS

	public static void returnAction(Scanner reader, String command) {
		if (command.equalsIgnoreCase("Pay")) {

		} else if (command.equalsIgnoreCase("Load")) {
			LyyraCard target = carddb.getCardList(askCard("Select the card from the list: " ,reader));
			double amount = askDouble("How much would you like to load? ", reader);
			target.loadMoney(amount);
			printCardSummary();
			
		} else if (command.equalsIgnoreCase("Summary")) {
			printCardSummary();
			
		} else if (command.equalsIgnoreCase("CreateCard")) {
			Person user = peopledb.getPeopleList(askUser("Select the user from the list: ", reader));
			String cardName = askString ("Insert card name: ", reader);
			carddb.createCard(user, cardName);
			System.out.println("\nCard created!");
			printCardSummary();
			
		} else if (command.equalsIgnoreCase("CreateUser")) {
			String userName = askString ("Insert user name: ", reader);
			peopledb.createPerson(userName);
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
	
	public static String askString (String question, Scanner reader) {
		System.out.print (question);
		String answer = reader.nextLine();
		return answer;
	}
	
	public static double askDouble (String question, Scanner reader) {
		System.out.print (question);
		double answer = Double.parseDouble(reader.nextLine());
		return answer;
	}
	
	public static int askUser (String question, Scanner reader) {
		System.out.print(question);
		printUserList();
		int user = Integer.parseInt(reader.nextLine());
		return user-1;
	}
	
	public static int askCard (String question, Scanner reader) {
		System.out.print(question);
		printCardList();
		int card = Integer.parseInt(reader.nextLine());
		return card-1;
	}

	
	// MENU & SUMMARY
	
	public static void printMenu() {
		System.out.println("LYYRACARD COMMANDS");
		System.out.println("Pay, Load, Summary, CreateCard, CreateUser, End");
		System.out.println("Command:");
	}

	public static void printCardList () {
		System.out.println(carddb.getDBname() + " List");
		for (int i = 0; i < carddb.cardList().size(); i++) {
			System.out.println((i+1) + "- " + carddb.getCardList(i));
		}
	}

	public static void printCardList () {
		System.out.println(carddb.getDBname() + " List");
		for (int i = 0; i < carddb.cardList().size(); i++) {
			System.out.println(carddb.getCardList(i));
		}
	}
	
	public static void printUserList () {
		System.out.println (peopledb.getDBname() + " List");
		for (int i = 0; i < peopledb.peopleList().size(); i++) {
			System.out.println((i+1) + "- " + peopledb.getPeopleList(i));
		}
	}
}
