package pers.oyxx.someDemo.MultiThreading;

//����
public class DeadLock {
	/*
	 * 3��ͬ������a, b, c 3���߳� t1,t2,t3
	 * 
	 * ������Ƴ�����ʹ��3���̱߳˴�����
	 */
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					System.out.println("t1�Ѿ�ռ�ö���a");
					// �ȴ�һ��������߳�ռ�úö�Ӧ�Ķ���
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println("t1 ��ͼռ��b");
				synchronized (b) {
					System.out.println("t1ռ��b�ɹ�");
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (b) {
					System.out.println("t2�Ѿ�ռ�ö���b");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t2 ��ͼռ��c");
				synchronized (c) {
					System.out.println("t2ռ��c�ɹ�");
				}

			}
		};

		Thread t3 = new Thread() {
			public void run() {
				synchronized (c) {
					System.out.println("t3�Ѿ�ռ�ö���c");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t3 ��ͼռ��a");
				synchronized (a) {
					System.out.println("t3ռ��a�ɹ�");
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();

	}
}
