package email;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

/**
 * 获取给定日期所在周始末日期
 * @param date 给定日期
 * @param simpleDateFormat  日期格式，默认 "yyyy-MM-dd"
 * @return
 */
	public static String getWeekInterval(String date, String simpleDateFormat) {
		StringBuilder weekStr = new StringBuilder("");
		if (date == null || date.length() == 0) {
			return date.toString();
		}
		if (simpleDateFormat == null || simpleDateFormat.length() == 0) {
			simpleDateFormat = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
		Calendar cal = Calendar.getInstance();
		Date time;
		try {
			time = sdf.parse(date);
			cal.setTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		// 国际上以周日为一周开始，如果日期正好为周日，那么减掉一天来计算，否则会计算到下个星期的日期
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置星期一为本周第一天
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获取当天是周几
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// System.out.println(day);
		// 设置当天的星期周第一天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		weekStr.append(sdf.format(cal.getTime()));
		// 从周第一天加6天，即为周末
		cal.add(Calendar.DATE, 6);
		weekStr.append(",");
		weekStr.append(sdf.format(cal.getTime()));

		return weekStr.toString();
	}

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		System.out.println(date);
		System.out.println(dateStr);
//		String interval = getWeekInterval(dateStr, "yyyy-MM-dd");
//		System.out.println(interval);
		System.out.println(getWeekInterval("2020-10-14", "yyyy-MM-dd"));
	}

}
