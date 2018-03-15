package vn.test;

import java.util.Date;

import statics.helper.DateTimeCalculator;
import vn.model.HourRentalBill;

public class TestBusinessLogic {
	
	private static HourRentalBill getHourRentalBill(String checkin, String checkout, int roomPrice, int hourPrice, int additionalRoomPrice, int additionalHourPrice, int servicePayment) {
		int finalPayment = 0;
		Date from = DateTimeCalculator.getICTDateTimeNoSecond(checkin);
		Date to = DateTimeCalculator.getICTDateTimeNoSecond(checkout);
		long stayDurationMilli = to.getTime() - from.getTime();
		int stayDurationHour = (int) DateTimeCalculator.millToHourUp(stayDurationMilli);
		String stayDuration = DateTimeCalculator.convertSecondsToHMmSs(stayDurationMilli);
		if(stayDurationHour <= 2) {
			finalPayment = roomPrice + servicePayment + additionalRoomPrice;
		} else {
			finalPayment = roomPrice + servicePayment + additionalRoomPrice + hourPrice*(stayDurationHour-2) + additionalHourPrice*(stayDurationHour-2);
		}
		return new HourRentalBill(checkin, checkout, stayDurationMilli, stayDuration, stayDurationHour, roomPrice, hourPrice, additionalRoomPrice, additionalHourPrice, servicePayment, finalPayment);
	}
	
	public static void main(String args[]) {
		HourRentalBill hrb = getHourRentalBill("2018-03-15T10:48", "2018-03-15T18:59", 100000, 20000, 20000, 10000, 25000);
		System.out.println(hrb);
		
	}

}
