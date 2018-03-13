package services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.ReservationDAO;
import model.myhotel.Reservation;
import services.ReservationService;

/**
 *
 * @author HUNGCUONG
 */

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationDAO;
	
	@Override
	public List<Reservation> getAllReservations() {
		return reservationDAO.getAllReservations();
	}

	@Override
	public List<Reservation> getAllReservationsByGuest(String guest) {
		return reservationDAO.getAllReservationsByGuest(guest);
	}

	@Override
	public Reservation getReservationByID(int id) {
		return reservationDAO.getReservationByID(id);
	}

	@Override
	public int findIDAndAddNewReservation(Reservation reservation) {
		return reservationDAO.findIDAndAddNewReservation(reservation);
	}

	@Override
	public void checkOutReservation(Reservation reservation) {
		reservationDAO.checkOutReservation(reservation);
		
	}

	@Override
	public void editReservationInfor(Reservation reservation) {
		reservationDAO.editReservationInfor(reservation);
		
	}

	@Override
	public Reservation findAndAddNewReservation(Reservation reservation) {
		return reservationDAO.findAndAddNewReservation(reservation);
	}

	@Override
	public Reservation findAnUpdateReservation(Reservation reservation) {
		return reservationDAO.findAnUpdateReservation(reservation);
	}

	@Override
	public List<Reservation> getAllReservationsInDate(Date date) {
		return reservationDAO.getAllReservationsInDate(date);
	}

}
