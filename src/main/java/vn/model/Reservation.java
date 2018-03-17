package vn.model;

import java.util.Comparator;
import java.util.Date;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import model.AbstractModel;
import statics.helper.DateTimeCalculator;
import vn.daos.ReservationDAO;
import vn.daos.RoomDAO;
import vn.daos.impl.ReservationDAOImpl;
import vn.daos.impl.RoomDAOImpl;

public class Reservation extends AbstractModel {
	private int id;
	private String guest;  // khách hàng
	private String rental; // thuê giờ - qua đêm
	private String room;   // phòng
	private int roomPrice; //giá phòng
	private String cMND;   // giấy tờ tùy thân (CMND - giấy tờ xe ...)
	private String note;   // ghi chú (phòng này thu tiền đặc biệt - phòng này cần phụ thu thêm ...)
	private String service;     // dịch vụ ( mì xào bò x2 , cocacola x 3 ... )
	private int servicePayment; // tổng tiền dịch vụ
	private String checkin; //giờ vào
	private String checkout; //giờ ra
	private String totalStayDuration; // tổng thời gian ở trong phòng
	private String additionDetails;  // phụ thu
	private int additionPayment; // tiền phụ thu
	private int totalPayment; // tổng tiền phải trả
	private String status; // đã thanh toán chưa? phòng còn khách đang ở?
	private String created_by; // người khai đơn
	private String created_at;      // được khai lúc
	private String last_modify_by;  // lần cuối cùng sửa bởi
	private String last_modify_at;  // lần cuối cùng sửa lúc
	private String listModifyDate;
	private String listModifyUser;
	private boolean unusual; // có bình thường hay ko (không bt là khi tiền thu khác so với hệ thống tính toán)
	private String billAt; // xuất hóa đơn lúc

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
	
	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getServicePayment() {
		return servicePayment;
	}

	public void setServicePayment(int servicePayment) {
		this.servicePayment = servicePayment;
	}

	public String getAdditionDetails() {
		return additionDetails;
	}

	public void setAdditionDetails(String additionDetails) {
		this.additionDetails = additionDetails;
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

	public String getListModifyDate() {
		return listModifyDate;
	}

	public void setListModifyDate(String listModifyDate) {
		this.listModifyDate = listModifyDate;
	}

	public String getListModifyUser() {
		return listModifyUser;
	}

	public void setListModifyUser(String listModifyUser) {
		this.listModifyUser = listModifyUser;
	}
	
	public boolean isHackerAccess() {
		ReservationDAO reservationDAO = new ReservationDAOImpl();
		Reservation oldVersionReservation = reservationDAO.getReservationByID(id);
		if(oldVersionReservation != null) {
			if(oldVersionReservation.created_by != this.created_by)
				return true;
			if(oldVersionReservation.created_at != this.created_at)
				return true;
			String lastPersonAccess = this.listModifyUser.substring(this.listModifyUser.lastIndexOf(',') + 1);
			if(!((oldVersionReservation.listModifyUser).equals(this.listModifyUser)))
				return true;
			String lastDateAccess = this.listModifyDate.substring(this.listModifyDate.lastIndexOf(',') + 1);
			if(!((oldVersionReservation.listModifyDate).equals(this.listModifyDate)))
				return true;
			return false;
		}
		return true;
	}
	
	public String getUserWasHacked() {
		if(isHackerAccess()) {
			return MyHotelConst.user.getUsername();
		}
		return null;
	}
	
	public void initSomeInforToAddNew() {
    	if(hasNoValue(checkin)) {
    		setCheckin(DateTimeCalculator.getStrDateTimeWithTNoSecondToday());
    	}
    	setStatus("Khách đang ở");
		String dateTimeToday = DateTimeCalculator.getStrDateTimeVNToday();
		setCreated_at(dateTimeToday);
		setLast_modify_at(dateTimeToday);
		setCreated_by(MyHotelConst.user.getName());
		setLast_modify_by(MyHotelConst.user.getName());
		setListModifyDate(dateTimeToday);
		setListModifyUser(MyHotelConst.user.getName());
	}
	
	public void initSomeInforToUpdate() {
    	if(hasNoValue(checkin)) {
    		setCheckin(DateTimeCalculator.getStrDateTimeWithTNoSecondToday());
    	}
		String dateTimeToday = DateTimeCalculator.getStrDateTimeVNToday();
		setLast_modify_at(dateTimeToday);
		setLast_modify_by(MyHotelConst.user.getName());
		setListModifyDate(this.listModifyDate + ", " + dateTimeToday);
		setListModifyUser(this.listModifyUser + ", " + MyHotelConst.user.getName());
	}
	
	public boolean isCorrectCheckoutInfor() {
		RoomDAO roomDAO = new RoomDAOImpl();
		Date from = DateTimeCalculator.getICTDateTimeNoSecond(checkin);
		Date to = DateTimeCalculator.getICTDateTimeNoSecond(checkout);
		long stayDurationMilli = to.getTime() - from.getTime();
		int stayDurationHour = (int) DateTimeCalculator.millToHourUp(stayDurationMilli);
		if(!checkNaturalNumberAccept0(roomPrice, servicePayment, additionPayment, totalPayment))
			return false;
		if(!checkNaturalNumber(stayDurationHour))
			return false;
		if(totalPayment != roomPrice + servicePayment + additionPayment) 
			return false;
    	return (roomDAO.getRoomByName(room) != null);
    		
	}
	
	public void initSomeInforToCheckOut() {
    	setStatus("Đã thanh toán");
    	if(hasNoValue(checkout)) {
    		setCheckout(DateTimeCalculator.getStrDateTimeWithTNoSecondToday());
    	}
    	initSomeInforToUpdate();
	}

	public String getAutoGenColorClassRoom() {
		RoomDAO roomDAO = new RoomDAOImpl();
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
	
	public void simpleComputeTotalPayment() {
		this.totalPayment = this.roomPrice + this.servicePayment + this.additionPayment;
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
		return BasicDBObjectBuilder
				.start("id", id)
				.append("guest", guest)
				.append("cMND", cMND)
				.append("rental", rental)
				.append("room", room)
				.append("checkin", checkin)
				.append("checkout", checkout)
				.append("totalStayDuration", totalStayDuration)
				.append("roomPrice", roomPrice)
				.append("note", note)
				.append("service", service)
				.append("servicePayment", servicePayment)
				.append("additionDetails", additionDetails)
				.append("additionPayment", additionPayment)
				.append("totalPayment", totalPayment)
				.append("status", status)
				.append("created_by", created_by)
				.append("created_at", created_at)
				.append("last_modify_by", last_modify_by)
				.append("last_modify_at", last_modify_at)
				.get();
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guest=" + guest + ", rental=" + rental + ", room=" + room + ", roomPrice="
				+ roomPrice + ", cMND=" + cMND + ", note=" + note + ", service=" + service + ", servicePayment="
				+ servicePayment + ", checkin=" + checkin + ", checkout=" + checkout + ", totalStayDuration="
				+ totalStayDuration + ", additionDetails=" + additionDetails + ", additionPayment=" + additionPayment
				+ ", totalPayment=" + totalPayment + ", status=" + status + ", created_by=" + created_by
				+ ", created_at=" + created_at + ", last_modify_by=" + last_modify_by + ", last_modify_at="
				+ last_modify_at + ", listModifyDate=" + listModifyDate + ", listModifyUser=" + listModifyUser
				+ "]";
	}

}
