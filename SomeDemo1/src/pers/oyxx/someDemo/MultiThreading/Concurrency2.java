package pers.oyxx.someDemo.MultiThreading;

import java.text.SimpleDateFormat;
import java.util.Date;

//���� 2 : ����ͬ�����������ԭ��
public class Concurrency2 {
	/*
	 * 1. ���������߳��Ƚ��룬�õ���hp��10000 2. ������������ 3. ���������������ʱ�򣬻�û�����ü��޸�hp��ֵ�������߳����� 4.
	 * �����̵߳õ���hp��ֵҲ��10000 5. �����߳̽��м������� 6. �����߳�����������õ�ֵ10001���������ֵ����hp 7.
	 * �����߳�Ҳ����������õ�ֵ9999���������ֵ����hp hp������ֵ����9999
	 * ��Ȼ�����������̸߳���������һ�Σ�������������ԭֵ10000������ȴ�õ���һ��9999 ���ʱ���ֵ9999��һ�������ֵ����ҵ�����ֽ���������
	 */

	// ���� 3 : ���˼·
	/*
	 * ������˼·�ǣ� �������̷߳���hp�ڼ䣬�����̲߳����Է���hp 1. �����̻߳�ȡ��hp��ֵ������������ 2.
	 * �������ڼ䣬�����߳���ͼ����ȡhp��ֵ�����ǲ������� 3. �����߳�������������ɹ��޸�hp��ֵΪ10001 4.
	 * �����̣߳��������߳�����󣬲��ܷ���hp��ֵ����10001 5. �����߳����㣬���õ��µ�ֵ10000
	 */

	// ���� 4 : synchronized ͬ���������
	/*
	 * �����������֮ǰ������� synchronized�ؼ��ֵ����� ���´��룺
	 * 
	 * Object someObject =new Object(); synchronized (someObject){
	 * //�˴��Ĵ���ֻ��ռ����someObject��ſ���ִ�� }
	 * 
	 * 
	 * synchronized��ʾ��ǰ�̣߳���ռ ���� someObject ��ǰ�̶߳�ռ
	 * �˶���someObject������������߳���ͼռ�ж���someObject���ͻ�ȴ���ֱ����ǰ�߳��ͷŶ�someObject��ռ�á�
	 * someObject �ֽ�ͬ���������еĶ��󣬶�������Ϊͬ������ Ϊ�˴ﵽͬ����Ч��������ʹ��ͬһ��ͬ������
	 * 
	 * �ͷ�ͬ������ķ�ʽ�� synchronized ����Ȼ�������������쳣�׳�
	 */
	public static void main(String[] args) {
		final Object someObject = new Object();
		Thread t1 = new Thread() {
			public void run() {
				try {
					System.out.println(now() + "�߳�t1�Ѿ�����");
					System.out.println(now() + this.getName() + "��ͼռ�ж���someObject");// this.getName()�õ���ǰ�߳���������������
					synchronized (someObject) {
						System.out.println(now() + this.getName() + " ռ�ж���someObject");
						Thread.sleep(5000);
						System.out.println(now() + this.getName() + " �ͷŶ���someObject");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.setName("�߳�1");// ���߳��趨���֣���Ӧ����t1.getName()�õ�������
		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				try {
					System.out.println(now() + "�߳�t2�Ѿ�����");
					System.out.println(now() + this.getName() + "��ͼռ�ж���someObject");
					synchronized (someObject) {
						System.out.println(now() + this.getName() + " ռ�ж���someObject");
						Thread.sleep(5000);
						System.out.println(now() + this.getName() + " �ͷŶ���someObject");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t2.setName("�߳�2");
		t2.start();

	}
	
	//���ص�ǰʱ���ַ���
	public static String now() {
		return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
	}
}
