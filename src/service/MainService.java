package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.BusCategory;
import model.BusDriver;
import model.BusTrip;
import model.Cashier;
import model.City;
import model.Employee;
import model.Station;
import model.Ticket;

public class MainService {

	private static ArrayList<Employee> allEmployeesList = new ArrayList<>();
	private static ArrayList<BusTrip> allBusTripList = new ArrayList<>();
	private static ArrayList<Station> allStationList = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("---Cashier---");
		addNewCashier("Artis", "Arns", "123456-78910", LocalDate.of(2023, 3, 13));
		addNewCashier("Brigita", "Berza", "654321-01987", LocalDate.of(2023, 4, 16));
		addNewCashier("Centis", "Ceplis", "456780-75634", LocalDate.of(2023, 3, 30));
		
		System.out.println("Find by person code: \"123456-78910\": " + findCashierByPersonCode("123456-78910"));
		
		System.out.print("Edit by person code: \"123456-78910\", ");
		updateCashierByPersonCode("123456-78910", "123456-78910", "Arnis", "Barts", LocalDate.now());
		System.out.println("new data: " + findCashierByPersonCode("123456-78910"));
		
		System.out.println("Delete by person code: \"654321-01987\", ");
		deleteCashierByPersonCode("654321-01987");
		System.out.println("Find all Cashiers: " + findAllCashiers());
		
		
		System.out.println("\n---BusDriver---");
		addNewBusDriver("Raimons", "Rauls", "321654-56473", LocalDate.of(2023, 4, 6), new ArrayList<BusCategory>() {{add(BusCategory.minibus);add(BusCategory.schoolbus);}}, 3);
		addNewBusDriver("Zigmars", "Zalais", "307512-02032", LocalDate.of(2023, 8, 20), new ArrayList<BusCategory>() {{add(BusCategory.minibus);}}, 1);
		addNewBusDriver("Edvards", "Agnis", "060333-36378", LocalDate.of(2024, 2, 16), new ArrayList<BusCategory>() {{add(BusCategory.largebus);}}, 5);
		
		System.out.println("Find all bus drivers with largebus category: " + findBusDriverForCategory(BusCategory.largebus));
		System.out.println("Add new category to \"321654-56473\", ");
		addNewCategoryForBusDriver(BusCategory.largebus, "321654-56473");
		System.out.println("Find all bus drivers with largebus category: " + findBusDriverForCategory(BusCategory.largebus));
		System.out.println("Find all bus drivers: " + findAllBusDrivers());
		
		
		System.out.println("\n---Station---");
		addNewStation(City.Ventspils, "VentspilsAO", "8-17");
		addNewStation(City.Daugavpils, "DaugavpilsAO", "8-17");
		addNewStation(City.Jelgava, "JelgavaAO", "8-17");
		addNewStation(City.Liepaja, "LiepajaAO", "8-17");
		addNewStation(City.Riga, "RigaAO", "8-17");
		
		System.out.println("\n---BusTrip---");
		LocalDateTime nowTime = LocalDateTime.now(); 
		addNewBusTrip(findStationByName("VentspilsAO"), findStationByName("RigaAO"), nowTime.plusHours(1), nowTime.plusHours(3), 35, findBusDriverForCategory(BusCategory.largebus).get(0));
		addNewBusTrip(findStationByName("VentspilsAO"), findStationByName("LiepajaAO"), nowTime, nowTime.plusHours(2), 2, findBusDriverForCategory(BusCategory.minibus).get(1));
		addNewBusTrip(findStationByName("VentspilsAO"), findStationByName("LiepajaAO"), nowTime.plusHours(4), nowTime.plusHours(6), 15, findBusDriverForCategory(BusCategory.minibus).get(0));
		addNewBusTrip(findStationByName("RigaAO"), findStationByName("LiepajaAO"), nowTime.plusHours(3), nowTime.plusHours(6), 25, findBusDriverForCategory(BusCategory.schoolbus).get(0));
		System.out.println("Find all bus trips from station VentspilsAO today: " + findAllBusTripsFromStationToday(findStationByName("VentspilsAO")));
		System.out.println("Find free spots Ventspils-Riga: " + freeSeatCountOnBusTrip(nowTime, findStationByName("VentspilsAO"), findStationByName("RigaAO")));
		System.out.println("Find all tickets for Ventspils-Riga: " + findAllTicketsForBusTrip(nowTime, findStationByName("VentspilsAO"), findStationByName("RigaAO")));
		
