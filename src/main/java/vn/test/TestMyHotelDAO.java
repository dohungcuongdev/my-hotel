package vn.test;

import java.net.UnknownHostException;

import vn.daos.impl.RoomDAOImpl;
import vn.model.HotelRoom;

public class TestMyHotelDAO {

	public static void main(String[] args) throws UnknownHostException {
		//addRoom();

	}
	
	public static void addRoom() {
		addRoom("101","VIP");
		addRoom("102","Thường");
		addRoom("103","Thường");
		addRoom("201","VIP");
		addRoom("202","Thường");
		addRoom("203","Thường");
		addRoom("204","VIP");
		addRoom("205","VIP");
		addRoom("301","VIP");
		addRoom("302","Thường");
		addRoom("303","Thường");
		addRoom("304","VIP");
		addRoom("305","VIP");
		addRoom("401","VIP");
		addRoom("402","Thường");
		addRoom("403","Thường");
		addRoom("404","VIP");
		addRoom("405","VIP");
		addRoom("501","VIP");
		addRoom("502","Thường");
		addRoom("503","Thường");
		addRoom("504","VIP");
		addRoom("505","VIP");
		addRoom("601","VIP");
	}
	
	
	public static void addRoom(String name, String type) {
		RoomDAOImpl rd = new RoomDAOImpl();
		String details = "Phòng đẹp";
		String amenity = "Wifi, Máy Lạnh, TV, Quạt, Giường";
		int roomPrice = 100000;
		int hourPrice = 20000;
		int overnightPrice = 200000;
		int numpeople = 2;
		int size = 150;
		if(type.equals("VIP")) {
			details = "Phòng siêu đẹp";
			amenity = "Wifi, Máy Lạnh, TV, Quạt, Tủ lạnh, Giường rộng";
			roomPrice = 110000;
			hourPrice = 25000;
			overnightPrice = 220000;
			size = 200;
		}
		
		if(name.equals("201")) {
			details = "Phòng đôi siêu đẹp";
			numpeople = 4;
			size = 250;
		}
			
		HotelRoom newRoom = new HotelRoom(name, type, roomPrice, "hinh"+name+"_1.jpg", "hinh"+name+"_2.jpg", details, "Cường",
				"15-03-2018 02:02:02", "Cường", "15-03-2018 02:02:02", size, "chưa có khách", numpeople,
				amenity, hourPrice, overnightPrice);
		System.out.println(rd.findAndAddNewRoom(newRoom));
	}
	

}
