package vn.model;

import java.util.List;

public class Income {

	private String from;
	private String to;
	private List<Reservation> reservations;
	private int totalValue;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "Income [from=" + from + ", to=" + to + ", reservations=" + reservations + ", totalValue=" + totalValue
				+ "]";
	}

	public Income() {
		super();
	}

	public Income(String from, String to, List<Reservation> reservations, int totalValue) {
		super();
		this.from = from;
		this.to = to;
		this.reservations = reservations;
		this.totalValue = totalValue;
	}

}
