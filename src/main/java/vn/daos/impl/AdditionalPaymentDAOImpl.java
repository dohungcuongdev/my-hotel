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
import model.sql.hotel.HotelItem;
import mongodb.daoimpls.JsonParserDAO;
import mongodb.daoimpls.MongoDbConnector;
import statics.helper.DateTimeCalculator;
import vn.daos.AdditionalPaymentDAO;
import vn.daos.ReservationDAO;
import vn.model.AdditionalPayment;
import vn.model.Income;
import vn.model.Reservation;

/**
*
* @author Do Hung Cuong
*/

@Repository
public class AdditionalPaymentDAOImpl extends JsonParserDAO implements AdditionalPaymentDAO {
	
	private DBCollection collection; 
	
	public AdditionalPaymentDAOImpl() {
		try {
			collection = MongoDbConnector.createConnection("my-hotel-addition-payment");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<AdditionalPayment> getAllAdditionalPayments() {
        List<AdditionalPayment> additionalPayments = new ArrayList<>();
        BasicDBObject orderBy = new BasicDBObject();
        orderBy.put("id", 1);
        DBCursor cursor = collection.find().sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	additionalPayments.add(fromJson3(obj, AdditionalPayment.class));
        }
        return additionalPayments;
	}
	
	public AdditionalPayment getAdditionalPaymentByID(int id) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", id);
        DBObject obj = collection.findOne(whereQuery);
        return fromJson3(obj, AdditionalPayment.class);
	}
	
	@Override
	public AdditionalPayment getSingleAdditionalPayment(String additionDetails) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("additionDetails", additionDetails);
        DBObject obj = collection.findOne(whereQuery);
        return fromJson3(obj, AdditionalPayment.class);
	}
	
	@Override
	public void deSelectAdditionalPayment(int id) {
		setSelectAdditionalPayment(id, false);
	}
	
	@Override
	public void selectAdditionalPayment(int id) {
		setSelectAdditionalPayment(id, true);
	}
	
	private void setSelectAdditionalPayment(int id, boolean isSelected) {
    	BasicDBObject document = new BasicDBObject();
        document.append("$set", new BasicDBObject().append("selected", isSelected));
        BasicDBObject searchQuery = new BasicDBObject().append("id", id);
        collection.update(searchQuery, document);
	}
	
	@Override
	public AdditionalPayment getSelectedAdditionalPayment() {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("selected", true);
        DBObject obj = collection.findOne(whereQuery);
//        if(obj == null)
//        	return getAdditionalPaymentByID(1);
        return fromJson3(obj, AdditionalPayment.class);
	}
	
	@Override
    public boolean isExists (AdditionalPayment additionalPayment) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("additionDetails", additionalPayment.getAdditionDetails());
        DBObject obj = collection.findOne(whereQuery);
        return obj != null;
	}
    
	@Override
    public int findIDAndAddNewAdditionalPayment(AdditionalPayment additionalPayment) {
		if(!isExists(additionalPayment)) {
			BasicDBObject sortQuery = new BasicDBObject();
			sortQuery.put("id", -1);
			DBCursor cursor = collection.find().sort(sortQuery).limit(1);
			int id = cursor.hasNext() ?  Integer.parseInt(cursor.next().get("id").toString()) + 1: 1;
			additionalPayment.setId(id);
	    	collection.insert(additionalPayment.toDBObject());
	    	return additionalPayment.getId();
		}
		return -1;
    }
    
    public int findIDAndAddNewAdditionalPayment(String additionDetails, int additionalNormalRoomPrice, int additionalVIPRoomPrice,
			int additionalNormalHourPrice, int additionalVIPHourPrice, int additionalNormalNightPrice,
			int additionalVIPNightPrice, boolean selected) {
    	AdditionalPayment additionalPayment = new AdditionalPayment(additionDetails, additionalNormalRoomPrice, additionalVIPRoomPrice, additionalNormalHourPrice, additionalVIPHourPrice, additionalNormalNightPrice, additionalVIPNightPrice, selected);
		if(!isExists(additionalPayment)) {
			BasicDBObject sortQuery = new BasicDBObject();
			sortQuery.put("id", -1);
			DBCursor cursor = collection.find().sort(sortQuery).limit(1);
			int id = cursor.hasNext() ?  Integer.parseInt(cursor.next().get("id").toString()) + 1: 1;
			additionalPayment.setId(id);
	    	collection.insert(additionalPayment.toDBObject());
	    	return additionalPayment.getId();
		}
		return -1;
    }
}
