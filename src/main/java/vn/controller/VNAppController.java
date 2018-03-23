package vn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.sql.hotel.HotelService;
import statics.helper.DateTimeCalculator;
import vn.helper.VNCurrencyFormatter;
import vn.model.AdditionalPayment;
import vn.model.HotelRoom;
import vn.model.MyHotelConst;
import vn.model.Reservation;
import vn.service.AdditionalPaymentService;
import vn.service.HotelItemService;
import vn.service.ReservationService;

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
	
	@Autowired
	private AdditionalPaymentService additionalPaymentService;
	
	// login
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
//		if (isAuthenticated(request))
//			return index(request, response, model);
		return "login";
	}
	
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
		initializeAdditionalPayment(model);
		return authInitializeRedirect(request, response, model, "them-lich-dat-phong");
	}
	
	// sua lich dat phong
	@RequestMapping(value = { "sua-lich-dat-phong/{id}", "sualichdatphong/{id}" }, method = RequestMethod.GET)
	public String sualichdatphong(@PathVariable(value = "id") int id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("reservation", reservationService.getReservationByID(id));
		initializeRoomsWithType(model);
		initializeAdditionalPayment(model);
		return authInitializeRedirect(request, response, model, "sua-lich-dat-phong");
	}
	
	// tra phong
	@RequestMapping(value = { "tra-phong/{id}", "traphong/{id}" }, method = RequestMethod.GET)
	public String traPhong(@PathVariable(value = "id") int id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		initializeRoomsWithType(model);
		AdditionalPayment selectedAdditionalPayment = additionalPaymentService.getSelectedAdditionalPayment();
		Reservation reservation = reservationService.getReservationByID(id);
		reservation = reservationService.getReservationByAdditionalPayment(reservation, selectedAdditionalPayment);
		model.addAttribute("reservation", reservation);
		return authInitializeRedirect(request, response, model, "tra-phong");
	}
	
	// Tính lại đon phòng
	@RequestMapping(value = { "tinh-lai-don-phong", "tinhlaidonphong" }, method = RequestMethod.POST)
	public String tinhLaiDonPhong(@ModelAttribute(value = "reservation") Reservation reservation, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initializeRoomsWithType(model);
		reservation.simpleComputeTotalPayment();
		model.addAttribute("reservation", reservation);
		return authInitializeRedirect(request, response, model, "tra-phong");
	}
	
	// luu-xuat-hoa-don
	@RequestMapping(value = { "luu-xuat-hoa-don", "luuxuathoadon" }, method = RequestMethod.POST)
	public String luuXuatHoaDon(@ModelAttribute(value = "reservation") Reservation reservation, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initializeRoomsWithType(model);
		Reservation checkedout = reservationService.checkOutReservation(reservation);
		if(checkedout != null) {
			model.addAttribute("reservation", checkedout);
			
			//return authInitializeRedirect(request, response, model, "xuat-hoa-don");
		} else
		model.addAttribute("reservation", reservation);
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
		initializeAllAdditionalPayment(model);
		return authInitializeRedirect(request, response, model, "phu-thu");
	}
	
	@RequestMapping(value = { "phu-thu/{newID}/{selectedID}", "phuthu/{newID}/{selectedID}" }, method = RequestMethod.GET)
	public String phuThu2Param(@ModelAttribute(value = "newID") int newID, @ModelAttribute(value = "selectedID") int selectedID, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		additionalPaymentService.deSelectAdditionalPayment(selectedID);
		additionalPaymentService.selectAdditionalPayment(newID);
		initializeAllAdditionalPayment(model);
		return authInitializeRedirect(request, response, model, "phu-thu");
	}
	
	@RequestMapping(value = "ap-dung-moi/{additionDetails}/{additionalVIPRoomPrice}/{additionalVIPHourPrice}/{additionalVIPNightPrice}/{additionalNormalRoomPrice}/{additionalNormalHourPrice}/{additionalNormalNightPrice}/{selectedID}" , method = RequestMethod.GET)
	public String apDungMoi(@ModelAttribute(value = "additionDetails") String additionDetails,
							@ModelAttribute(value = "additionalVIPRoomPrice") int additionalVIPRoomPrice,
							@ModelAttribute(value = "additionalVIPHourPrice") int additionalVIPHourPrice, 
							@ModelAttribute(value = "additionalVIPNightPrice") int additionalVIPNightPrice, 
							@ModelAttribute(value = "additionalNormalRoomPrice") int additionalNormalRoomPrice, 
							@ModelAttribute(value = "additionalNormalHourPrice") int additionalNormalHourPrice, 
							@ModelAttribute(value = "additionalNormalNightPrice") int additionalNormalNightPrice, 
			                @ModelAttribute(value = "selectedID") int selectedID, 
			                HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		additionalPaymentService.deSelectAdditionalPayment(selectedID);
		additionalPaymentService.findIDAndAddNewAdditionalPayment(additionDetails, additionalNormalRoomPrice, additionalVIPRoomPrice, additionalNormalHourPrice, additionalVIPHourPrice, additionalNormalNightPrice, additionalVIPNightPrice, true);
		initializeAllAdditionalPayment(model);
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
		AdditionalPayment selectedAdditionalPayment = additionalPaymentService.getSelectedAdditionalPayment();
		int additionalVIPRoomPrice = selectedAdditionalPayment.getAdditionalVIPRoomPrice();
		int additionalVIPHourPrice = selectedAdditionalPayment.getAdditionalVIPHourPrice();
		int additionalVIPNightPrice = selectedAdditionalPayment.getAdditionalVIPNightPrice();
		int additionalNormalRoomPrice = selectedAdditionalPayment.getAdditionalNormalRoomPrice();
		int additionalNormalHourPrice = selectedAdditionalPayment.getAdditionalNormalHourPrice();
		int additionalNormalNightPrice = selectedAdditionalPayment.getAdditionalNormalNightPrice();		
		
		model.put("selectedID", selectedAdditionalPayment.getId());
		model.put("additionDetails", selectedAdditionalPayment.getAdditionDetails());
		
		model.put("additionalVIPRoomPrice", VNCurrencyFormatter.wellDisplayNumber(additionalVIPRoomPrice));
		model.put("additionalVIPHourPrice", VNCurrencyFormatter.wellDisplayNumber(additionalVIPHourPrice));
		model.put("additionalVIPNightPrice", VNCurrencyFormatter.wellDisplayNumber(additionalVIPNightPrice));
		model.put("additionalNormalRoomPrice", VNCurrencyFormatter.wellDisplayNumber(additionalNormalRoomPrice));
		model.put("additionalNormalHourPrice", VNCurrencyFormatter.wellDisplayNumber(additionalNormalHourPrice));
		model.put("additionalNormalNightPrice", VNCurrencyFormatter.wellDisplayNumber(additionalNormalNightPrice));

		model.put("additionalVIPRoomPriceStr", VNCurrencyFormatter.numberToString(additionalVIPRoomPrice));
		model.put("additionalVIPHourPriceStr", VNCurrencyFormatter.numberToString(additionalVIPHourPrice));
		model.put("additionalVIPNightPriceStr", VNCurrencyFormatter.numberToString(additionalVIPNightPrice));
		model.put("additionalNormalRoomPriceStr", VNCurrencyFormatter.numberToString(additionalNormalRoomPrice));
		model.put("additionalNormalHourPriceStr", VNCurrencyFormatter.numberToString(additionalNormalHourPrice));
		model.put("additionalNormalNightPriceStr", VNCurrencyFormatter.numberToString(additionalNormalNightPrice));
	}
	
	private void initializeAllAdditionalPayment(ModelMap model) {
		model.put("allAdditionalPayments", additionalPaymentService.getAllAdditionalPayments());
		initializeAdditionalPayment(model);
		
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
