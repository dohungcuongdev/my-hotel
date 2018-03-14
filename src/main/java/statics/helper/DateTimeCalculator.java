/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statics.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do Hung Cuong
 */
public class DateTimeCalculator {

	public static Date getToday() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return formatDateTime(format.format(new Date()));
	}

	public static String getTimeToday() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return format.format(new Date());
	}

	public static Date getDateFormated(String strDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		return format.parse(strDate);
	}

	public static Date formatDateTime(String dateTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateTime);
		} catch (ParseException ex) {
			Logger.getLogger(DateTimeCalculator.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static Date formatDateTime(String dateTime) {
		return formatDateTime(dateTime, "yyyy-MM-dd");
	}

	public static Date getICTDateTime(String dateTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatDateTime(dateTime.replaceFirst("T", " "), "yyyy-MM-dd HH:mm:ss"));
		cal.add(Calendar.HOUR_OF_DAY, 7);
		return cal.getTime();
	}

	public static String getStringICTDateTime(String dateTime) {
		Date date = formatDateTime(dateTime, "E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		return format.format(date);
	}

	public static String getStringICTDateTime(Object dateTimeobj) {
		Date date = formatDateTime(dateTimeobj.toString(), "E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		return format.format(date).replaceFirst(" ", "T") + "Z";
	}
	
	public static String getStrToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(new Date());
	}
	
	public static String getStrDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public static Date getPreviousDate(Date date, int n) {
		return new Date(date.getTime() - n * 24 * 3600 * 1000 ); //Subtract n days 
	}
	
	public static Date getYesterday() {
		return getPreviousDate(new Date(), 1);
	}
	
	public static String  getYesterdayStrDateVN() {
		return getStrDateVN(getYesterday());
	}
	
	public static String getStrDateVN(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}
	
	public static String getStrDateTimeVN(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return formatter.format(date);
	}
	
	public static String getStrDateTimeVNToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return formatter.format(new Date());
	}
}
