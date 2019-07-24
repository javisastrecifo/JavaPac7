package lyyraCard;

import java.util.Scanner;

public class UI {

	public static void start () {
		Scanner reader = new Scanner (System.in);
		LyyraCardDB db = new LyyraCardDB ();
		
		
		while (true) {
			Utility.printMenu();
			String command = reader.nextLine();
			Utility.returnAction(reader, command, db);
		}
		
	}
	
}
