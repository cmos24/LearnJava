package pers.oyxx.someDemo.InputOutput;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SysteminAndScanner {

	public static void main(String[] args) {
		// ���� 1 : System.in
		/*try (InputStream is = System.in) {
			while (true) {
				// ����a,Ȼ���ûس����Կ���
				// 97 13 10
				// 97��a��ASCII��
				// 13 10�ֱ��Ӧ�س�����
				int i = is.read();
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		// ���� 2 : Scanner��ȡ�ַ���
		/*
		 * ʹ��System.in.read��Ȼ���Զ�ȡ���ݣ����Ǻܲ����� ʹ��Scanner�Ϳ������ж�ȡ��
		 */
		/*Scanner s1 = new Scanner(System.in);
		while (true) {
			String line = s1.nextLine();
			System.out.println(line);
		}*/
		// ���� 3 : Scanner�ӿ���̨��ȡ����
		Scanner s2=new Scanner(System.in);
		int a=s2.nextInt();
		System.out.println("��һ��������"+a);
		int b=s2.nextInt();
		System.out.println("�ڶ���������"+b);
	}

}
