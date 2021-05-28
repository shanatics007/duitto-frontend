package com.Duitto.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class MethodsUtility {

	public static long getCurrentTimestamp()
	 {
		 Instant instant = Instant.now();
		 long timeStampMillis = instant.toEpochMilli();
		 return timeStampMillis;
	 }

	public static String getFormatedShippedDate(String date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date1 = dateFormat.parse(date);
        DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyy");
		String strDate = dateFormat1.format(date1);
		return strDate;
	}
}
