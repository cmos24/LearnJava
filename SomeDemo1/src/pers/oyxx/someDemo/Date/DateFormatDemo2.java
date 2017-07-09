package pers.oyxx.someDemo.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*准备一个长度是9的日期数组
使用1970年-2000年之间的随机日期初始化该数组
按照这些日期的时间进行升序排序
比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大*/

public class DateFormatDemo2 {

	public static void main(String[] args) {
		String randomTime=null;
		Random random = new Random();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		long randomMs = random.nextInt(31536) * 1000000l * 30l;

		Date[] dateArray = new Date[9];
		for (int i = 0; i < 9; i++) {
			dateArray[i] = new Date(randomMs);
			randomTime=sdf.format(dateArray[i]);//将date对象转换成字符串
			System.out.println(randomTime);
		}
		//冒泡排序

	}

}