		System.out.println("\n---Ticket---");
		System.out.println("Add more tickets than seats: ");
		addTicketToBusTrip(1, (float)11.2, findCashierByPersonCode("123456-78910"), false, nowTime, findStationByName("VentspilsAO"), findStationByName("LiepajaAO"));
		addTicketToBusTrip(1, (float)11.2, findCashierByPersonCode("123456-78910"), true, nowTime, findStationByName("VentspilsAO"), findStationByName("LiepajaAO"));
		addTicketToBusTrip(1, (float)11.2, findCashierByPersonCode("123456-78910"), false, nowTime, findStationByName("VentspilsAO"), findStationByName("LiepajaAO"));
		System.out.println("Find all tickets for Ventspils-Liepaja: " + findAllTicketsForBusTrip(nowTime, findStationByName("VentspilsAO"), findStationByName("LiepajaAO")));
		
		addTicketToBusTrip(1, (float)11.2, findCashierByPersonCode("123456-78910"), false, nowTime, findStationByName("VentspilsAO"), findStationByName("RigaAO"));
		addTicketToBusTrip(0, (float)16.2, findCashierByPersonCode("123456-78910"), true, nowTime, findStationByName("VentspilsAO"), findStationByName("RigaAO"));
		addTicketToBusTrip(1, (float)11.2, findCashierByPersonCode("123456-78910"), false, nowTime, findStationByName("VentspilsAO"), findStationByName("RigaAO"));
		System.out.println("Find all VIP tickets for today: " + findAllVipTicketsForToday());
		System.out.println("Income by cashier \"123456-78910\": " + incomeByCashierToday("123456-78910")); //(11.2-1)+(11.2-1)+(11.2-1)+(16.2-0)+(11.2) = 57
		
