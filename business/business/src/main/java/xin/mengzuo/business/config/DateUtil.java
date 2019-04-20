package xin.mengzuo.business.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.hibernate.annotations.CreationTimestamp;
import org.junit.Test;

/**
 * 时间处理类
 * @author 左利伟
 *时间格式:yyyy-MM-dd HH:mm:ss
 */
public class DateUtil {
	/**
	 * 传入时间得到年月
	 * @author 左利伟
	 */
	public static Integer getMouth(String date) throws ParseException {
		Calendar calen = 
				Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date da = dateformat.parse(date);
		StringBuffer sb = new StringBuffer();
		calen.setTime(da);
	 sb.append(String.valueOf(calen.get(calen.YEAR)));
	 sb.append(String.valueOf(calen.get(calen.MONTH)+1));
	 
	 return Integer.valueOf(sb.toString());
		
	}
	public static Integer getMouthDay(String date) throws ParseException {
		Calendar calen = 
				Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date da = dateformat.parse(date);
		StringBuffer sb = new StringBuffer();
		calen.setTime(da);
		
	 sb.append(String.valueOf(calen.get(calen.YEAR)));
	 sb.append(String.valueOf(calen.get(calen.MONTH)+1));
	 sb.append(String.valueOf(calen.get(calen.DATE)));
	 return Integer.valueOf(sb.toString());
		
	}
	/**
	 * 返回月份格式yyyy-MM
	 * @author 左利伟
	 */
	public static String getDateMouth(String date) {
		String mouth = date.substring(0, 7);
		return mouth;
	}
	/**
	 * 返回天份格式yyyy-MM
	 * @author 左利伟
	 */
	public static String getDateMouthDay(String date) {
		String day = date.substring(0, 10);
		return day;
	}
	
	@Test
	public  void Test() throws ParseException {
		String date = "2019-04-20 10:00:00";
		System.out.println(getDateMouth(date));
		System.out.println(getDateMouthDay(date));
	}
}
