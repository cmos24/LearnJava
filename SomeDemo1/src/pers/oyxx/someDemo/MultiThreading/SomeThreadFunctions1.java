package pers.oyxx.someDemo.MultiThreading;

//�������̷߳���1
public class SomeThreadFunctions1 {

	public static void main(String[] args) {
		// ʾ�� 1 : ��ǰ�߳���ͣ
		/*
		 * Thread.sleep(1000); ��ʾ��ǰ�߳���ͣ1000���� �������̲߳���Ӱ�� Thread.sleep(1000);
		 * ���׳�InterruptedException �ж��쳣����Ϊ��ǰ�߳�sleep��ʱ���п��ܱ�ֹͣ����ʱ�ͻ��׳�
		 * InterruptedException
		 */

		Thread t1 = new Thread() {
			public void run() {
				int seconds = 0;
				int flag = 2;// ֻ����ʮ�뻹��
				while (flag > 0) {
					flag--;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("�Ѿ�����LOL %d ��%n", seconds++);
				}
			}
		};
		t1.start();

		// ʾ�� 2 : ���뵽��ǰ�߳���
		/*
		 * ���Ƚ���һ�����̵߳ĸ��� ���н��̣����ٻ���һ���̼߳����̣߳���main������ʼִ�У��ͻ���һ�������������̴߳��ڡ�
		 * ��44��ִ��t.join�������������߳��м�����̡߳� ���̻߳�ȴ����߳̽�����ϣ� �Ż��������С�
		 */
		final Hero gareen = new Hero();
		gareen.name = "����";
		gareen.hp = 616;
		gareen.damage = 50;

		final Hero teemo = new Hero();
		teemo.name = "��Ī";
		teemo.hp = 300;
		teemo.damage = 30;

		final Hero bh = new Hero();
		bh.name = "�ͽ�����";
		bh.hp = 500;
		bh.damage = 65;

		final Hero leesin = new Hero();
		leesin.name = "äɮ";
		leesin.hp = 455;
		leesin.damage = 80;

		Thread t2 = new Thread() {
			public void run() {
				while (!teemo.isDead()) {
					gareen.attackHero(teemo);
				}
			}
		};
		t2.start();

		// ����ִ�е����һֱ��main�߳�������
		try {
			// t1�̼߳��뵽main�߳�������ֻ��t2�߳����н������Ż����������
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread t3 = new Thread() {
			public void run() {
				while (!leesin.isDead()) {
					bh.attackHero(leesin);
				}
			}
		};
		// ��۲쵽���װ���Ī�ɵ�֮��t3�̲߳�����
		t3.start();

		
		

	}

}
