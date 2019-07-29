package lyyraCard;


public class CreateAtStart {
	
	public static void createFirstSteps() {
		Utility.peopledb.createPerson("Jane");
		Utility.peopledb.createPerson("Andrew");
		Utility.peopledb.createPerson("Valentine");
		Utility.carddb.createCard(PersonDB.getPerson(0), "Morning Card");
		Utility.carddb.createCard(PersonDB.getPerson(0), "Evening Card");
		Utility.carddb.createCard(PersonDB.getPerson(1), "Personal Card");
		Utility.carddb.createCard(PersonDB.getPerson(2), "Lunch Card");
		Utility.carddb.createCard(PersonDB.getPerson(2), "Breakfast Card");
		Utility.carddb.getCard(0).loadMoney(39);
		Utility.carddb.getCard(1).loadMoney(33);
		Utility.carddb.getCard(2).loadMoney(28);
		Utility.carddb.getCard(3).loadMoney(21);
		Utility.carddb.getCard(4).loadMoney(11);
		Utility.lunchMenu.createDish("Caesar Salad", 1, 2.20);
		Utility.lunchMenu.createDish("Tomato soup", 1, 2.10);
		Utility.lunchMenu.createDish("Ramen noodle soup", 1, 4.30);
		Utility.lunchMenu.createDish("Fried eggs with chips", 2, 3.80);
		Utility.lunchMenu.createDish("Veggie Burger with chips", 2, 4.50);
		Utility.lunchMenu.createDish("Grilled vegetables with allioli", 2, 3.20);
		Utility.lunchMenu.createDish("Tiramisu", 3, 2.80);
		Utility.lunchMenu.createDish("Lemon icecream", 3, 2.80);
		Utility.lunchMenu.createDish("Watermelon", 3, 1.20);
		Utility.lunchMenu.createDish("Tap water", 4, 0.00);
		Utility.lunchMenu.createDish("Orange juice", 4, 1.60);
		Utility.lunchMenu.createDish("Pineapple juice", 4, 1.60);
	}

}
