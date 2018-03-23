package vn.model;

public class MyHotelConst {
	public static User user = new User();
	public static final int startUnit = 1000; // đơn vị x 1000 VNĐ
	//public static final int startUnit = 1;
	
	
	static {
		user.setName("Cuong");
		user.setImg("1098.jpg");
		user.setRole("receptionist");
	}
	
	
	public static String additionDetails = "ngay-le";
	public static int additionPayment1 = 0;
	public static int additionPayment2 = 0;
	
	public static final String CHUA_CO_KHACH = "chưa có khách";
	public static final String KHACH_DANG_O = "khách đang ở";
	public static final String VIP = "VIP";
	public static final String PHONG_THUONG = "Phòng thường";
	
	public static String wellDisplayAdditionDetails() {
	    switch (additionDetails) { 
		case "ngay-le":
			return "Ngày Lễ";
		case "thu-7": 
			return "Thứ Bảy";
		case "CN": 
			return "Chủ Nhật";
		case "ngay-le7": 
			return "Ngày Lễ + Thứ Bảy";
		case "ngay-leCN": 
			return "Ngày Lễ + Chủ Nhật";
		default:
			return "Ngày Thường";
		}
	}
	

}
