package pers.oyxx.someDemo.InputOutput;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SysteminAndScanner {

	public static void main(String[] args) {
		// 步骤 1 : System.in
		/*try (InputStream is = System.in) {
			while (true) {
				// 敲入a,然后敲回车可以看到
				// 97 13 10
				// 97是a的ASCII码
				// 13 10分别对应回车换行
				int i = is.read();
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		// 步骤 2 : Scanner读取字符串
		/*
		 * 使用System.in.read虽然可以读取数据，但是很不方便 使用Scanner就可以逐行读取了
		 */
		/*Scanner s1 = new Scanner(System.in);
		while (true) {
			String line = s1.nextLine();
			System.out.println(line);
		}*/
		// 步骤 3 : Scanner从控制台读取整数
		Scanner s2=new Scanner(System.in);
		int a=s2.nextInt();
		System.out.println("第一个整数："+a);
		int b=s2.nextInt();
		System.out.println("第二个整数："+b);
	}

}
