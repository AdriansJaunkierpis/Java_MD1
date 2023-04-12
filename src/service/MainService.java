package service;

import java.time.LocalDate;
import java.util.ArrayList;

import model.BusCategory;
import model.BusDriver;
import model.BusTrip;
import model.Cashier;
import model.Employee;
import model.Station;

public class MainService {

	private static ArrayList<Employee> allEmployeesList = new ArrayList<>();
	private static ArrayList<BusTrip> allBusTripList = new ArrayList<>();
	private static ArrayList<Station> allStationList = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("---Cashier---");
		addNewCashier("Artis", "Arns", "123456-78910", LocalDate.of(2023, 3, 13));
		addNewCashier("Brigita", "Berza", "654321-01987", LocalDate.now());
		addNewCashier("Centis", "Ceplis", "456780-75634", LocalDate.now());
		
		System.out.println("Find by person code: \"123456-78910\": " + findCashierByPersonCode(allEmployeesList, "123456-78910"));
		
		System.out.print("Edit by person code: \"123456-78910\", ");
		updateCashierByPersonCode(allEmployeesList, "123456-78910", "123456-78910", "Arnis", "Barts", LocalDate.now());
		System.out.println("new data: " + findCashierByPersonCode(allEmployeesList, "123456-78910"));
		
		System.out.println("Delete by person code: \"123456-78910\", ");
		deleteCashierByPersonCode("123456-78910");
		System.out.println("Find all Cashiers: " + findAllCashiers(allEmployeesList));
		
		
		System.out.println("\n---BusDriver---");
		//ArrayList<BusCategory> categs = new ArrayList<>();
		//categs.add(BusCategory.minibus);
		addNewBusDriver("Raimons", "Rauls", "321654-56473", LocalDate.of(2023, 4, 6), new ArrayList<BusCategory>() {{add(BusCategory.minibus);add(BusCategory.schoolbus);}}, 3);
		addNewBusDriver("Zigmars", "Zalais", "307512-02032", LocalDate.of(2023, 8, 20), new ArrayList<BusCategory>() {{add(BusCategory.minibus);}}, 1);
		addNewBusDriver("Edvards", "Agnis", "060333-36378", LocalDate.of(2024, 2, 16), new ArrayList<BusCategory>() {{add(BusCategory.largebus);}}, 5);
		
		System.out.println("Find all bus drivers with largebus category: " + findBusDriverForCategory(BusCategory.largebus));
		System.out.println("Add new category to \"321654-56473\", ");
		addNewCategoryForBusDriver(BusCategory.largebus, "321654-56473");
		System.out.println("Find all bus drivers with largebus category: " + findBusDriverForCategory(BusCategory.largebus));
		System.out.println("Find all bus drivers: " + findAllBusDrivers());
		//System.out.println(allEmployeesList);
		
		
		System.out.println("\n---Station---");
		
		
		System.out.println("\n---BusTrip---");
		
		
		System.out.println("\n---Ticket---");
		
		
		System.out.println("\n---Extra---");
	}
	public static void addNewCashier(String name, String surname, String personCode, LocalDate dateTime) {
		allEmployeesList.add(new Cashier(name, surname, personCode, dateTime));
	}
	public static ArrayList<Employee> findCashierByPersonCode(ArrayList<Employee> empList, String personCode) {
		ArrayList<Employee> foundCashiers = new ArrayList<>();
		for (Employee temp: empList) {
			if (temp instanceof Cashier && temp.getPersonCode() == personCode) {
				foundCashiers.add(temp);
			}
		}
		return foundCashiers;
	}
	public static void updateCashierByPersonCode(ArrayList<Employee> empList, String oldPersonCode, String newPersonCode, String newName, String newSurname, LocalDate dateTime) {
		for (Employee temp: empList) {
			if (temp instanceof Cashier && temp.getPersonCode() == oldPersonCode) {
				temp.setPersonCode(newPersonCode);
				temp.setName(newName);
				temp.setSurname(newSurname);
				temp.setContractDate(dateTime);
			}
		}
	}
	public static void deleteCashierByPersonCode(String PersonCode) {
		for (Employee temp: allEmployeesList) {
			if (temp instanceof Cashier && temp.getPersonCode() == PersonCode) {
				allEmployeesList.remove(temp);
				temp = null;
				break;
			}
		}
	}
	public static ArrayList<Employee> findAllCashiers(ArrayList<Employee> empList) {
		ArrayList<Employee> foundCashiers = new ArrayList<>();
		for (Employee temp: empList) {
			if (temp instanceof Cashier) {
				foundCashiers.add(temp);
			}
		}
		return foundCashiers;
	}
	
	//BusDriver
	public static void addNewBusDriver(String name, String surname, String personCode, LocalDate dateTime, ArrayList<BusCategory> categories, int years) {
		allEmployeesList.add(new BusDriver(name, surname, personCode, dateTime, categories, years));
	}
	public static ArrayList<Employee> findBusDriverForCategory(BusCategory category) {
		ArrayList<Employee> foundDriver = new ArrayList<>();
		for (Employee temp: allEmployeesList) {
			if (temp instanceof BusDriver && ((BusDriver) temp).getCategories().contains(category)) {
				foundDriver.add(temp);
			}
		}
		return foundDriver;
	}
	public static void addNewCategoryForBusDriver(BusCategory category, String personCode) {

		for (Employee temp: allEmployeesList) {
			if (temp instanceof BusDriver && temp.getPersonCode() == personCode) {
				BusDriver busTemp = (BusDriver) temp;
				busTemp.addCategory(category);
			}
		}
	}
	public static ArrayList<Employee> findAllBusDrivers() {
		ArrayList<Employee> foundDrivers = new ArrayList<>();
		for (Employee temp: allEmployeesList) {
			if (temp instanceof BusDriver) {
				foundDrivers.add(temp);
			}
		}
		return foundDrivers;
	}
	
	//Station
}
