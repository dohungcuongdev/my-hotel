package vn.daos;

import vn.model.Reservation;

public interface ReservationHistoryDAO {
	public Reservation findAndAddNewReservation(Reservation reservation);
	public void addNewReservation(Reservation reservation);
}