		System.out.println("\n---Extra---");
		System.out.println("Sort bus trips in station Ventspils" + sortBusTripByTimeToday(findStationByName("VentspilsAO")));
		System.out.println("Generating Bus Trips for the week: \n");
		generateBusTrips();
	}
	public static void addNewCashier(String name, String surname, String personCode, LocalDate dateTime) {
		allEmployeesList.add(new Cashier(name, surname, personCode, dateTime));
	}
	public static Cashier findCashierByPersonCode(String personCode) {
		for (Employee temp: allEmployeesList) {
			if (temp instanceof Cashier && temp.getPersonCode() == personCode) {
				return ((Cashier) temp);
			}
		}
		return null;
	}
	public static void updateCashierByPersonCode(String oldPersonCode, String newPersonCode, String newName, String newSurname, LocalDate dateTime) {
		for (Employee temp: allEmployeesList) {
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
	public static ArrayList<Employee> findAllCashiers() {
		ArrayList<Employee> foundCashiers = new ArrayList<>();
		for (Employee temp: allEmployeesList) {
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
	public static ArrayList<BusDriver> findBusDriverForCategory(BusCategory category) {
		ArrayList<BusDriver> foundDriver = new ArrayList<>();
		for (Employee temp: allEmployeesList) {
			if (temp instanceof BusDriver && ((BusDriver) temp).getCategories().contains(category)) {
				foundDriver.add((BusDriver) temp);
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
	public static void addNewStation(City city, String stationName, String workingHours) {
		allStationList.add(new Station(city, stationName, workingHours));
	}
	public static Station findStationByName(String name) {
		for (Station temp: allStationList) {
			if (temp.getStationName() == name) {
				return temp;
			}
		}
		return null;
	}
	
	//BusTrip
	public static void addNewBusTrip(Station startStation, Station destinationStation, LocalDateTime fromDateTime, LocalDateTime toDateTime, int seatCount, BusDriver driver) {
		allBusTripList.add(new BusTrip(startStation, destinationStation, fromDateTime, toDateTime, seatCount, driver));
	}
	public static int freeSeatCountOnBusTrip(LocalDateTime dateTime, Station startStation, Station destinationStation) {
		int freeSpots = 0;
		for (BusTrip temp: allBusTripList) {
			if (temp.getFromDateTime() == dateTime && temp.getStartStation() == startStation && temp.getDestinationStation() == destinationStation) {
				freeSpots = temp.getSeatCount() - temp.getTickets().size();
			}
		}
		return freeSpots;
	}
	public static ArrayList<Ticket> findAllTicketsForBusTrip(LocalDateTime dateTime, Station startStation, Station destinationStation) {
		ArrayList<Ticket> foundTickets = new ArrayList<>();
		for (BusTrip temp: allBusTripList) {
			if (temp.getFromDateTime() == dateTime && temp.getStartStation() == startStation && temp.getDestinationStation() == destinationStation) {
				foundTickets = temp.getTickets();
			}
		}
		return foundTickets;
	}
	public static ArrayList<BusTrip> findAllBusTripsFromStationToday(Station station) {
		ArrayList<BusTrip> foundBusTrips = new ArrayList<>();
		for (BusTrip temp: allBusTripList) {
			if (temp.getStartStation() == station) {
				if (temp.getFromDateTime().getDayOfYear() == LocalDate.now().getDayOfYear() && temp.getFromDateTime().getYear() == LocalDate.now().getYear()) {
					foundBusTrips.add(temp);
				}
			}
		}
		return foundBusTrips;
	}
	
	//Ticket
	public static void addTicketToBusTrip(int discount, float price, Cashier cashier, boolean vipTicket, LocalDateTime dateTime, Station startStation, Station destinationStation) {
		for (BusTrip temp: allBusTripList) {
			if (temp.getFromDateTime() == dateTime && temp.getStartStation() == startStation && temp.getDestinationStation() == destinationStation) {
				try {
					temp.addTicket(new Ticket(discount, price, cashier, vipTicket));
					break;
				} catch (Exception e) {System.out.println(e);}
			}
		}
	}
	
	//General
	public static float incomeByCashierToday(String personCode) {
		float income = 0;
		Cashier cashier = new Cashier();
		for (Employee temp: allEmployeesList) {
			if (temp instanceof Cashier && temp.getPersonCode() == personCode) {
				cashier = (Cashier) temp;
			}
		}
		for (BusTrip temp: allBusTripList) {
			for (Ticket tempTicket: temp.getTickets()) {
				if (cashier == tempTicket.getCashier()) {
					income += tempTicket.getPrice() - tempTicket.getDiscount();
				}
			}
		}
		return income;
	}
	public static ArrayList<Ticket> findAllVipTicketsForToday() {
		ArrayList<Ticket> allVipTickets = new ArrayList<>();
		for (BusTrip temp: allBusTripList) {
			for (Ticket tempTicket: temp.getTickets()) {
				if (tempTicket.isVipTicket() && tempTicket.getDateTime().getDayOfYear() == LocalDate.now().getDayOfYear() && tempTicket.getDateTime().getYear() == LocalDate.now().getYear()) {
					allVipTickets.add(tempTicket);
				}
			}
		}
		return allVipTickets;
	}
	public static ArrayList<BusTrip> sortBusTripByTimeToday(Station station) {
		ArrayList<BusTrip> allBusTrips = new ArrayList<>();
		for (BusTrip temp: allBusTripList) {
			if (temp.getStartStation() == station) {
				allBusTrips.add(temp);	
			}
		}
		for (BusTrip tempTrip1: allBusTrips) {
			for (BusTrip tempTrip2: allBusTrips) {
				if (tempTrip1.getFromDateTime().isAfter(tempTrip2.getFromDateTime())) {
					
					BusTrip temp = tempTrip1;
					tempTrip1 = tempTrip2;
					tempTrip2 = temp;
				}
			}
		}
		return allBusTrips;
	}
	public static void generateBusTrips() {
		LocalDateTime startDate = LocalDateTime.now();
		while (startDate.isBefore(LocalDateTime.now().plusDays(7))) {
			int startStation = getRandNum(0, 4);
			int leaveStation = getRandNum(0, 4);
			int seatCount = getRandNum(10, 50);
			ArrayList<BusDriver> largeBusDrivers = new ArrayList<>();
			BusDriver driver = new BusDriver();
			if (seatCount >= 30) {
				for (Employee temp: findAllBusDrivers()) {
					if (temp instanceof BusDriver) {
						BusDriver temp2 = (BusDriver) temp;
						if (temp2.getCategories().contains(BusCategory.largebus)) {
							largeBusDrivers.add(temp2);
						}
					}
				}
				driver = largeBusDrivers.get(getRandNum(0, largeBusDrivers.size()));
			} else {
				driver = (BusDriver) findAllBusDrivers().get(getRandNum(0, findAllBusDrivers().size()));
			}
			LocalDateTime arriveDate = startDate.plusMinutes(getRandNum(30, 250));
			while (startStation == leaveStation) {
				leaveStation = getRandNum(0, 4);
			}
			
			addNewBusTrip(allStationList.get(startStation), allStationList.get(leaveStation), startDate, arriveDate, seatCount, driver);
			System.out.println(allBusTripList.get(allBusTripList.size() - 1));
			startDate = startDate.plusMinutes(getRandNum(60, 480));
		}
	}
	public static int getRandNum(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
}
