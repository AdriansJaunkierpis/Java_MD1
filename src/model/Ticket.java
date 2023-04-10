package model;

import java.time.LocalDateTime;

public class Ticket {
	private long id;
	private LocalDateTime dateTime;
	private int discount;
	private float price;
	private Cashier cashier;
	private boolean vipTicket;
	private static long idCounter = 10000;
	
	public long getId() {
		return id;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public int getDiscount() {
		return discount;
	}
	public float getPrice() {
		return price;
	}
	public Cashier getCashier() {
		return cashier;
	}
	public boolean isVipTicket() {
		return vipTicket;
	}
	
	public void setId() {
		id = idCounter++;
	}
	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}
	public void setDiscount(int discount) {
		if (discount > 0 && discount <= 100) {
			this.discount = discount;
		} else {
			this.discount = 0;
		}
	}
	public void setPrice(float price) {
		if (price > 0) {
			this.price = price;
		} else {
			this.price = 0;
		}
	}
	public void setCashier(Cashier cashier) {
		if (cashier != null) {
			this.cashier = cashier;
		} else {
			this.cashier = new Cashier();
		}
	}
	public void setVipTicket(boolean vipTicket) {
		if (vipTicket) {
			this.vipTicket = vipTicket;
		} else {
			this.vipTicket = false;
		}
		
	}
	
	public Ticket() {
		setId();
		setDateTime();
		setDiscount(0);
		setPrice(0);
		setCashier(new Cashier());
		setVipTicket(false);
	}
	public Ticket(int discount, float price, Cashier cashier, boolean vipTicket) {
		setId();
		setDateTime();
		setDiscount(discount);
		setPrice(price);
		setCashier(cashier);
		setVipTicket(vipTicket);
	}
	
	public String toString() {
		return "Ticket ID: " + getId() + " " + getDateTime() + ", Price: " + getPrice() + " Discount: " + getDiscount() + ", Cashier: " + getCashier() + ", VIP:" + isVipTicket();
	}
}
