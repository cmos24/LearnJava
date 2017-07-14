package pers.oyxx.someDemo.ExceptionsHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Handling {
	public static void main(String[] args) {
		File f = new File("d:/LOL.exe");
		try {
			System.out.println("尝试打开文件：" + f);
			new FileOutputStream(f);
			System.out.println("打开成功");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2017-7-14");
		} catch (FileNotFoundException e1) {// 也可以用异常的父类Exception来进行catch
			System.out.println("文件" + f + "打开失败");
			e1.printStackTrace();
		} catch (ParseException e2) {//2
			System.out.println("字符串转日期失败");
			e2.printStackTrace();
		}
	}
}
