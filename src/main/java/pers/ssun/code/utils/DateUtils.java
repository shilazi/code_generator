package pers.ssun.code.utils;

import java.util.Date;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.08
 */
public class DateUtils {

	public static String getTimeInterval(Date start, Date end) {
		Long sec = (end.getTime() - start.getTime()) / 1000;
		return sec == 0 ? String.valueOf(end.getTime() - start.getTime()) + "ms" : sec.toString() + "s";
	}
}
