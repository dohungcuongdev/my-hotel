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
        orderBy.put("id", -1);
        DBCursor cursor = collection.find().sort(orderBy);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	additionalPayments.add(fromJson3(obj, AdditionalPayment.class));
        }
        return additionalPayments;
	}
	
	@Override
	public AdditionalPayment getSingleAdditionalPayment(String additionDetails) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("additionDetails", additionDetails);
        DBObject obj = collection.findOne(whereQuery);
        return fromJson3(obj, AdditionalPayment.class);
	}
}
