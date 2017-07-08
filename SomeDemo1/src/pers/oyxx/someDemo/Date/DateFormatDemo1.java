package pers.oyxx.someDemo.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/*y 代表年
M 代表月
d 代表日
H 代表24进制的小时
h 代表12进制的小时
m 代表分钟
s 代表秒
S 代表毫秒*/

public class DateFormatDemo1 {

	public static void main(String[] args) {
		// 字符串转日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = "2016/1/5 12:12:12";
		try{
			Date dd=sdf.parse(str);
			System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss 转换为日期对象: %s",str,dd.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// 日期转字符串
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String str1 = sdf1.format(d);
		System.out.println();
		System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: " + str1);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String str2 = sdf2.format(d);
		System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: " + str2);
	}

}
