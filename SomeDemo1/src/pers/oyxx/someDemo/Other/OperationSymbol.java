package pers.oyxx.someDemo.Other;

import java.util.Scanner;

public class OperationSymbol {//操作符练习
	
	private Scanner scanner=new Scanner(System.in);	
	
	//从控制台输入两个整数相加
	public void add(){
		System.out.print("第一个数=");
		int num1=scanner.nextInt();
		System.out.print("第二个数=");
		int num2=scanner.nextInt();
		System.out.println("两数相加等于"+(num1+num2));
	}
	
	//三元运算符
	public void TernaryOperator(){
		System.out.print("今天星期几？");
		int num = scanner.nextInt();
		if(num>7|num<1){
			System.out.println("时间无效请重新输入");
			TernaryOperator();
		}else{
		String week = num>5 ? "周末假期":"工作日";
		System.out.println(week);
		}
	}
	
}
