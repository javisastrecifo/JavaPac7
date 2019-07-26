package lyyraCard;

import java.util.ArrayList;

public class LyyraCardDB {
	private String dbname;

	static ArrayList<LyyraCard> cards;

	public LyyraCardDB(String name) {
		this.dbname = name;
		cards = new ArrayList<LyyraCard>();
	}

	public static void createCard(Person person, String cardName) {
		LyyraCard card = new LyyraCard(person, cardName, 0.0);
		cards.add(card);
	}
	
	public static LyyraCard getCardList (int input) {
		return cards.get(input);
	}
	
	public static void loadMoney (LyyraCard card ,double amount) {
		card.loadMoney(amount);
	}
	
	public static ArrayList<LyyraCard> cardList (){
		return cards;
	}

	public String getDBname() {
		return dbname;
	}

	
	
	
}
