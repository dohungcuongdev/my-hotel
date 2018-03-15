package vn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.sql.hotel.HotelService;
import statics.constant.AppData;
import statics.helper.DateTimeCalculator;
import vn.model.Reservation;
import vn.service.HotelItemService;
import vn.service.ReservationService;
import vn.helper.VNCurrencyFormatter;
import vn.model.HotelRoom;
import vn.model.MyHotelConst;

/**
 *
 * @author Do Hung Cuong
 */

@Controller
@RequestMapping(value = "/vn")
public class VNAppController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private HotelItemService hotelItemService;
	
	// don phong trong ngay 
	@RequestMapping(value = { "don-phong-hom-nay", "donphonghomnay", "index" }, method = RequestMethod.GET)
	public String donPhongTrongNgay(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return authInitializeRedirect(request, response, model, "don-phong-hom-nay");
	}
	
	// don phong hom qua 
	@RequestMapping(value = { "don-phong-hom-qua", "donphonghomqua" }, method = RequestMethod.GET)
	public String donPhongHomQua(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Date yesterday = DateTimeCalculator.getYesterday();
		model.put("yesterday", DateTimeCalculator.getStrDateVN(yesterday));
		model.put("reservations", reservationService.getAllReservationsInDate(yesterday));
		return authInitializeRedirect(request, response, model, "don-phong-trong-ngay");
	}

	// lich su dat phong
	@RequestMapping(value = { "lich-su-dat-phong", "lichsudatphong" }, method = RequestMethod.GET)
	public String quanLyDatPhong(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("reservations", reservationService.getAllReservations());
		return authInitializeRedirect(request, response, model, "lich-su-dat-phong");
	}
	
	// them lich dat phong
	@RequestMapping(value = { "them-lich-dat-phong", "themlichdatphong" }, method = RequestMethod.GET)
	public String themlichdatphong(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("newReservation", new Reservation());
		initializeRoomsWithType(model);
		return authInitializeRedirect(request, response, model, "them-lich-dat-phong");
	}
	
	// sua lich dat phong
	@RequestMapping(value = { "sua-lich-dat-phong/{id}", "sualichdatphong/{id}" }, method = RequestMethod.GET)
	public String sualichdatphong(@PathVariable(value = "id") int id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("reservation", reservationService.getReservationByID(id));
		initializeRoomsWithType(model);
		return authInitializeRedirect(request, response, model, "sua-lich-dat-phong");
	}
	
	// tra phong
	@RequestMapping(value = { "tra-phong/{id}", "traphong/{id}" }, method = RequestMethod.GET)
	public String traPhong(@PathVariable(value = "id") int id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("newReservation", reservationService.getReservationByID(id));
		initializeRoomsWithType(model);
		return authInitializeRedirect(request, response, model, "tra-phong");
	}
	
	// danh sach phong
	@RequestMapping(value = { "danh-sach-phong", "danhsachphong" }, method = RequestMethod.GET)
	public String danhsachphong(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("listrooms", hotelItemService.getAllRooms());
		return authInitializeRedirect(request, response, model, "danh-sach-phong");
	}
	
	// phong dang o
	@RequestMapping(value = { "phong-dang-o", "phongdango" }, method = RequestMethod.GET)
	public String phongDangO(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("roomsBooked", reservationService.getRoomsBookedToday());
		return authInitializeRedirect(request, response, model, "phong-dang-o");
	}
	
	// phong con
	@RequestMapping(value = { "phong-con", "phongcon" }, method = RequestMethod.GET)
	public String phongCon(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("listrooms", hotelItemService.getAllRoomsAvailable());
		return authInitializeRedirect(request, response, model, "phong-con");
	}
	
	// xử lý thêm lịch đặt phòng
	@RequestMapping(value = "dat-phong", method = RequestMethod.POST)
	public String xuLyDatPhong(@ModelAttribute(value = "newReservation") Reservation newReservation, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initialize(model);
		initializeRoomsWithType(model);
		model.addAttribute("reservation", reservationService.findAndAddNewReservation(newReservation));
		return "sua-lich-dat-phong";
	}
	
	// xử lý sửa lịch đặt phòng
	@RequestMapping(value = "sua", method = RequestMethod.POST)
	public String xuLySua(@ModelAttribute(value = "reservation") Reservation reservation, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initialize(model);
		initializeRoomsWithType(model);
		System.out.println(reservation);
		model.addAttribute("reservation", reservationService.findAnUpdateReservation(reservation));
		return "sua-lich-dat-phong";
	}
	
	//them phong
	@RequestMapping(value = "them-phong", method = RequestMethod.GET)
	public String addRoom(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("newRoom", new HotelRoom());
		return authInitializeRedirect(request, response, model, "them-phong");
	}
	
	
	// xử lí thêm phòng
	@RequestMapping(value = "xu-ly-them-phong", method = RequestMethod.POST)
	public String roomAdded(@ModelAttribute(value = "newRoom") HotelRoom newRoom, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initialize(model);
		model.addAttribute("roomEdit", new HotelRoom());
		model.put("room", newRoom);
//		model.put("relatedRoom", hotelItemService.getRelatedHotelRooms(newRoom.getType()));
//		newRoomName = hotelItemService.findAndAddNewRoom(newRoom);
		hotelItemService.findAndAddNewRoom(newRoom);
		model.put("listrooms", hotelItemService.getAllRooms());
		return authInitializeRedirect(request, response, model, "danh-sach-phong");
			
	}
	
	// phu thu
	@RequestMapping(value = { "phu-thu", "phuthu" }, method = RequestMethod.GET)
	public String phuThu(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initializeAdditionalPayment(model);
		return authInitializeRedirect(request, response, model, "phu-thu");
	}
	
	@RequestMapping(value = { "phu-thu/{additionDetails}/{additionPayment1}/{additionPayment2}", "phuthu/{additionDetails}/{additionPayment1}/{additionPayment2}" }, method = RequestMethod.GET)
	public String phuThu3Param(@ModelAttribute(value = "additionDetails") String additionDetails, @ModelAttribute(value = "additionPayment1") int additionPayment1, @ModelAttribute(value = "additionPayment2") int additionPayment2, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MyHotelConst.additionDetails = additionDetails;
    	MyHotelConst.additionPayment1 = additionPayment1;
    	MyHotelConst.additionPayment2 = additionPayment2;
    	initializeAdditionalPayment(model);
		return authInitializeRedirect(request, response, model, "phu-thu");
	}
	
	// thu nhap hom nay
	@RequestMapping(value = { "thu-nhap-theo-ngay", "thunhaptheongay" }, method = RequestMethod.GET)
	public String thuNhapHomNay(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		return authInitializeRedirect(request, response, model, "thu-nhap-theo-ngay");
	}
	
	// thu nhap theo ngay
	@RequestMapping(value = { "thu-nhap-theo-ngay/{date}", "thunhaptheongay/{date}" }, method = RequestMethod.GET)
	public String thuNhapTheoNgay(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		return authInitializeRedirect(request, response, model, "thu-nhap-theo-ngay");
	}
	
	
	
	
	
	
	
	
	
	
	
	private void initializeAdditionalPayment(ModelMap model) {
		int totalAdditionalPayment = MyHotelConst.additionPayment1 + MyHotelConst.additionPayment2;
	    model.put("additionDetails", MyHotelConst.wellDisplayAdditionDetails());
		model.put("additionPayment1", MyHotelConst.additionPayment1);
		model.put("additionPayment2", MyHotelConst.additionPayment2);
		model.put("additionPayment", VNCurrencyFormatter.wellDisplayNumber(totalAdditionalPayment));
		model.put("additionPaymentAlpha", VNCurrencyFormatter.numberToString(totalAdditionalPayment));
	}
	
	
	private void initializeRoomsWithType(ModelMap model) {
		model.put("roomsWithType", hotelItemService.getListRoomsWithType());
	}
	

	private String authInitializeRedirect(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String redirect) {
		initialize(model);
		return redirect;
	}
	// initialize function
	private void initialize(ModelMap model) {
		MyHotelConst.user.setName("Cuong");
		MyHotelConst.user.setImg("1098.jpg");
		
		Date today = new Date();
		model.put("today", DateTimeCalculator.getStrDateVN(today));
		List<Reservation> listReservationToday = reservationService.getAllReservationsInDate(today);
		List<HotelRoom> listRoomAvailable = hotelItemService.getAllRoomsAvailable();
		List<Reservation> listRoomCheckin = reservationService.getRoomsBookedToday();
		List<HotelService> listservices = new ArrayList<HotelService>();
		
		model.put("user", MyHotelConst.user);
		
		model.put("newNotifications", new ArrayList());
		model.put("listReservationToday", listReservationToday);
		model.put("listRoomAvailable", listRoomAvailable);
		model.put("listRoomCheckin", listRoomCheckin);
		model.put("listservices", listservices);

		model.put("totalReservationToday", getX100SizeOfList(listReservationToday));
		model.put("totalRoomAvailable", getX100SizeOfList(listRoomAvailable));
		model.put("totalRoomCheckin", getX100SizeOfList(listRoomCheckin));
		model.put("totalServices", getX100SizeOfList(listservices));
	}

	private int getX100SizeOfList(List<?> list) {
		if (list == null)
			return 0;
		return list.size() * 100;
	}

}
