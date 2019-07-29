package lyyraCard;

import java.util.Scanner;

public class UI {

	public static void start () {
		Scanner reader = new Scanner (System.in);
		CreateAtStart.createFirstSteps();
		
		while (true) {
			PrintSummary.optionsSummary();
			String command = reader.nextLine();
			if (Utility.finishProgram(command)) {
				break;
			} else {
				Utility.returnAction(reader, command);
			}
			
		}
		
	}
	
}
