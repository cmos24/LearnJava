package pers.oyxx.someDemo.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

//ԭ�Ӳ���
public class AtomicOperation {
//	���� 1 : ԭ���Բ�������
	/*��ν��ԭ���Բ����������жϵĲ��������縳ֵ����
	 
	int i = 5;
	 

	ԭ���Բ����������̰߳�ȫ�� 
	���� i++ �����Ϊ����ʵ������3��ԭ���Բ�����ɵġ�
	���� 1. ȡ i ��ֵ
	���� 2. i + 1
	���� 3. ���µ�ֵ����i
	���������裬ÿһ������һ��ԭ�Ӳ��������Ǻ���һ�𣬾Ͳ���ԭ�Ӳ������Ͳ����̰߳�ȫ�ġ� 
	���仰˵��һ���߳��ڲ���1 ȡi ��ֵ�����󣬻�û�����ü����в���2����һ���߳�Ҳ����ȡ i��ֵ�ˡ�
	��Ҳ�Ƿ���ͬ�����������ԭ�� �е�ԭ��
	i++ ��i--�� i = i+1 ��Щ���Ƿ�ԭ���Բ�����
	ֻ��int i = 1,�����ֵ������ԭ���Եġ�*/
	public static void main(String[] args) {
//		���� 2 : AtomicInteger
		/*JDK6 �Ժ���������һ����java.util.concurrent.atomic�������и���ԭ���࣬����AtomicInteger��
		��AtomicInteger�ṩ�˸����������Լ��ȷ�������Щ��������ԭ���Եġ� ���仰˵���������� incrementAndGet ���̰߳�ȫ�ģ�ͬһ��ʱ�䣬ֻ��һ���߳̿��Ե������������*/
		AtomicInteger atomicI=new AtomicInteger();
		int ii=atomicI.decrementAndGet();//�Լ�
		int jj=atomicI.incrementAndGet();//����
		int kk=atomicI.addAndGet(3);
		System.out.println(ii+" "+jj+" "+kk);
		
		
//		���� 3 : ͬ������
		/*�ֱ�ʹ�û��������ķ�ԭ���Ե�++������� ԭ���Ե�AtomicInteger����� incrementAndGet �����ж��̲߳��ԡ�*/
		int number =100000;
		Thread[] ts1=new Thread[number];
		for(int i=0;i<number;i++){
			Thread t=new Thread(){
				public void run(){
					value++;
				}
			};
			t.start();
			ts1[i]=t;
		}
		
		//�ȴ���Щ�߳̽���
		for(Thread t:ts1){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%d���߳̽���value++��value��ֵ��ɣ�%d%n",number,value);
		
		Thread[] t2=new Thread[number];
		for(int i=0;i<number;i++){
			Thread t=new Thread(){
				public void run(){
					atomicValue.incrementAndGet();
				}
			};
			t.start();
			t2[i]=t;
		}
		for(Thread t:t2){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		 System.out.printf("%d���߳̽���atomicValue.incrementAndGet();��atomicValue��ֵ���:%d%n", number,atomicValue.intValue());
		
	}

	private static int value=0;
	private static AtomicInteger atomicValue=new AtomicInteger();
//	private static AtomicInteger atomicValue=new AtomicInteger();//atomicValue��ֵ����new AtomicInteger(n)�е�n
	
	
}
