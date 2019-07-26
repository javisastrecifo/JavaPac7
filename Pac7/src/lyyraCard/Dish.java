package lyyraCard;

public class Dish {

	private String name;
	private int order; // first dish (1), main course (2), dessert (3) or drink (4).
	private double price;

	public Dish(String name, int order, double price) {
		this.name = name;
		this.order = order;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getOrder() {
		return order;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + ", " + price + " Euros.";
	}

	
	
}
