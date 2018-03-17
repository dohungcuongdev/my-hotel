package vn.model;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import vn.model.HotelItem;

public class HotelRoom extends HotelItem {

	private int size;
	private String status;
	private int numpeople;
	private String amenities;
	private int hourPrice;
	private int overnightPrice;

	public HotelRoom() {
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumpeople() {
		return numpeople;
	}

	public void setNumpeople(int numpeople) {
		this.numpeople = numpeople;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public int getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(int hourPrice) {
		this.hourPrice = hourPrice;
	}

	public int getOvernightPrice() {
		return overnightPrice;
	}

	public void setOvernightPrice(int overnightPrice) {
		this.overnightPrice = overnightPrice;
	}

	@Override
	public String toString() {
		return "HotelRoom [size=" + size + ", status=" + status + ", numpeople=" + numpeople + ", amenities="
				+ amenities + ", id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", img=" + img
				+ ", img2=" + img2 + ", details=" + details + ", created_by=" + created_by + ", created_at="
				+ created_at + ", last_modify_by=" + last_modify_by + ", last_modify_at=" + last_modify_at + "]";
	}

	@Override
	public DBObject toDBObject() {
		return BasicDBObjectBuilder
				.start("id", id)
				.append("name", name)
				.append("type", type)
				.append("size", size)
				.append("price", price)
				.append("hourPrice", hourPrice)
				.append("overnightPrice", overnightPrice)
				.append("numpeople", numpeople)
				.append("status", status)
				.append("img", img)
				.append("img2", img2)
				.append("details", details)
				.append("amenities", amenities)
				.append("created_by", created_by)
				.append("created_at", created_at)
				.append("last_modify_by", last_modify_by)
				.append("last_modify_at", last_modify_at)
				.get();
	}

	public HotelRoom(int id, String name, String type, int price, String img, String img2, String details,
			String created_by, String created_at, String last_modify_by, String last_modify_at, int size, String status,
			int numpeople, String amenities, int hourPrice, int overnightPrice) {
		super(id, name, type, price, img, img2, details, created_by, created_at, last_modify_by, last_modify_at);
		this.size = size;
		this.status = status;
		this.numpeople = numpeople;
		this.amenities = amenities;
		this.hourPrice = hourPrice;
		this.overnightPrice = overnightPrice;
	}

	public HotelRoom(String name, String type, int price, String img, String img2, String details, String created_by,
			String created_at, String last_modify_by, String last_modify_at, int size, String status, int numpeople,
			String amenities, int hourPrice, int overnightPrice) {
		super(name, type, price, img, img2, details, created_by, created_at, last_modify_by, last_modify_at);
		this.size = size;
		this.status = status;
		this.numpeople = numpeople;
		this.amenities = amenities;
		this.hourPrice = hourPrice;
		this.overnightPrice = overnightPrice;
	}
}
