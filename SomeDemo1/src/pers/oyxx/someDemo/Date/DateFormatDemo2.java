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
		String randomTime=null;
		Random random = new Random();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		long randomMs = random.nextInt(31536) * 1000000l * 30l;

		Date[] dateArray = new Date[9];
		for (int i = 0; i < 9; i++) {
			dateArray[i] = new Date(randomMs);
			randomTime=sdf.format(dateArray[i]);//��date����ת�����ַ���
			System.out.println(randomTime);
		}
		//ð������

	}

}
