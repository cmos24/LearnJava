package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//ʲô����
/*����ͬ�Ľ���֮�������ݽ�����ʱ��JAVA��ʹ������ʵ�֡� 
����Դ�������ļ��������������ݿ⣬���������������ĳ��� 
�����ȡ�ļ������ݵ������У�վ�ڳ���ĽǶ��������ͽ��������� 
�������� InputStream 
�������OutputStream*/
public class WhatIsStream {
	public static void main(String[] args) {
		try {
			File f1 = new File("h:/TextFile.txt");
			// ���������ļ���������
			FileInputStream fis = new FileInputStream(f1);
			// ͨ��������������Ϳ��԰����ݴ�Ӳ�̣���ȡ��Java������������Ҳ���Ƕ�ȡ���ڴ���

			File f2 = new File("h:/lol.txt");
			// ���������ļ��������
			FileOutputStream fos = new FileOutputStream(f2);
			// ͨ�������������Ϳ��԰����ݴ��ڴ棬�����Ӳ�̵��ļ���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
