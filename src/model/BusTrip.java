package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BusTrip {
	private long id;
	private Station startStation;
	private Station destinationStation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private int seatCount;
	private BusDriver driver;
	private ArrayList<Ticket> tickets = new ArrayList<>();
	private static long idCounter = 20000;
	
	public long getId() {
		return id;
	}
	public Station getStartStation() {
		return startStation;
	}
	public Station getDestinationStation() {
		return destinationStation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public BusDriver getDriver() {
		return driver;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public void setId(long id) {
		id = idCounter++;
	}
	public void setStartStation(Station startStation) throws Exception {
		if (startStation == destinationStation) {
			throw new Exception("Matching start and destination stations");
		} else {
			this.startStation = startStation;
		}
		
	}
	public void setDestinationStation(Station destinationStation) throws Exception {
		if (startStation == destinationStation) {
			throw new Exception("Matching start and destination stations");
		} else {
			this.destinationStation = startStation;
		}
	}
	public void setFromDateTime(LocalDateTime fromDateTime) throws Exception {
		if (fromDateTime.isBefore(LocalDateTime.now())) {
			throw new Exception("The departing time is in the past");
		} else {
			this.fromDateTime = fromDateTime;
		}
	}
	public void setToDateTime(LocalDateTime toDateTime) throws Exception {
		if (fromDateTime.isBefore(LocalDateTime.now())) {
			throw new Exception("The arrival time is in the past");
		} else if (fromDateTime.isBefore(fromDateTime)) {
			throw new Exception("The arrival time is set before the departing time");
		} else {
			this.toDateTime = toDateTime;
		}
	}
	public void setSeatCount(int seatCount) {
		if (seatCount < 1) {
			this.seatCount = 1;
		} else {
			this.seatCount = seatCount;	
		}
	}
	public void setDriver(BusDriver driver) throws Exception { //gan v., gan vii.
		if (seatCount < 30 && (driver.getCategories().contains(BusCategory.minibus) || driver.getCategories().contains(BusCategory.schoolbus))) {
			this.driver = driver;
		} else if (seatCount >= 30 && driver.getCategories().contains(BusCategory.largebus)) {
			this.driver = driver;
		} else {
			throw new Exception("Driver qualification doesn't fit bus size");
		}
	}
	public void addTicket(Ticket ticket) throws Exception {
		if (tickets.size() >= seatCount) {
			throw new Exception("Bus is full");
		}
		if (tickets == null) {
			throw new Exception("Invalid ticket");
		}
		if (ticket.isVipTicket()) {
			tickets.add(0, ticket);
		} else {
			tickets.add(ticket);
		}
	}
}
