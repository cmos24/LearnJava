package pers.oyxx.someDemo.Other;

import java.util.Scanner;

//�����Ϣ��ʽ
public class OutputFormat {
	public void outputFormatTest() {
		int year = 2020;
		String str1="mdzz";
		str1="abc";
		// ֱ�Ӵ�ӡ����
		System.out.format("%d%n", year);// %n����ȫƽ̨����
		// �ܳ�����8��Ĭ���Ҷ���
		System.out.format("%8d%n", year);
		// �ܳ�����8�������
		System.out.format("%-8d%n", year);
		// �ܳ�����8,������0
		System.out.format("%08d%n", year);
		// ǧλ�ָ���
		System.out.format("%,8d%n", year * 10000);
		// С����λ��
		System.out.format("%.2f%n", Math.PI);
		
	}
	
	//�������
	public void fillWords(){
		String str="%s���%s�����ˣ����˵��ϰ�%s�Ժ��ζģ�Ƿ����%s���ڣ���������С��������!����û�а취������%s�ֹ���!ԭ�۶���һ�ٶࡢ���ٶࡢ���ٶ��%s������ȫ��ֻ����ʮ�飬ͳͳֻҪ��ʮ��!%s���˵����㲻����!����������������˴���꣬�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ!";
		Scanner scanner=new Scanner(System.in);
		System.out.println("������");
		String place=scanner.nextLine();
		System.out.println("ʲô����");
		String factory=scanner.nextLine();
		System.out.println("�ϰ����֣�");
		String bossname=scanner.nextLine();
		System.out.println("Ƿ�˶����ڣ�");
		String howmany=scanner.nextLine();
		System.out.println("��ʲô�ֹ��ʣ�");
		String what=scanner.nextLine();
		System.out.printf(str,place,factory,bossname,howmany,what,what,bossname);
		
	}
}
