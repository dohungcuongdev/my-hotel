package vn.daos;

import java.util.Date;
import java.util.List;

import vn.model.Income;
import vn.model.Reservation;

public interface ReservationDAO {
	
	public List<Reservation> getAllReservations();
	
	public List<Reservation> getAllReservationsInDate(Date date);

	public List<Reservation> getAllReservationsByGuest(String guest);

	public Reservation getReservationByID(int id);

	public int findIDAndAddNewReservation(Reservation reservation);
	
	public Reservation findAndAddNewReservation(Reservation reservation);

	public void checkOutReservation(Reservation reservation);

	public void editReservationInfor(Reservation reservation);
	
	public Reservation findAndUpdateReservation(Reservation reservation);
	
	public Reservation getReservationRoomsBooked(String room);
		
	public List<Reservation> getRoomsBookedToday();
	
    public Income getIncomeFromTo(String from, String to);

}
