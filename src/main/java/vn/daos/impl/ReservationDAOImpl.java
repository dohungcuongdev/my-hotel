package vn.daos.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import daos.RoomDAO;
import mongodb.daoimpls.JsonParserDAO;
import mongodb.daoimpls.MongoDbConnector;
import statics.helper.DateTimeCalculator;
import vn.daos.ReservationDAO;
import vn.model.Income;
import vn.model.Reservation;

/**
*
* @author Do Hung Cuong
*/

@Repository
public class ReservationDAOImpl extends JsonParserDAO implements ReservationDAO {
	
	private DBCollection collection; 
	
	public ReservationDAOImpl() {
		try {
			collection = MongoDbConnector.createConnection("my-hotel-reservation");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        orderBy.put("checkin", -1);
        DBCursor cursor = collection.find().sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	reservations.add(fromJson3(obj, Reservation.class));
        }
        return reservations;
	}
	
	@Override
	public List<Reservation> getAllReservationsInDate(Date date) {
        List<Reservation> reservations = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        BasicDBObject whereQuery = new BasicDBObject();
        String query = "{$regex : '" + DateTimeCalculator.getStrDate(date) + "'}";
        whereQuery.put("checkin", BasicDBObject.parse(query));
        orderBy.put("checkin", -1);
        DBCursor cursor = collection.find(whereQuery).sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	reservations.add(fromJson3(obj, Reservation.class));
        }
        return reservations;
	}
	
	@Override
	public List<Reservation> getAllReservationsByGuest(String guest) {
        List<Reservation> reservations = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("guest", guest);
        orderBy.put("checkin", -1);
        DBCursor cursor = collection.find(whereQuery).sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	reservations.add(fromJson3(obj, Reservation.class));
        }
        return reservations;
	}
	
	@Override
	public Reservation getReservationByID(int id) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", id);
        DBObject obj = collection.findOne(whereQuery);
        System.out.println(obj);
        return fromJson3(obj, Reservation.class);
	}
    
	@Override
    public int findIDAndAddNewReservation(Reservation reservation) {
    	if(reservation.hasNoValue(reservation.getCheckin())) {
    		reservation.setCheckin(new Date().toString());
    	}
		BasicDBObject sortQuery = new BasicDBObject();
		sortQuery.put("checkin", -1);
		DBCursor cursor = collection.find().sort(sortQuery).limit(1);
		int id = cursor.hasNext() ?  Integer.parseInt(cursor.next().get("id").toString()) + 1: 1;
		reservation.setId(id);
    	collection.insert(reservation.toDBObject());
    	return reservation.getId();
    }

	@Override
	public Reservation findAndAddNewReservation(Reservation reservation) {
    	if(reservation.hasNoValue(reservation.getCheckin())) {
    		reservation.setCheckin(new Date().toString());
    	}
    	reservation.setStatus("Khách đang ở");
		BasicDBObject sortQuery = new BasicDBObject();
		sortQuery.put("checkin", -1);
		DBCursor cursor = collection.find().sort(sortQuery).limit(1);
		int id = cursor.hasNext() ?  Integer.parseInt(cursor.next().get("id").toString()) + 1: 1;
		reservation.setId(id);
    	collection.insert(reservation.toDBObject());
    	return reservation;
	}
    
	@Override
    public void checkOutReservation(Reservation reservation) {
    	if(reservation.hasNoValue(reservation.getCheckout())) {
    		reservation.setCheckout(new Date().toString());
    	}
    	if(reservation.hasNoValue(reservation.getTotalStayDuration())) {
    		//Date 1 - Date 2
    	}
    	if(reservation.hasNoValue(reservation.getTotalPayment())) {
    		
    	}
    	reservation.setStatus("Đã thanh toán");
    	editReservationInfor(reservation);
    }
    
	@Override
    public void editReservationInfor(Reservation reservation) {
        DBObject document = parseJSON(toJson(reservation));
        DBObject searchObject = new BasicDBObject();
        searchObject.put("id", reservation.getId());
        collection.update(searchObject, document);
    }

	@Override
	public Reservation findAnUpdateReservation(Reservation reservation) {
        DBObject document = parseJSON(toJson(reservation));
        DBObject searchObject = new BasicDBObject();
        searchObject.put("id", reservation.getId());
        collection.update(searchObject, document);
        return reservation;
	}
    
    @Override
    public Reservation getReservationRoomsBooked(String room) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("room", room);
        BasicDBObject sortQuery = new BasicDBObject();
		sortQuery.put("checkin", -1);
		DBCursor cursor = collection.find(whereQuery).sort(sortQuery).limit(1);
		DBObject obj = cursor.next();
        return fromJson3(obj, Reservation.class);
    }
    
    @Override
    public List<Reservation> getRoomsBookedToday() {
        List<Reservation> roomsBookedToday = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("status", "Khách đang ở");
        orderBy.put("checkin", -1);
        DBCursor cursor = collection.find(whereQuery).sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	Reservation reservationRoomToday = fromJson3(obj, Reservation.class);
        	roomsBookedToday.add(reservationRoomToday);
        }
        return roomsBookedToday;
    }
    
    //db.getCollection('my-hotel-reservation').find({ checkin : { $gte : "2018-03-11T06:00", $lte : "2018-03-14T23:20"}})
    @Override
    public Income getIncomeFromTo(String from, String to) {
    	Income income = new Income();
    	int roomPayment = 0;
    	int totalServicePayment = 0;
    	int additionPayment = 0;
    	int totalValue = 0;
        List<Reservation> reservationsFromTo = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        BasicDBObject whereQuery = new BasicDBObject();
        String query = "{ $gte : '" + from + ", $lte : '" + to + "'}";
        whereQuery.put("checkin", query);
        orderBy.put("checkin", -1);
        DBCursor cursor = collection.find(whereQuery).sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	Reservation reservationFromTo = fromJson3(obj, Reservation.class);
        	reservationsFromTo.add(reservationFromTo);
        	roomPayment += reservationFromTo.getRoomPrice();
        	totalServicePayment += reservationFromTo.getServicePayment();
        	additionPayment += reservationFromTo.getAdditionPayment();
        	totalValue += reservationFromTo.getTotalPayment();
        }
        income.setFrom(from);
        income.setTo(to);
        income.setReservations(reservationsFromTo);
        income.setTotalValue(roomPayment);
        income.setTotalValue(totalServicePayment);
        income.setTotalValue(additionPayment);
        income.setTotalValue(totalValue);
        return income;
    }
}
