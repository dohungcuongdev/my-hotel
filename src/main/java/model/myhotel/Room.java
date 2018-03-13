package model.myhotel;

import com.mongodb.DBObject;

import model.sql.hotel.HotelItem;
import mongodb.daoimpls.ReservationDAOImpl;

public class Room extends HotelItem {
	
	private String status;
	private Reservation currentReservation;
	private String room;
	private ReservationDAOImpl rDAOimp;

	@Override
	public void initializeSomeInfor() {
		if(status.equals("đã có khách")) {
			currentReservation = rDAOimp.getReservationRoomsBooked(room);
		} else if(status.equals("chưa có khách")) {
			currentReservation = null;
		}
		
	}

	@Override
	public String isAbleToUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewInfor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DBObject toDBObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
