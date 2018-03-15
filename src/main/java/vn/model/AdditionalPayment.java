package vn.model;

public class AdditionalPayment {

	private String additionDetails; // ngày phụ thu (ngày lễ, Thứ 7, Chủ nhật)
	private int additionalNormalRoomPrice; // phụ thu tiền phòng thường
	private int additionalVIPRoomPrice; // phụ thu tiền phòng VIP
	private int additionalNormalHourPrice; // phụ thu tiền giờ phòng thường
	private int additionalVIPHourPrice; // phụ thu tiền giờ phòng VIP
	private int additionalNormalNightPrice; // phụ thu tiền qua đêm phòng thường
	private int additionalVIPNightPrice; // phụ thu tiền qua đêm phòng VIP

	public String getAdditionDetails() {
		return additionDetails;
	}

	public void setAdditionDetails(String additionDetails) {
		this.additionDetails = additionDetails;
	}

	public int getAdditionalNormalRoomPrice() {
		return additionalNormalRoomPrice;
	}

	public void setAdditionalNormalRoomPrice(int additionalNormalRoomPrice) {
		this.additionalNormalRoomPrice = additionalNormalRoomPrice;
	}

	public int getAdditionalVIPRoomPrice() {
		return additionalVIPRoomPrice;
	}

	public void setAdditionalVIPRoomPrice(int additionalVIPRoomPrice) {
		this.additionalVIPRoomPrice = additionalVIPRoomPrice;
	}

	public int getAdditionalNormalHourPrice() {
		return additionalNormalHourPrice;
	}

	public void setAdditionalNormalHourPrice(int additionalNormalHourPrice) {
		this.additionalNormalHourPrice = additionalNormalHourPrice;
	}

	public int getAdditionalVIPHourPrice() {
		return additionalVIPHourPrice;
	}

	public void setAdditionalVIPHourPrice(int additionalVIPHourPrice) {
		this.additionalVIPHourPrice = additionalVIPHourPrice;
	}

	public int getAdditionalNormalNightPrice() {
		return additionalNormalNightPrice;
	}

	public void setAdditionalNormalNightPrice(int additionalNormalNightPrice) {
		this.additionalNormalNightPrice = additionalNormalNightPrice;
	}

	public int getAdditionalVIPNightPrice() {
		return additionalVIPNightPrice;
	}

	public void setAdditionalVIPNightPrice(int additionalVIPNightPrice) {
		this.additionalVIPNightPrice = additionalVIPNightPrice;
	}

	@Override
	public String toString() {
		return "AdditionalPayment [additionDetails=" + additionDetails + ", additionalNormalRoomPrice="
				+ additionalNormalRoomPrice + ", additionalVIPRoomPrice=" + additionalVIPRoomPrice
				+ ", additionalNormalHourPrice=" + additionalNormalHourPrice + ", additionalVIPHourPrice="
				+ additionalVIPHourPrice + ", additionalNormalNightPrice=" + additionalNormalNightPrice
				+ ", additionalVIPNightPrice=" + additionalVIPNightPrice + "]";
	}

}
