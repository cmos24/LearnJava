package pers.oyxx.someDemo.Other;

import java.util.Scanner;

public class OperationSymbol {//��������ϰ
	
	private Scanner scanner=new Scanner(System.in);	
	
	//�ӿ���̨���������������
	public void add(){
		System.out.print("��һ����=");
		int num1=scanner.nextInt();
		System.out.print("�ڶ�����=");
		int num2=scanner.nextInt();
		System.out.println("������ӵ���"+(num1+num2));
	}
	
	//��Ԫ�����
	public void TernaryOperator(){
		System.out.print("�������ڼ���");
		int num = scanner.nextInt();
		if(num>7|num<1){
			System.out.println("ʱ����Ч����������");
			TernaryOperator();
		}else{
		String week = num>5 ? "��ĩ����":"������";
		System.out.println(week);
		}
	}
	
}
