package lyyraCard;

public class Person {

	private String name;
	
	
	public Person (String inputName) {
		this.name = inputName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Owner: " + name;
	}
	
	
	
}
