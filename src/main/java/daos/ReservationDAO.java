package daos;

import java.util.Date;
import java.util.List;

import model.myhotel.Reservation;

public interface ReservationDAO {
	
	public List<Reservation> getAllReservations();
	
	public List<Reservation> getAllReservationsInDate(Date date);

	public List<Reservation> getAllReservationsByGuest(String guest);

	public Reservation getReservationByID(int id);

	public int findIDAndAddNewReservation(Reservation reservation);
	
	public Reservation findAndAddNewReservation(Reservation reservation);

	public void checkOutReservation(Reservation reservation);

	public void editReservationInfor(Reservation reservation);
	
	public Reservation findAnUpdateReservation(Reservation reservation);
	
	public Reservation getReservationRoomsBooked(String room);

}
