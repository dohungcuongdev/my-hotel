package vn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import statics.helper.DateTimeCalculator;
import vn.daos.RoomDAO;
import vn.model.HotelRoom;
import vn.model.MyHotelConst;
import vn.service.HotelItemService;

/**
 *
 * @author HUNGCUONG
 */

@Service
public class HotelItemServiceImpl implements HotelItemService {

	@Autowired
	RoomDAO roomDAO;

	@Override
	public HotelRoom getRoomByID(int id) {
		return roomDAO.getRoomByID(id);
	}

	@Override
	public HotelRoom getRoomByName(String name) {
		return roomDAO.getRoomByName(name);
	}

	@Override
	public List<HotelRoom> getAllRooms() {
		return roomDAO.getAllRooms();
	}

	@Override
	public long getNumRooms() {
		return roomDAO.getNumRooms();
	}

	@Override
	public List<HotelRoom> getRoomByPage(int page) {
		return roomDAO.getRoomByPage(page);
	}

	@Override
	public List<HotelRoom> getRelatedHotelRooms(String type) {
		return roomDAO.getRelatedHotelRooms(type);
	}

	@Override
	public void updateRoom(HotelRoom room) {
		roomDAO.updateRoom(room);
	}

	@Override
	public String findAndAddNewRoom(HotelRoom newRoom) {
		newRoom.setStatus("chưa có khách");
		String dateTimeToday = DateTimeCalculator.getStrDateTimeVNToday();
		newRoom.setCreated_at(dateTimeToday);
		newRoom.setLast_modify_at(dateTimeToday);
		newRoom.setCreated_by(MyHotelConst.user.getName());
		newRoom.setLast_modify_by(MyHotelConst.user.getName());
		return roomDAO.findAndAddNewRoom(newRoom);
	}

	@Override
	public void editImage(String name, String img, String img2) {
		roomDAO.editImage(name, img, img2);

	}

	@Override
	public void deleteItem(int id) {
		roomDAO.deleteItem(id);

	}

	@Override
	public void checkOutRoom(String name) {
		roomDAO.checkOutRoom(name);
	}

	@Override
	public List<HotelRoom> getAllRoomsCheckin() {
		return roomDAO.getAllRoomsCheckin();
	}

	@Override
	public List<HotelRoom> getAllRoomsAvailable() {
		return roomDAO.getAllRoomsAvailable();
	}

}
