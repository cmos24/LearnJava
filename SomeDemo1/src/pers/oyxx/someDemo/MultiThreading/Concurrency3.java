package pers.oyxx.someDemo.MultiThreading;

//���߳�ͬ��3
public class Concurrency3 {
	// ���� 5 : ʹ��synchronized ���ͬ������
	/*
	 * ������Ҫ�޸�hp�ĵط�����Ҫ������ռ��someObject�Ļ����ϡ� ������ someObject��ͬһʱ�䣬ֻ�ܱ�һ���߳�ռ�С�
	 * ��ӵأ�����ͬһʱ�䣬hpֻ�ܱ�һ���߳��޸ġ�
	 */
	public static void main(String[] args) {
		final Object someObject = new Object();
		final Hero2 gareen = new Hero2();
		gareen.name = "����";
		gareen.hp = 10000;

		int n = 10000;

		Thread[] addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];

		for (int i = 0; i < n; i++) {
			Thread t1 = new Thread() {
				public void run() {
					// �κ��߳�Ҫ�޸�hpֵ��Ҫ��ռ��someObject,���������ݵĲ���
					synchronized (someObject) {
						gareen.hurt();
					}
				}
			};
			t1.start();
			reduceThreads[i] = t1;
		}
		for (int i = 0; i < n; i++) {
			Thread t2 = new Thread() {
				public void run() {
					synchronized (someObject) {
						gareen.recover();
					}
				}
			};
			t2.start();
			addThreads[i] = t2;
		}
		
		for(Thread each:reduceThreads){
			try {
				each.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(Thread each:addThreads){
			try {
				each.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		System.out.printf("%d�������̺߳�%d�������߳̽�����%n%s��Hp���ڣ�%.0f",n,n,gareen.name,gareen.hp);
	
	
	}

}
