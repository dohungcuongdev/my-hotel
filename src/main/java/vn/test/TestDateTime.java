package vn.test;

import java.util.Date;

import statics.helper.DateTimeCalculator;

public class TestDateTime {

	public static void main(String[] args) {
		
		String testdate = "19-03-2018 23:57:01";
		System.out.println(DateTimeCalculator.getStrDateTimeWithTNoSecond(testdate));

	}

}
