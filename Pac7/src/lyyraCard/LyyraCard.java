package lyyraCard;

public class LyyraCard {
	private Person owner;
	private double balance;

public LyyraCard (Person owner, double initialBalance) {
	this.owner = owner;
	this.balance = initialBalance;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public Person getOwner() {
	return owner;
}


	
	
}
