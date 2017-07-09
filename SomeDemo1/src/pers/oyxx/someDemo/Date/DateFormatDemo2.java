package pers.oyxx.someDemo.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*׼��һ��������9����������
ʹ��1970��-2000��֮���������ڳ�ʼ��������
������Щ���ڵ�ʱ�������������
���� 1988-1-21 12:33:22 �ͻ����� 1978-4-21 19:07:23 ǰ�棬��Ϊ����ʱ���С����Ȼ���ڸ���*/

public class DateFormatDemo2 {

	public static void main(String[] args) {
		String randomTime = null;
		Random random = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long randomMs;

		Date[] dateArray = new Date[9];
		for (int i = 0; i < 9; i++) {
			randomMs = random.nextInt(31536) * 1000000l + random.nextInt(3600000) - 3600000;
			// System.out.println(randomMs);
			dateArray[i] = new Date(randomMs);
			randomTime = sdf.format(dateArray[i]);// ��date����ת�����ַ���
			System.out.println("ʱ�������е�" + (i + 1) + "��Ԫ�أ�" + randomTime);
		}
		// ð������
		boolean c;
		Date temp;
		for (int i = 0; i < dateArray.length; i++) {
			for (int j = 0; j < dateArray.length - i - 1; j++) {
				// System.out.println("��1����="+dateArray[j].getTime() % 86400000l);
				// System.out.println("��2����="+dateArray[j+1].getTime() % 86400000l);
				c = dateArray[j].getTime() % 86400000l > dateArray[j + 1].getTime() % 86400000l;
				if (c) {
					temp = dateArray[j];
					dateArray[j] = dateArray[j + 1];
					dateArray[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < dateArray.length; i++) {
			randomTime = sdf.format(dateArray[i]);
			System.out.println("������" + (i + 1) + "��Ԫ�أ�" + randomTime);
		} // ���ó��Ľ���е�����

	}// ������β��

}
