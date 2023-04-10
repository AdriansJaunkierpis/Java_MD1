package model;

public class Station {
	private City city;
	private String stationName;
	private String workingHours;
	private long id;
	private static long idCounter = 2000;
	
	public City getCity() {
		return city;
	}
	public String getStationName() {
		return stationName;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public long getId() {
		return id;
	}
	
	public void setCity(City city) {
		if (city != null) {
			this.city = city;
		} else {
			this.city = City.UNKNOWN;
		}
		
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	public void setId() {
		id = idCounter++;
	}
	
	public Station() {
		setCity(City.UNKNOWN);
		setStationName("Unknown");
		setWorkingHours("Unknown");
		setId();
	}
	public Station(City city, String stationName, String workingHours, long id) {
		setCity(city);
		setStationName(stationName);
		setWorkingHours(workingHours);
		setId();
	}
	
	public String toString() {
		return "Station: " + getCity() + ", " + getStationName() + ", ID: " + getId() + ", Open: " + getWorkingHours();
	}
}
