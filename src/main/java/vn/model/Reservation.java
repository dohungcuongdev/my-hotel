package vn.model;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import vn.daos.impl.RoomDAOImpl;
import vn.daos.RoomDAO;

public class Reservation {
	private int id;
	private String guest;  // khách hàng
	private String rental; // thuê giờ - qua đêm
	private String room;   // phòng
	private String roomPrice; //giá phòng
	private String cMND;   // giấy tờ tùy thân (CMND - giấy tờ xe ...)
	private String note;   // ghi chú (phòng này thu tiền đặc biệt - phòng này cần phụ thu thêm ...)
	private String service;     // dịch vụ ( mì xào bò x2 , cocacola x 3 ... )
	private int servicePayment; // tổng tiền dịch vụ
	private String checkin; //giờ vào
	private String checkout; //giờ ra
	private String totalStayDuration; // tổng thời gian ở trong phòng
	private int additionPayment; // phụ thu
	private int totalPayment; // tổng tiền phải trả
	private String status; // đã thanh toán chưa? phòng còn khách đang ở?
	private String created_by; // người khai đơn
	private String created_at;      // được khai lúc
	private String last_modify_by;  // lần cuối cùng sửa bởi
	private String last_modify_at;  // lần cuối cùng sửa lúc
	
	private RoomDAO roomDAO = new RoomDAOImpl();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getcMND() {
		return cMND;
	}

	public void setcMND(String cMND) {
		this.cMND = cMND;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getCheckin() {
		return checkin;
	}
	
	public String getCheckinTime() {
		return checkin.substring(10);
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getTotalStayDuration() {
		return totalStayDuration;
	}

	public void setTotalStayDuration(String totalStayDuration) {
		this.totalStayDuration = totalStayDuration;
	}

	public int getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	
    public String getRental() {
		return rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}
	
	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getServicePayment() {
		return servicePayment;
	}

	public void setServicePayment(int servicePayment) {
		this.servicePayment = servicePayment;
	}

	public int getAdditionPayment() {
		return additionPayment;
	}

	public void setAdditionPayment(int additionPayment) {
		this.additionPayment = additionPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getLast_modify_by() {
		return last_modify_by;
	}

	public void setLast_modify_by(String last_modify_by) {
		this.last_modify_by = last_modify_by;
	}

	public String getLast_modify_at() {
		return last_modify_at;
	}

	public void setLast_modify_at(String last_modify_at) {
		this.last_modify_at = last_modify_at;
	}

	public String getAutoGenColorClassRoom() {
		switch (roomDAO.getTypeByRoom(room)) {
		case "VIP":
			return "label label-danger";
		case "Thường":
			return "label label-primary";
		}
		return "label label-primary";
	}

	public boolean hasNoValue(Object o) {
    	return (o == null || o.equals("") || o.toString().trim().equals(""));
    }   
	
	public static class CompareDateTime implements Comparator<Reservation> {
		@Override
		public int compare(Reservation r1, Reservation r2) {
			// TODO Auto-generated method stub
			return 0;
		}
    }
	
	//use for old DAOs: mongodb DAOs
	public DBObject toDBObject() {
		return BasicDBObjectBuilder.start("id", id).append("guest", guest).append("cMND", cMND).append("rental", rental).append("note", note).append("service", service).append("room", room).append("checkin", checkin).append("checkout", checkout).append("totalStayDuration", totalStayDuration).append("totalPayment", totalPayment).append("status", status).get();
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guest=" + guest + ", rental=" + rental + ", room=" + room + ", roomPrice="
				+ roomPrice + ", cMND=" + cMND + ", note=" + note + ", service=" + service + ", servicePayment="
				+ servicePayment + ", checkin=" + checkin + ", checkout=" + checkout + ", totalStayDuration="
				+ totalStayDuration + ", additionPayment=" + additionPayment + ", totalPayment=" + totalPayment + "]";
	}

}
