package pers.oyxx.someDemo.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		// 1.Calendar与Date进行转换

		// 用单例模式获得日历对象
		Calendar c1 = Calendar.getInstance();
		// 通过日历对象获得日期对象
		Date d1 = c1.getTime();
		Date d2 = new Date(0);
		c1.setTime(d2);// 把这个日历，调成日期 : 1970.1.1 08:00:00
		String str = sdf.format(c1.getTime());
		System.out.println("设置后的日历日期：" + str);

		// 2.翻日历
		Calendar c2 = Calendar.getInstance();
		Date now = c2.getTime();
		// 当前日期
		System.out.println("当前日期：\t" + format(c2.getTime()));

		// 下个月的今天
		c2.setTime(now);// 复原时间到当前
		c2.add(Calendar.MONTH, 1);
		System.out.println("下个月的今天:\t" + format(c2.getTime()));

		// 去年的今天
		c2.setTime(now);
		c2.add(Calendar.YEAR, -1);
		System.out.println("去年的今天:\t" + format(c2.getTime()));

		// 上个月的第三天
		c2.setTime(now);
		c2.add(Calendar.MONTH, -1);
		// c2.set(Calendar.MONTH, 6);//这样直接设置也可以
		c2.set(Calendar.DATE, 3);
		System.out.println("上个月的第三天:\t" + format(c2.getTime()));

		// 上个月的倒数第三天
		c2.setTime(now);
		c2.add(Calendar.MONTH, 0);// 这个月开始
		//c2.set(Calendar.MONTH, -1);//这样写输出结果会变成：“上个月倒数第三天:	2016-11-27 14:23:48”，为什么？
		c2.set(Calendar.DATE, -3);// 往后推3天，即上个月的倒数第三天
		System.out.println("上个月倒数第三天:\t"+format(c2.getTime()));

	}

	// 将日期转换成指定格式的字符串
	public static String format(Date date) {
		return sdf.format(date);
	}
}
