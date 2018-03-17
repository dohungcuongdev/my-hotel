package vn.model;

public class HourRentalBill {

	private String checkin; // giờ vào
	private String checkout; // giờ ra
	private long stayDurationMilli; // thời gian ở tính bàng mili giây
	private String stayDuration; // thời gian ở định dạng hh:mm
	private int stayDurationHour; // thời gian ở làm tròn theo giờ lố 10p tính giờ tiếp theo
	private int roomPrice; // giá phòng
	private int hourPrice; // giá phòng theo giờ
	private int totalRoomPrice; // giá phòng + giá phòng theo giờ
	private String additionDetails; // phụ thu
	private int additionalRoomPrice; // phụ thu thêm tiền giá phòng
	private int additionalHourPrice; // phụ thu giá phòng theo giờ
	private int totaladditional; // tổng phụ thu = phụ thu thêm tiền giá phòng + phụ thu giá phòng theo giờ
	private int servicePayment; // tiền dịch vụ
	private int finalPayment; // tiền phải thanh toán

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

	public long getStayDurationMilli() {
		return stayDurationMilli;
	}

	public void setStayDurationMilli(long stayDurationMilli) {
		this.stayDurationMilli = stayDurationMilli;
	}

	public String getStayDuration() {
		return stayDuration;
	}

	public void setStayDuration(String stayDuration) {
		this.stayDuration = stayDuration;
	}

	public int getStayDurationHour() {
		return stayDurationHour;
	}

	public void setStayDurationHour(int stayDurationHour) {
		this.stayDurationHour = stayDurationHour;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(int hourPrice) {
		this.hourPrice = hourPrice;
	}

	public String getAdditionDetails() {
		return additionDetails;
	}

	public void setAdditionDetails(String additionDetails) {
		this.additionDetails = additionDetails;
	}

	public int getAdditionalRoomPrice() {
		return additionalRoomPrice;
	}

	public void setAdditionalRoomPrice(int additionalRoomPrice) {
		this.additionalRoomPrice = additionalRoomPrice;
	}

	public int getAdditionalHourPrice() {
		return additionalHourPrice;
	}

	public void setAdditionalHourPrice(int additionalHourPrice) {
		this.additionalHourPrice = additionalHourPrice;
	}

	public int getServicePayment() {
		return servicePayment;
	}

	public void setServicePayment(int servicePayment) {
		this.servicePayment = servicePayment;
	}

	public int getTotalRoomPrice() {
		return totalRoomPrice;
	}

	public void setTotalRoomPrice(int totalRoomPrice) {
		this.totalRoomPrice = totalRoomPrice;
	}

	public int getTotaladditional() {
		return totaladditional;
	}

	public void setTotaladditional(int totaladditional) {
		this.totaladditional = totaladditional;
	}

	public int getFinalPayment() {
		return finalPayment;
	}

	public void setFinalPayment(int finalPayment) {
		this.finalPayment = finalPayment;
	}

	public HourRentalBill() {
		super();
	}

	public HourRentalBill(String checkin, String checkout, long stayDurationMilli, String stayDuration,
			int stayDurationHour, int roomPrice, int hourPrice, int totalRoomPrice, String additionDetails,
			int additionalRoomPrice, int additionalHourPrice, int totaladditional, int servicePayment,
			int finalPayment) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.stayDurationMilli = stayDurationMilli;
		this.stayDuration = stayDuration;
		this.stayDurationHour = stayDurationHour;
		this.roomPrice = roomPrice;
		this.hourPrice = hourPrice;
		this.totalRoomPrice = totalRoomPrice;
		this.additionDetails = additionDetails;
		this.additionalRoomPrice = additionalRoomPrice;
		this.additionalHourPrice = additionalHourPrice;
		this.totaladditional = totaladditional;
		this.servicePayment = servicePayment;
		this.finalPayment = finalPayment;
	}

	@Override
	public String toString() {
		return "HourRentalBill [checkin=" + checkin + ", checkout=" + checkout + ", stayDurationMilli="
				+ stayDurationMilli + ", stayDuration=" + stayDuration + ", stayDurationHour=" + stayDurationHour
				+ ", roomPrice=" + roomPrice + ", hourPrice=" + hourPrice + ", totalRoomPrice=" + totalRoomPrice
				+ ", additionDetails=" + additionDetails + ", additionalRoomPrice=" + additionalRoomPrice
				+ ", additionalHourPrice=" + additionalHourPrice + ", totaladditional=" + totaladditional
				+ ", servicePayment=" + servicePayment + ", finalPayment=" + finalPayment + "]";
	}

}
