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
		String randomTime = null;
		Random random = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long randomMs;

		Date[] dateArray = new Date[9];
		for (int i = 0; i < 9; i++) {
			randomMs = random.nextInt(31536) * 1000000l + random.nextInt(3600000) - 3600000;
			// System.out.println(randomMs);
			dateArray[i] = new Date(randomMs);
			randomTime = sdf.format(dateArray[i]);// 将date对象转换成字符串
			System.out.println("时间数组中第" + (i + 1) + "个元素：" + randomTime);
		}
		// 冒泡排序
		boolean c;
		Date temp;
		for (int i = 0; i < dateArray.length; i++) {
			for (int j = 0; j < dateArray.length - i - 1; j++) {
				// System.out.println("第1个数="+dateArray[j].getTime() % 86400000l);
				// System.out.println("第2个数="+dateArray[j+1].getTime() % 86400000l);
				c = dateArray[j].getTime() % 86400000l > dateArray[j + 1].getTime() % 86400000l;
				if (c) {
					temp = dateArray[j];
					dateArray[j] = dateArray[j + 1];
					dateArray[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < dateArray.length; i++) {
			randomTime = sdf.format(dateArray[i]);
			System.out.println("排序后第" + (i + 1) + "个元素：" + randomTime);
		} // 最后得出的结果有点问题

	}// 主函数尾部

}
