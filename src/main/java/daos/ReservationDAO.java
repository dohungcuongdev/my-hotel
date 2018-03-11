package daos;

import java.util.List;

import model.mongodb.user.tracking.Reservation;

public interface ReservationDAO {
	
	public List<Reservation> getAllReservations();

	public List<Reservation> getAllReservationsByGuest(String guest);

	public Reservation getReservationByID(int id);

	public int findIDAndAddNewReservation(Reservation reservation);
	
	public Reservation findAndAddNewReservation(Reservation reservation);

	public void checkOutReservation(Reservation reservation);

	public void editReservationInfor(Reservation reservation);
	
	public Reservation findAnUpdateReservation(Reservation reservation);

}
