package vn.model;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class AdditionalPayment {

	private int id;
	private String additionDetails; // ngày phụ thu (ngày lễ, Thứ 7, Chủ nhật)
	private int additionalNormalRoomPrice; // phụ thu tiền phòng thường
	private int additionalVIPRoomPrice; // phụ thu tiền phòng VIP
	private int additionalNormalHourPrice; // phụ thu tiền giờ phòng thường
	private int additionalVIPHourPrice; // phụ thu tiền giờ phòng VIP
	private int additionalNormalNightPrice; // phụ thu tiền qua đêm phòng thường
	private int additionalVIPNightPrice; // phụ thu tiền qua đêm phòng VIP
	private boolean selected;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "AdditionalPayment [id=" + id + ", additionDetails=" + additionDetails + ", additionalNormalRoomPrice="
				+ additionalNormalRoomPrice + ", additionalVIPRoomPrice=" + additionalVIPRoomPrice
				+ ", additionalNormalHourPrice=" + additionalNormalHourPrice + ", additionalVIPHourPrice="
				+ additionalVIPHourPrice + ", additionalNormalNightPrice=" + additionalNormalNightPrice
				+ ", additionalVIPNightPrice=" + additionalVIPNightPrice + ", selected=" + selected + "]";
	}
	
	public DBObject toDBObject() {
		return BasicDBObjectBuilder
				.start("id", id)
				.append("additionDetails", additionDetails)
				.append("additionalNormalRoomPrice", additionalNormalRoomPrice)
				.append("additionalVIPRoomPrice", additionalVIPRoomPrice)
				.append("additionalNormalHourPrice", additionalNormalHourPrice)
				.append("additionalVIPHourPrice", additionalVIPHourPrice)
				.append("additionalNormalNightPrice", additionalNormalNightPrice)
				.append("additionalVIPNightPrice", additionalVIPNightPrice)
				.append("selected", selected)
				.get();
	}

	public AdditionalPayment(int id, String additionDetails, int additionalNormalRoomPrice, int additionalVIPRoomPrice,
			int additionalNormalHourPrice, int additionalVIPHourPrice, int additionalNormalNightPrice,
			int additionalVIPNightPrice, boolean selected) {
		super();
		this.id = id;
		this.additionDetails = additionDetails;
		this.additionalNormalRoomPrice = additionalNormalRoomPrice;
		this.additionalVIPRoomPrice = additionalVIPRoomPrice;
		this.additionalNormalHourPrice = additionalNormalHourPrice;
		this.additionalVIPHourPrice = additionalVIPHourPrice;
		this.additionalNormalNightPrice = additionalNormalNightPrice;
		this.additionalVIPNightPrice = additionalVIPNightPrice;
		this.selected = selected;
	}

	public AdditionalPayment(String additionDetails, int additionalNormalRoomPrice, int additionalVIPRoomPrice,
			int additionalNormalHourPrice, int additionalVIPHourPrice, int additionalNormalNightPrice,
			int additionalVIPNightPrice, boolean selected) {
		super();
		this.additionDetails = additionDetails;
		this.additionalNormalRoomPrice = additionalNormalRoomPrice;
		this.additionalVIPRoomPrice = additionalVIPRoomPrice;
		this.additionalNormalHourPrice = additionalNormalHourPrice;
		this.additionalVIPHourPrice = additionalVIPHourPrice;
		this.additionalNormalNightPrice = additionalNormalNightPrice;
		this.additionalVIPNightPrice = additionalVIPNightPrice;
		this.selected = selected;
	}

	public AdditionalPayment() {
		super();
	}
	
}
