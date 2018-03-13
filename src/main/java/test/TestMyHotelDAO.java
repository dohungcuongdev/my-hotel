package test;

import java.net.UnknownHostException;
import java.util.List;

import model.myhotel.Reservation;
import model.sql.hotel.HotelRoom;
import mongodb.daoimpls.ReservationDAOImpl;
import mongodb.daoimpls.RoomDAOImpl;

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
		
		Reservation r = rDAO.getReservationRoomsBooked("101");
		System.out.println(r);
	}
	
	public static void testRoom() throws UnknownHostException {
		RoomDAOImpl rDAO = new RoomDAOImpl();
		List<HotelRoom> rs = rDAO.getAllRoomsAvailable();
		System.out.println(rs);
	}

	public static void main(String[] args) throws UnknownHostException {
		testReservation();

		

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
