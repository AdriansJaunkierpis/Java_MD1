package model;

import java.time.LocalDate;

public class Employee extends Person {
	private LocalDate contractDate;
	private String contractNumber;
	
	public LocalDate getContractDate() {
		return contractDate;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractDate(LocalDate contractDate) {
		if (contractDate.isBefore(LocalDate.of(2023, 3, 24))) {
			this.contractDate = LocalDate.of(2023, 3, 24);
		} else {
			this.contractDate = contractDate;
		}
		
	}
	public void setContractNumber(String name, String surname) {
		contractNumber = LocalDate.now().getYear() + "_" + name.charAt(0) + " " + surname.charAt(0);
	}
	
	public Employee() {
		super();
		setContractDate(LocalDate.now());
		setContractNumber("Unknown", "Unknown");
	}
	public Employee(String name, String surname, String personCode, LocalDate contractDate) {
		super(name, surname, personCode);
		setContractDate(contractDate);
		setContractNumber(name, surname);
	}
	
	public String toString() {
		return getName() + " " + getSurname() + " " + getPersonCode() + ", Contract: " + getContractDate() + ", " + getContractNumber();
	}
}
