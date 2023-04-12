package model;

import java.time.LocalDate;

public class Cashier extends Employee {
	private long id;
	private static long idCounter = 1000;
	
	public long getId() {
		return id;
	}
	public void setId() {
		id = idCounter++;
	}
	
	public Cashier() {
		super();
		setId();
	}
	public Cashier(String name, String surname, String personCode, LocalDate contractDate) {
		super(name, surname, personCode, contractDate);
		setId();
	}
	
	public String toString() {
		return "Cashier, ID: " + getId() + ", " + getPersonCode() +", Name: " + getName() + " " + getSurname() + ", Contract: " + getContractDate() + ", " + getContractNumber();
	}
}
