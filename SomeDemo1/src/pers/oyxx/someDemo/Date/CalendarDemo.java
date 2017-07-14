package pers.oyxx.someDemo.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		// 1.Calendar��Date����ת��

		// �õ���ģʽ�����������
		Calendar c1 = Calendar.getInstance();
		// ͨ���������������ڶ���
		Date d1 = c1.getTime();
		Date d2 = new Date(0);
		c1.setTime(d2);// ������������������� : 1970.1.1 08:00:00
		String str = sdf.format(c1.getTime());
		System.out.println("���ú���������ڣ�" + str);

		// 2.������
		Calendar c2 = Calendar.getInstance();
		Date now = c2.getTime();
		// ��ǰ����
		System.out.println("��ǰ���ڣ�\t" + format(c2.getTime()));

		// �¸��µĽ���
		c2.setTime(now);// ��ԭʱ�䵽��ǰ
		c2.add(Calendar.MONTH, 1);
		System.out.println("�¸��µĽ���:\t" + format(c2.getTime()));

		// ȥ��Ľ���
		c2.setTime(now);
		c2.add(Calendar.YEAR, -1);
		System.out.println("ȥ��Ľ���:\t" + format(c2.getTime()));

		// �ϸ��µĵ�����
		c2.setTime(now);
		c2.add(Calendar.MONTH, -1);
		// c2.set(Calendar.MONTH, 6);//����ֱ������Ҳ����
		c2.set(Calendar.DATE, 3);
		System.out.println("�ϸ��µĵ�����:\t" + format(c2.getTime()));

		// �ϸ��µĵ���������
		c2.setTime(now);
		c2.add(Calendar.MONTH, 0);// ����¿�ʼ
		//c2.set(Calendar.MONTH, -1);//����д���������ɣ����ϸ��µ���������:	2016-11-27 14:23:48����Ϊʲô��
		c2.set(Calendar.DATE, -3);// ������3�죬���ϸ��µĵ���������
		System.out.println("�ϸ��µ���������:\t"+format(c2.getTime()));

	}

	// ������ת����ָ����ʽ���ַ���
	public static String format(Date date) {
		return sdf.format(date);
	}
}
