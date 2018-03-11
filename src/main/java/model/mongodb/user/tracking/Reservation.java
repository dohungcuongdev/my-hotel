package model.mongodb.user.tracking;

import java.util.Comparator;
import java.util.List;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

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

	public String getAutoGenColorClassRoom() {
		switch (room) {
		case "101":
			return "label label-danger";
		case "102":
			return "label label-primary";
		}
		return "label";
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
		return BasicDBObjectBuilder.start("id", id).append("guest", guest).append("cMND", cMND).append("note", note).append("service", service).append("room", room).append("checkin", checkin).append("checkout", checkout).append("totalStayDuration", totalStayDuration).append("totalPayment", totalPayment).get();
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guest=" + guest + ", rental=" + rental + ", room=" + room + ", roomPrice="
				+ roomPrice + ", cMND=" + cMND + ", note=" + note + ", service=" + service + ", servicePayment="
				+ servicePayment + ", checkin=" + checkin + ", checkout=" + checkout + ", totalStayDuration="
				+ totalStayDuration + ", additionPayment=" + additionPayment + ", totalPayment=" + totalPayment + "]";
	}

}
