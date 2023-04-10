package model;

public class Person {
	private String name;
	private String surname;
	private String personCode;
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonCode() {
		return personCode;
	}
	
	public void setName(String name) {
		if(name!=null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+([ ][A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+)?")) {
			this.name = name;
		} else {
			this.name = "Unknown";
		}
	}
	public void setSurname(String surname) {
		if(surname!=null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+([ ][A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+)?")) {
			this.surname = surname;
		} else {
			this.surname = "Unknown";
		}
	}
	public void setPersonCode(String personCode) {
		if(personCode!=null && personCode.matches("[0-9]{6}[-][0-9]{5}"))
		{
			this.personCode = personCode;
		}
		else
		{
			this.personCode = "000000-00000";
		}
	}
	
	public Person() {
		setName("Unknown");
		setSurname("Unknown");
		setPersonCode("000000-00000");
	}
	public Person(String name, String surname, String personCode) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
	}
	
	public String toString() {
		return name + " " + surname + " " + personCode;
	}
}
