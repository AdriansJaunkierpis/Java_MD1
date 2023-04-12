package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusDriver extends Employee {
	private ArrayList<BusCategory> categories = new ArrayList<>();
	private int experienceYears;
	
	public ArrayList<BusCategory> getCategories() {
		return categories;
	}
	public void addCategory(BusCategory category) {
		categories.add(category);
	}
	public void removeCategory(BusCategory category) {
		categories.remove(category);
	}
	
	public int getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears) {
		if (experienceYears > 0) {
			this.experienceYears = experienceYears;
		} else {
			this.experienceYears = 0;
		}
	}
	
	public BusDriver() {
		super();
		setExperienceYears(0); //maybe vajag declarot categories
	}
	public BusDriver(String name, String surname, String personCode, LocalDate contractDate, ArrayList<BusCategory> categories, int experience) {
		super(name, surname, personCode, contractDate);
		for (BusCategory temp : categories) {
			addCategory(temp);
		}
		setExperienceYears(experience);
	}
	
	public String toString() {
		return "BusDriver: " + getName() + " " + getSurname() + " " + getPersonCode() + ", Contract: " + getContractDate() + ", " + getContractNumber() + ", Experience: " + experienceYears + ", Categories: " + categories;
	}
}
