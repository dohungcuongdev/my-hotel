package vn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import statics.helper.DateTimeCalculator;
import vn.daos.AdditionalPaymentDAO;
import vn.daos.ReservationDAO;
import vn.daos.RoomDAO;
import vn.daos.impl.AdditionalPaymentDAOImpl;
import vn.daos.impl.ReservationDAOImpl;
import vn.daos.impl.RoomDAOImpl;
import vn.model.AdditionalPayment;
import vn.model.HotelRoom;
import vn.model.HourRentalBill;
import vn.model.Reservation;
import vn.service.ReservationService;

/**
 *
 * @author HUNGCUONG
 */

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationDAO = new ReservationDAOImpl();
	
	@Autowired
	private RoomDAO roomDAO = new RoomDAOImpl();
	
	@Autowired
	private AdditionalPaymentDAO additionalPaymentDAO = new AdditionalPaymentDAOImpl();
	
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

	@Override
	public List<Reservation> getRoomsBookedToday() {
		return reservationDAO.getRoomsBookedToday();
	}
	
	public Reservation getReservationByHourRentalBill(HourRentalBill hourRentalBill, Reservation reservation) {
		reservation.setRoomPrice(hourRentalBill.getRoomPrice() + hourRentalBill.getHourPrice());
		reservation.setTotalStayDuration(hourRentalBill.getStayDuration());
		reservation.setAdditionPayment(hourRentalBill.getAdditionalRoomPrice() + hourRentalBill.getAdditionalHourPrice());
		reservation.setTotalPayment(hourRentalBill.getFinalPayment());
		return reservation;
	}
	
	public HourRentalBill getHourRentalBillForReservation(Reservation reservation) {
		HotelRoom room = roomDAO.getRoomByName(reservation.getRoom());
		if(room.getType().equals("VIP")) {
			return getHourRentalBillVIPRoom(reservation.getAdditionDetails(), reservation.getCheckin(), reservation.getCheckout(), room.getPrice(), room.getHourPrice(), reservation.getServicePayment());
		}
		return getHourRentalBillNormalRoom(reservation.getAdditionDetails(), reservation.getCheckin(), reservation.getCheckout(), room.getPrice(), room.getHourPrice(), reservation.getServicePayment());
	}
	
	public HourRentalBill getHourRentalBillForRoom(HotelRoom room, String additionDetails, String checkin, String checkout, int servicePayment) {
		if(room.getType().equals("VIP")) {
			return getHourRentalBillVIPRoom(additionDetails, checkin, checkout, room.getPrice(), room.getHourPrice(), servicePayment);
		}
		return getHourRentalBillNormalRoom(additionDetails, checkin, checkout, room.getPrice(), room.getHourPrice(), servicePayment);
	}
	
	public HourRentalBill getHourRentalBillForRoom(String roomType, String additionDetails, String checkin, String checkout, int roomPrice, int hourPrice, int servicePayment) {
		if(roomType.equals("VIP")) {
			return getHourRentalBillVIPRoom(additionDetails, checkin, checkout, roomPrice, hourPrice, servicePayment);
		}
		return getHourRentalBillNormalRoom(additionDetails, checkin, checkout, roomPrice, hourPrice, servicePayment);
	}
	
	public HourRentalBill getHourRentalBillNormalRoom(String additionDetails, String checkin, String checkout, int roomPrice, int hourPrice, int servicePayment) {
		if(additionDetails == null || additionDetails.equals(""))
			return getHourRentalBill(checkin, checkout, roomPrice, hourPrice, 0, 0, servicePayment);
		AdditionalPayment additionalPayment = additionalPaymentDAO.getSingleAdditionalPayment(additionDetails);
		int additionalRoomPrice = additionalPayment.getAdditionalNormalRoomPrice();
		int additionalHourPrice = additionalPayment.getAdditionalNormalHourPrice();
		return getHourRentalBill(checkin, checkout, roomPrice, hourPrice, additionalRoomPrice, additionalHourPrice, servicePayment);
	}
	
	public HourRentalBill getHourRentalBillVIPRoom(String additionDetails, String checkin, String checkout, int roomPrice, int hourPrice, int servicePayment) {
		if(additionDetails == null || additionDetails.equals(""))
			return getHourRentalBill(checkin, checkout, roomPrice, hourPrice, 0, 0, servicePayment);
		AdditionalPayment additionalPayment = additionalPaymentDAO.getSingleAdditionalPayment(additionDetails);
		int additionalRoomPrice = additionalPayment.getAdditionalVIPRoomPrice();
		int additionalHourPrice = additionalPayment.getAdditionalVIPHourPrice();
		return getHourRentalBill(checkin, checkout, roomPrice, hourPrice, additionalRoomPrice, additionalHourPrice, servicePayment);
	}
	
	public HourRentalBill getHourRentalBill(String checkin, String checkout, int roomPrice, int hourPrice, int additionalRoomPrice, int additionalHourPrice, int servicePayment) {
		int finalPayment = 0;
		Date from = DateTimeCalculator.getICTDateTimeNoSecond(checkin);
		Date to = DateTimeCalculator.getICTDateTimeNoSecond(checkout);
		long stayDurationMilli = to.getTime() - from.getTime();
		int stayDurationHour = (int) DateTimeCalculator.millToHourUp(stayDurationMilli);
		String stayDuration = DateTimeCalculator.convertSecondsToHMmSs(stayDurationMilli);
		if(stayDurationHour <= 2) {
			finalPayment = roomPrice + servicePayment + additionalRoomPrice;
		} else {
			finalPayment = roomPrice + servicePayment + additionalRoomPrice + hourPrice*(stayDurationHour-2) + additionalHourPrice*(stayDurationHour-2);
		}
		return new HourRentalBill(checkin, checkout, stayDurationMilli, stayDuration, stayDurationHour, roomPrice, hourPrice, additionalRoomPrice, additionalHourPrice, servicePayment, finalPayment);
	}

}
