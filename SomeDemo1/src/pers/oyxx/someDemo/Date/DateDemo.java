package pers.oyxx.someDemo.Date;

//ע�⣺��java.util.Date;
//���� java.sql.Date�������Ǹ����ݿ���ʵ�ʱ��ʹ�õ�
import java.util.Date;
import java.util.Random;

/*���е��������ͣ������������������������������ַ����������Ҫ�����ֵ���ʽ���ֳ�����

��������Ҳ�����⣬���仰˵��һ�����ڣ�����2020��10��1�գ��ڼ���������һ�����������档

��ô�������һ�����֣�������. ��������֣��ʹ���Java�е�ʱ��ԭ�㣬���Ӧ��������1970��1��1�� 8��0��0�� �� (Ϊʲô��8�㣬��Ϊ�й���̫ƽ��ʱ����UTC-8���պú͸�������ʱ���8��Сʱ)

Ϊʲô��Ӧ1970���أ� ��Ϊ1969�귢���˵�һ�� UNIX �汾��AT&T���ۺϿ��ǣ���ʱ�Ͱ�1970�굱����ʱ��ԭ�㡣

���е����ڣ�������Ϊ���0��Ϊ��׼��ÿ��һ���룬��+1��*/

public class DateDemo {
	public static void main(String[] args) {
		// ��ǰʱ��

		Date d1 = new Date();
		System.out.println("��ǰʱ��:");
		System.out.println(d1);
		System.out.println();

		// getTime() �õ�һ��long�͵����� // ����������� 1970.1.1 08:00:00:000��ÿ����һ���룬����1
		System.out.println("��ǰʱ��getTime()���ص�ֵ�ǣ�" + d1.getTime()); //
		// ͨ��System.currentTimeMillis()��ȡ��ǰ���ڵĺ�����
		System.out.println("System.currentTimeMillis() \t����ֵ: " + System.currentTimeMillis());
		System.out.println();

		// ��1970��1��1�� ����8��0��0�� ��ʼ�����ĺ����� 
		Date d2 = new Date(5000);
		System.out.println("��1970��1��1�� ����8��0��0�� ��ʼ������5���ʱ��");
		System.out.println(d2);

		Date zero = new Date(0);
		System.out.println("��0��Ϊ���췽�����õ���������:" + zero);

		// ���������������һ����1995.1.1 00:00:00 �� 1995.12.31 23:59:59 ֮����������
		// ÿ����31536000000����
		Random random = new Random();
		// *1000000l����ġ�l��һ��Ҫ���ϣ���������ó��Ľ����1000000����൱������int��ˣ��������int������Ϊ�������ĳ��ȱ�int���ͳ������Ի��Զ���ȥһЩ����
		long randomMs = random.nextInt(31536) * 1000000l + 31536000000l * 25l;
		Date ranDate = new Date(randomMs);
		System.out.println(ranDate);
	}
}
