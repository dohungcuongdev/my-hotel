/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.daos.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.model.Projections;

import mongodb.daoimpls.MongoDbConnector;
import vn.daos.HotelItemDAO;
import vn.daos.RoomDAO;
import vn.model.HotelRoom;

/**
 *
 * @author Do Hung Cuong
 */

@Repository
public class RoomDAOImpl extends HotelItemDAO<HotelRoom> implements RoomDAO {

	public RoomDAOImpl() {
		classOfT = HotelRoom.class;
		try {
			collection = MongoDbConnector.createConnection("my-hotel-room");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public HotelRoom getRoomByID(int id) {
		return (HotelRoom) getHotelItemByID(id);
	}
	
	@Override
	public HotelRoom getRoomByName(String name) {
		return (HotelRoom) getHotelItemByName(name);
	}

	@Override
	public List<HotelRoom> getAllRooms() {
		return getAllHotelItems();
	}

	@Override
	public List<HotelRoom> getRelatedHotelRooms(String type) {
		return getRelatedHotelItems(type);
	}

	@Override
	public String findAndAddNewRoom(HotelRoom newRoom) {
		return findAndAddNewItem(newRoom);
	}

	@Override
	public List<HotelRoom> getRoomByPage(int page) {
		ArrayList<HotelRoom> rooms = new ArrayList<>();
		DBCursor cursor = collection.find().skip((page - 1) * 6).limit(6);
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			rooms.add(fromJson3(obj, classOfT));
		}
		return rooms;
	}

	@Override
	public long getNumRooms() {
		return collection.count();
	}

	@Override
	public void updateRoom(HotelRoom room) {
		updateItem(room);
	}
	
	@Override
	public void checkOutRoom(String name) {
    	BasicDBObject document = new BasicDBObject();
        document.append("$set", new BasicDBObject().append("status", "đã thanh toán"));
        BasicDBObject searchQuery = new BasicDBObject().append("name", name);
        collection.update(searchQuery, document);
    }
	
    @Override
    public List<HotelRoom> getAllRoomsCheckin() {
        List<HotelRoom> roomsBooked = new ArrayList<>();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("status", "khách đang ở");
        DBCursor cursor = collection.find(whereQuery);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	roomsBooked.add(fromJson3(obj, HotelRoom.class));
        }
        return roomsBooked;
    }
    
    @Override
    public List<HotelRoom> getAllRoomsAvailable() {
        List<HotelRoom> roomsAvailable = new ArrayList<>();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("status", "chưa có khách");
        DBCursor cursor = collection.find(whereQuery);
        while (cursor.hasNext()) {
        	DBObject obj = cursor.next();
        	roomsAvailable.add(fromJson3(obj, HotelRoom.class));
        }
        return roomsAvailable;
    }
    
    @Override
    public String getTypeByRoom(String roomName) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("name", roomName);
		DBObject obj = collection.findOne(whereQuery);
		return fromJson3(obj, HotelRoom.class).getType();
    }
}
