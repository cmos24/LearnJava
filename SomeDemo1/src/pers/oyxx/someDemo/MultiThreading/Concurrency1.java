package pers.oyxx.someDemo.MultiThreading;

/*���̵߳�ͬ������ָ���Ƕ���߳�ͬʱ�޸�һ�����ݵ�ʱ�򣬿��ܵ��µ����� 

���̵߳����⣬�ֽ�Concurrency ����*/
//ͬ��
public class Concurrency1 {
	/*
	 * ���������10000��Ѫ�������ڻ����ͬʱ�ֱ��Է����Ӣ�۹��� �����ж���߳��ڼ��ٸ��׵�hp ͬʱ���ж���߳��ڻظ����׵�hp
	 * �����̵߳�������һ���ģ�����ÿ�θı��ֵ����1����ô�����߳̽����󣬸���Ӧ�û���10000��Ѫ�� ���ǡ�����
	 * 
	 * ע�⣺ ����ÿһ�����ж��ῴ����������ݲ����������м��Σ������������еĴ���
	 */
	public static void main(String[] args) {
		final Hero2 gareen = new Hero2();
		gareen.name = "����";
		gareen.hp = 10000;
		System.out.printf("���׳�ʼѪ��Ϊ%.0f%n", gareen.hp);

		// ���߳�ͬ������ָ���Ƕ���߳�ͬʱ�޸�һ�����ݵ�ʱ�򣬵��µ�����

		// ���������10000��Ѫ�������ڻ����ͬʱ�ֱ��Է����Ӣ�۹���

		// ��JAVA��������ʾ�������ж���߳��ڼ��ٸ��׵�hp
		// ͬʱ���ж���߳��ڻظ����׵�hp

		// n���߳����Ӹ��׵�hp
		int n = 10000;

		Thread[] addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];

		for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					gareen.hurt();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			};
			t.start();
			//�Ž�һ���߳�����������������
			reduceThreads[i] = t;
		}

		for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					gareen.recover();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i]=t;
		}
		
		//�ȴ����м����߳̽���
		for(Thread eachThread:reduceThreads){
			try {
				eachThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�ȴ����������߳̽���
		for(Thread eachThread:addThreads){
			try {
				eachThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//����ִ�е�����������Ӻͼ����̶߳�������
        
        //���Ӻͼ����̵߳�������һ���ģ�ÿ�ζ����ӣ�����1.
        //��ô�����̶߳������󣬸��׵�hpӦ�û��ǳ�ʼֵ
           
        //������ʵ�Ϲ۲쵽���ǣ�
		
		System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ������� %.0f",n,n,gareen.hp);

	}

}
