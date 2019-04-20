package xin.mengzuo.ticketmanager.config;

import java.util.Calendar;
import java.util.TimeZone;
/**
 * 相对日期转换成毫秒值
 * @author 左利伟
 *
 */
public class DateToMillsByDayUtil {
	/**
	 * @author 左利伟
	 */
	/**
	 * 相对日期早上9点毫秒值
	 * @author 左利伟
	 */
	public static long getStartMillsByDay(int day) {
		Calendar calen = Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
		int year = calen.get(Calendar.YEAR);
		int month = calen.get(Calendar.MONTH);
		int date = calen.get(Calendar.DATE);
		calen.set(year, month, date+day, 1, 0);
		return calen.getTimeInMillis();
		
	}
	/**
	 * 相对日期晚上23点毫秒值
	 * @author 左利伟
	 */
	public static long getEndMillsByDay(int day) {
		Calendar calen = Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
		int year = calen.get(Calendar.YEAR);
		int month = calen.get(Calendar.MONTH);
		int date = calen.get(Calendar.DATE);
		calen.set(year, month, date+day, 15, 0);
		return calen.getTimeInMillis();
	}
}
