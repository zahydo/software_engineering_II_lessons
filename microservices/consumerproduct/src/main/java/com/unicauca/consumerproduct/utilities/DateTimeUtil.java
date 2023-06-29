package com.unicauca.consumerproduct.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static int diffInDays(Date start, Date end) {
		long time = end.getTime() - start.getTime();
		return (int) (time / (1000 * 60 * 60 * 24)) % 365;
	}

	public static String dateFormatYYYYMMDD(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
