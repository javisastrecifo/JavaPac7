package lyyraCard;

import java.util.ArrayList;

public class PersonDB {

	private String dbname;
	static ArrayList<Person> people;

	public PersonDB(String name) {
		this.dbname = name;
		people = new ArrayList<Person>();
	}

	public static void createPerson(String name) {
		Person person = new Person(name);
		people.add(person);
	}

	public static Person getPerson(int input) {
		return people.get(input);
	}

	public static ArrayList<Person> peopleList() {
		return people;
	}

	public String getDBname() {
		return this.dbname;
	}

}
