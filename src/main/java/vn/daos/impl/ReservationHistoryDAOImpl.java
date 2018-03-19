package vn.daos.impl;

import java.net.UnknownHostException;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import mongodb.daoimpls.MongoDbConnector;
import vn.daos.ReservationHistoryDAO;
import vn.model.Reservation;

@Repository
public class ReservationHistoryDAOImpl implements ReservationHistoryDAO {

	private DBCollection collection;

	public ReservationHistoryDAOImpl() {
		try {
			collection = MongoDbConnector.createConnection("my-hotel-reservation-history");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Reservation findAndAddNewReservation(Reservation reservation) {
		collection.insert(reservation.toDBObjectRH());
		return reservation;
	}
	
	@Override
	public void addNewReservation(Reservation reservation) {
		collection.insert(reservation.toDBObjectRH());
	}
}
