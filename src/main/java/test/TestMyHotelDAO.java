package test;

import java.net.UnknownHostException;
import java.util.List;

import model.mongodb.user.tracking.Reservation;
import mongodb.daoimpls.ReservationDAOImpl;

import statics.helper.MathCalculator;

public class TestMyHotelDAO {

	public static void main(String[] args) throws UnknownHostException {
		ReservationDAOImpl rDAO = new ReservationDAOImpl();
//		Reservation r = rDAO.getAllReservations().get(0);
//		r.setGuest("ghghgh");
//		System.out.println(rDAO.findAnUpdateReservation(r));
		
		List<Reservation> rs = rDAO.getAllReservationsInDate("2018-03-12");
		System.out.println(rs);
		

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
