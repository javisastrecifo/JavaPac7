package lyyraCard;

public class LyyraCardDB {
	private LyyraCard card;
	// private ArrayList<LyyraCard> = new ArrayList <LyyraCard>();

	public LyyraCardDB() {

	}

	public static void createCard(Person person) {
		LyyraCard card = new LyyraCard (person, 0.0);
	}

}
