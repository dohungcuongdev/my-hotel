package vn.test;

import java.net.UnknownHostException;

import vn.daos.impl.ReservationDAOImpl;
import vn.model.AdditionalPayment;
import vn.model.Reservation;
import vn.service.impl.AdditionalPaymentServiceImpl;
import vn.service.impl.ReservationServiceImpl;

public class TestMyHotelDAO {
	
	public static void testReservation() throws UnknownHostException {
		ReservationDAOImpl rDAO = new ReservationDAOImpl();
//		Reservation r = rDAO.getAllReservations().get(0);
//		r.setGuest("ghghgh");
//		System.out.println(rDAO.findAnUpdateReservation(r));
		
//		List<Reservation> rs = rDAO.getAllReservationsInDate(new Date());
//		System.out.println(rs);
		
//		List<Reservation> rs = rDAO.getAllReservations();
//		System.out.println(rs);
	}

	public static void main(String[] args) throws UnknownHostException {
		AdditionalPaymentServiceImpl ad = new AdditionalPaymentServiceImpl();
		AdditionalPayment a = ad.getSelectedAdditionalPayment();
		ReservationServiceImpl rs = new ReservationServiceImpl();
		Reservation r = rs.getReservationByID(1);
		System.out.println(rs.getReservationByAdditionalPayment(r, a));

	}
	
	// thuật toán tính tiền phòng
	public static int getRoomPriceAutoComputed()  {
		return 1;
	}
	
	// thuật toán tính tiền dịch vụ
	public static int getServicePaymentAutoComputed()  {
		return 2;
	}
	
	// thuật toán tính tiền phụ thu
	public static int getAdditionPaymentAutoComputed()  {
		return 3;
	}

	// thuật toán tính tiền tổng sô tiền phải thanh toán
	public static int getTotalPaymentAutoComputed()  {
		return getRoomPriceAutoComputed() + getServicePaymentAutoComputed() + getAdditionPaymentAutoComputed();
	}


}
