package vn.model;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import vn.model.HotelItem;

public class HotelRoom extends HotelItem {

	private int size;
	private String status;
	private int numpeople;
	private String amenities;

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

	@Override
	public String toString() {
		return "HotelRoom [size=" + size + ", status=" + status + ", numpeople=" + numpeople + ", amenities="
				+ amenities + ", id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", img=" + img
				+ ", img2=" + img2 + ", details=" + details + ", created_by=" + created_by + ", created_at="
				+ created_at + ", last_modify_by=" + last_modify_by + ", last_modify_at=" + last_modify_at + "]";
	}

	@Override
	public DBObject toDBObject() {
		return BasicDBObjectBuilder.start("id", id).append("name", name).append("type", type).append("size", size)
				.append("price", price).append("numpeople", numpeople).append("status", status).append("img", img)
				.append("img2", img2).append("details", details).append("amenities", amenities)
				.append("created_by", created_by).append("created_at", created_at)
				.append("last_modify_by", last_modify_by).append("last_modify_at", last_modify_at).get();
	}
}
