/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.daos;

import java.util.List;
import java.util.Map;

import vn.model.HotelRoom;

/**
 *
 * @author Do Hung Cuong
 */
public interface RoomDAO {

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
	public String getTypeByRoom(String roomName);
	public Map<String, String> getListRoomsWithType();
}
