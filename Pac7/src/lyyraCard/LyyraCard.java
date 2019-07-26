package lyyraCard;

public class LyyraCard {
	private Person owner;
	private String cardName;
	private double balance;

	public LyyraCard(Person owner, String cardName, double initialBalance) {
		this.owner = owner;
		this.cardName = cardName;
		this.balance = initialBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void loadMoney(double amount) {
		this.balance += amount;
	}

	public boolean enoughMoney(double amount) {
		if (this.balance > amount) {
			return true;
		} else {
			return false;
		}
	}
	
	public void payMoney (double amount) {
		this.balance -= amount;
	}

	public Person getOwner() {
		return owner;
	}

	public String getCardName() {
		return this.cardName;
	}

	public String toStringSmall () {
		return "Card Name: '" + this.cardName + "'. Balance: " + this.balance;
	}
	
	@Override
	public String toString() {
		return this.owner + ". Card Name: '" + this.cardName + "'. Balance: " + this.balance;
	}

}
