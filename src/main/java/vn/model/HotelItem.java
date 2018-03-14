package vn.model;

import com.mongodb.DBObject;

import statics.constant.AppData;
import statics.helper.DateTimeCalculator;

public abstract class HotelItem {

	protected int id;
	protected String name;
	protected String type;
	protected int price;
	protected String img;
	protected String img2;
	protected String details;
	protected String created_by;
	protected String created_at;
	protected String last_modify_by;
	protected String last_modify_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
		switch (type) {
		case "VIP":
			return "label label-danger";
		case "Thường":
			return "label label-primary";
		}
		return "label label-primary";
	}

	protected void setInfor(String name, String type, int price, String img, String img2, String details) {
		this.name = name;
		this.price = price;
		this.img = img;
		this.img2 = img2;
		this.type = type;
		this.details = details;
	}

	public void setCreated() {
		this.created_by = AppData.admin.getUsername();
		this.created_at = DateTimeCalculator.getTimeToday();
	}

	public HotelItem() {
	}

	@Override
	public String toString() {
		return "HotelItem [price=" + price + ", img=" + img + ", img2=" + img2 + ", details=" + details + ", type="
				+ type + ", created_by=" + created_by + ", created_at=" + created_at + ", id=" + id + ", name=" + name
				+ "]";
	}

	// use for old DAOs: mongodb DAOs
	public abstract DBObject toDBObject();
}
