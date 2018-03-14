package vn.service;

import java.util.List;

import vn.model.HotelRoom;

public interface HotelItemService {
    public HotelRoom getRoomByID(int id);
    public HotelRoom getRoomByName(String name);
    public List<HotelRoom> getAllRooms();
    public long getNumRooms();
    public List<HotelRoom> getRoomByPage(int page);
    public List<HotelRoom> getRelatedHotelRooms(String type);
    public void updateRoom(HotelRoom room);
    public String findAndAddNewRoom(HotelRoom newRoom);
	public void editImage(String name, String img, String img2);
	public void deleteItem(int id);
	public void checkOutRoom(String name);
	public List<HotelRoom> getAllRoomsCheckin();
	public List<HotelRoom> getAllRoomsAvailable();
}
