package pers.oyxx.someDemo.ExceptionsHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//�쳣����
public class Handling {
	public static void main(String[] args) {

		method1();

		File f = new File("d:/LOL.exe");
		try {
			System.out.println("���Դ��ļ���" + f);
			// new FileOutputStream(f);
			new FileInputStream(f);
			System.out.println("�򿪳ɹ�");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2017-7-14");
			// ���쳣��׽�취1
		} /*
			 * catch (FileNotFoundException e1) {// Ҳ�������쳣�ĸ���Exception������catch
			 * System.out.println("�ļ�" + f + "��ʧ��"); e1.printStackTrace(); }
			 * catch (ParseException e2) { System.out.println("�ַ���ת����ʧ��");
			 * e2.printStackTrace(); }
			 */
		// ���쳣��׽����2
		catch (FileNotFoundException | ParseException e) {
			if (e instanceof FileNotFoundException)
				System.out.println("d:/LOL.exe������");
			if (e instanceof ParseException)
				System.out.println("���ڸ�ʽ��������");

			e.printStackTrace();
		} finally {
			System.out.println("�����Ƿ�׽���쳣��ִ��");
		}
	}// ��������β

	/*
	 * ������������� ����������method1 method1����method2 method2�д��ļ�
	 * 
	 * method2����Ҫ�����쳣���� ����method2�����㴦�����ǰ�����쳣ͨ��throws�׳�ȥ ��ômethod1�ͻ�ӵ����쳣��
	 * ����취Ҳ�����֣�Ҫô��try catch�������ҪôҲ���׳�ȥ�� method1ѡ�񱾵�try catchס һ��try
	 * catchס�ˣ����൱�ڰ�����쳣�������ˣ��������ڵ���method1��ʱ�򣬾Ͳ���Ҫ�����쳣����
	 */

	/*
	 * throws��throw�������ؼ��ֽӽ����������岻һ�������������� 1. throws �����ڷ��������ϣ���throwͨ���������ڷ������ڡ�
	 * 2. throws ��ʾ�����쳣��һ�ֿ����ԣ�����һ���ᷢ����Щ�쳣��throw�����׳����쳣��ִ��throw��һ���׳���ĳ���쳣����
	 */
	private static void method1() {
		try {
			method2();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ���ʧ��");
			e.printStackTrace();
		}
	}

	private static void method2() throws FileNotFoundException {
		File f1 = new File("d:/LOL.exe");
		System.out.println("��ͼ�� d:/LOL.exe");
		new FileInputStream(f1);
		System.out.println("�ɹ���");
	}

}
