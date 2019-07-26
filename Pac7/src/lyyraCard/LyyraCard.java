package lyyraCard;

public class LyyraCard {
	private Person owner;
	private String cardName;
	private double balance;

public LyyraCard (Person owner, String cardName, double initialBalance) {
	this.owner = owner;
	this.cardName = cardName;
	this.balance = initialBalance;
}

public double getBalance() {
	return balance;
}

public void loadMoney(double balance) {
	this.balance = balance;
}

public Person getOwner() {
	return owner;
}

public String getCardName () {
	return this.cardName;
}

@Override
public String toString() {
	return this.owner + ". Card Name: '" + this.cardName + "'. Balance: " + this.balance;
	
}


	
	
}
