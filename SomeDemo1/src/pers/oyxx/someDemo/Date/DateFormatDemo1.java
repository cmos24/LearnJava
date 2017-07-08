package pers.oyxx.someDemo.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/*y ������
M ������
d ������
H ����24���Ƶ�Сʱ
h ����12���Ƶ�Сʱ
m �������
s ������
S �������*/

public class DateFormatDemo1 {

	public static void main(String[] args) {
		// �ַ���ת����
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = "2016/1/5 12:12:12";
		try{
			Date dd=sdf.parse(str);
			System.out.printf("�ַ��� %s ͨ����ʽ  yyyy/MM/dd HH:mm:ss ת��Ϊ���ڶ���: %s",str,dd.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// ����ת�ַ���
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String str1 = sdf1.format(d);
		System.out.println();
		System.out.println("��ǰʱ��ͨ�� yyyy-MM-dd HH:mm:ss SSS ��ʽ��������: " + str1);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String str2 = sdf2.format(d);
		System.out.println("��ǰʱ��ͨ�� yyyy-MM-dd ��ʽ��������: " + str2);
	}

}
