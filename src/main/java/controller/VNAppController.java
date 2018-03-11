package controller;

import java.io.IOException;
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

import model.mongodb.user.Customer;
import model.mongodb.user.tracking.Activity;
import model.mongodb.user.tracking.Reservation;
import model.sql.hotel.HotelRoom;
import model.sql.hotel.HotelService;
import services.ApplicationService;
import services.HotelItemService;
import services.ReservationService;
import services.UserService;
import statics.constant.AppData;

/**
 *
 * @author Do Hung Cuong
 */

@Controller
@RequestMapping(value = "/vn")
public class VNAppController {

	@Autowired
	private UserService userService;

	@Autowired
	private HotelItemService hotelItemService;

	@Autowired
	private ApplicationService appService;
	
	@Autowired
	private ReservationService reservationService;

	// quan li dat phong 
	@RequestMapping(value = { "quan-ly-dat-phong", "quanlydatphong", "index" }, method = RequestMethod.GET)
	public String quanLyDatPhong(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("reservations", reservationService.getAllReservations());
		return authInitializeRedirect(request, response, model, "quan-ly-dat-phong");
	}
	
	// them lich dat phong
	@RequestMapping(value = { "them-lich-dat-phong", "themlichdatphong" }, method = RequestMethod.GET)
	public String themlichdatphong(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("newReservation", new Reservation());
		return authInitializeRedirect(request, response, model, "them-lich-dat-phong");
	}
	
	// sua lich dat phong
	@RequestMapping(value = { "sua-lich-dat-phong/{id}", "sualichdatphong/{id}" }, method = RequestMethod.GET)
	public String sualichdatphong(@PathVariable(value = "id") int id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("reservation", reservationService.getReservationByID(id));
		return authInitializeRedirect(request, response, model, "sua-lich-dat-phong");
	}
	
	// tra phong
	@RequestMapping(value = { "tra-phong/{id}", "traphong/{id}" }, method = RequestMethod.GET)
	public String traPhong(@PathVariable(value = "id") int id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("newReservation", reservationService.getReservationByID(id));
		return authInitializeRedirect(request, response, model, "tra-phong");
	}
	
	// xử lý thêm lịch đặt phòng
	@RequestMapping(value = "dat-phong", method = RequestMethod.POST)
	public String xuLyDatPhong(@ModelAttribute(value = "newReservation") Reservation newReservation, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initialize(model);
		model.addAttribute("reservation", reservationService.findAndAddNewReservation(newReservation));
		return "sua-lich-dat-phong";
	}
	
	// xử lý sửa lịch đặt phòng
	@RequestMapping(value = "sua", method = RequestMethod.POST)
	public String xuLySua(@ModelAttribute(value = "reservation") Reservation reservation, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		initialize(model);
		System.out.println(reservation);
		model.addAttribute("reservation", reservationService.findAnUpdateReservation(reservation));
		return "sua-lich-dat-phong";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private String authInitializeRedirect(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String redirect) {
		initialize(model);
		return redirect;
	}
	// initialize function
	private void initialize(ModelMap model) {
		AppData.admin.setName("Cuong");
		AppData.admin.setImg("1098.jpg");
		
		List<Activity> listactivily = userService.getAllActivity();
		List<HotelRoom> listrooms = hotelItemService.getAllRooms();
		List<HotelService> listservices = hotelItemService.getAllHotelServices();
		List<Customer> listusers = userService.getAllCustomers();
		model.put("ad", AppData.admin);
		model.put("listusers", listusers);
		model.put("newNotifications", userService.getNewListNotification());
		model.put("listactivily", listactivily);
		model.put("listrooms", listrooms);
		model.put("listservices", listservices);
		// model.put("listrooms", AppData.listrooms);
		// model.put("listservices", AppData.listservices);
		model.put("totalUsers", getX100SizeOfList(listusers));
		model.put("totalMessage", getX100SizeOfList(listactivily));
		model.put("totalRooms", getX100SizeOfList(listrooms));
		model.put("totalServices", getX100SizeOfList(listservices));
		// model.put("totalRooms", getX100SizeOfList(AppData.listrooms));
		// model.put("totalServices", getX100SizeOfList(AppData.listservices));
	}

	private int getX100SizeOfList(List<?> list) {
		if (list == null)
			return 0;
		return list.size() * 100;
	}

}
