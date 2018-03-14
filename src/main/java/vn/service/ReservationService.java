package vn.service;

import java.util.Date;
import java.util.List;

import vn.model.Reservation;

/**
 *
 * @author HUNGCUONG
 */
public interface ReservationService {
	public List<Reservation> getAllReservations();

	public List<Reservation> getAllReservationsByGuest(String guest);
	
	public List<Reservation> getAllReservationsInDate(Date date);

	public Reservation getReservationByID(int id);

	public int findIDAndAddNewReservation(Reservation reservation);
	
	public Reservation findAndAddNewReservation(Reservation reservation);

	public void checkOutReservation(Reservation reservation);

	public void editReservationInfor(Reservation reservation);
	
	public Reservation findAnUpdateReservation(Reservation reservation);
	
	public List<Reservation> getRoomsBookedToday();
}
