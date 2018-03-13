package mongodb.daoimpls;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import daos.ReservationDAO;
import model.mongodb.user.tracking.Activity;
import model.mongodb.user.tracking.Reservation;
import statics.helper.MathCalculator;

/**
*
* @author Do Hung Cuong
*/

@Repository
public class ReservationDAOImpl extends JsonParserDAO implements ReservationDAO {
	
	private DBCollection collection; 
	
	public ReservationDAOImpl() throws UnknownHostException {
		collection = MongoDbConnector.createConnection("my-hotel-reservation");
	}
	
	@Override
	public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        orderBy.put("id", -1);
        DBCursor cursor = collection.find().sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	reservations.add(fromJson3(obj, Reservation.class));
        }
        return reservations;
	}
	
	@Override
	public List<Reservation> getAllReservationsInDate(String date) {
        List<Reservation> reservations = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        BasicDBObject whereQuery = new BasicDBObject();
        String query = "{$regex : '" + date + "'}";
        whereQuery.put("checkin", BasicDBObject.parse(query));
        orderBy.put("id", -1);
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
        orderBy.put("id", -1);
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
		sortQuery.put("id", -1);
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
		BasicDBObject sortQuery = new BasicDBObject();
		sortQuery.put("id", -1);
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
}
