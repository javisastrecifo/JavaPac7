package lyyraCard;

import java.util.ArrayList;

public class Person {

	private String name;
	private ArrayList<LyyraCard> userCard;
	
	public Person (String inputName) {
		this.name = inputName;
		this.userCard = new ArrayList<LyyraCard>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<LyyraCard> getUserCard() {
		return userCard;
	}
	
	public LyyraCard getLyyra (int input) {
		return this.getUserCard().get(input);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addToArray (LyyraCard card) {
		this.userCard.add(card);
	}

	@Override
	public String toString() {
		return "Owner: " + name;
	}	
	
}
