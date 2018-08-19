package org.blem.greek.utils;

import java.util.Date;

import org.joda.time.DateTime;

public class DateTimeUtils {

	public static Date getCurrentDate() {
		DateTime curDateTime = DateTime.now();
		return curDateTime.toDate();
	}

	public static DateTime getCurrentDateTime() {
		return DateTime.now();
	}
}
