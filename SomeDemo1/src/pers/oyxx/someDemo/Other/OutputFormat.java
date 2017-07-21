package pers.oyxx.someDemo.Other;

import java.util.Scanner;

//输出信息格式
public class OutputFormat {
	public void outputFormatTest() {
		int year = 2020;
		String str1="mdzz";
		str1="abc";
		// 直接打印数字
		System.out.format("%d%n", year);// %n换行全平台适用
		// 总长度是8，默认右对齐
		System.out.format("%8d%n", year);
		// 总长度是8，左对齐
		System.out.format("%-8d%n", year);
		// 总长度是8,不够补0
		System.out.format("%08d%n", year);
		// 千位分隔符
		System.out.format("%,8d%n", year * 10000);
		// 小数点位数
		System.out.format("%.2f%n", Math.PI);
		
	}
	
	//词语填空
	public void fillWords(){
		String str="%s最大%s倒闭了，王八蛋老板%s吃喝嫖赌，欠下了%s个亿，带着他的小姨子跑了!我们没有办法，拿着%s抵工资!原价都是一百多、两百多、三百多的%s，现在全部只卖二十块，统统只要二十块!%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，你不发工资，你还我血汗钱，还我血汗钱!";
		Scanner scanner=new Scanner(System.in);
		System.out.println("地名：");
		String place=scanner.nextLine();
		System.out.println("什么厂：");
		String factory=scanner.nextLine();
		System.out.println("老板名字：");
		String bossname=scanner.nextLine();
		System.out.println("欠了多少亿：");
		String howmany=scanner.nextLine();
		System.out.println("拿什么抵工资：");
		String what=scanner.nextLine();
		System.out.printf(str,place,factory,bossname,howmany,what,what,bossname);
		
	}
}
