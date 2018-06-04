package com.flame.yogaassistant.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	public static final String DAY_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public static final String DAY_FORMAT_YYYYMMDD = "yyyyMMdd";

	public static final String TIME_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMAT_YYYY_MM_DD_HH_MM_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String TIME_FORMAT_YYYY_MM_DD_HH_MM_ss_SSSS = "yyyy-MM-dd HH:mm:ss.SSSS";

	public static final String TIME_FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	public static String dateToString(Date dateValue, String dateFormat) {
		if (dateValue == null) {
			return "";
		}
		String sDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sDate = sdf.format(dateValue);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException(ex.getMessage());
		}
		return sDate;
	}
	
	/**
	 * string转时间
	 * 
	 * @param dateValue
	 * @param dateFormat
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateValue,String dateFormat) throws ParseException {
		if (dateValue == null) {
			return null;
		}
		try {
			DateFormat df = new SimpleDateFormat(dateFormat);
			return df.parse(dateValue);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * long转时间
	 * 
	 * @param dateValue
	 * @param dateFormat
	 * @return
	 */
	public static String longToDate(long dateValue, String dateFormat) {
		Date date = new Date(dateValue);
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date); 
	}
}
