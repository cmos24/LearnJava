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
			System.out.println("���Դ��ļ���" + f);
			new FileOutputStream(f);
			System.out.println("�򿪳ɹ�");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2017-7-14");
		} catch (FileNotFoundException e1) {// Ҳ�������쳣�ĸ���Exception������catch
			System.out.println("�ļ�" + f + "��ʧ��");
			e1.printStackTrace();
		} catch (ParseException e2) {//2
			System.out.println("�ַ���ת����ʧ��");
			e2.printStackTrace();
		}
	}
}
