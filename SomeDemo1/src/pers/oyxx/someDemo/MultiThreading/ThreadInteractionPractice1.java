package pers.oyxx.someDemo.MultiThreading;

//���� 7 : ��-���߳̽���
public class ThreadInteractionPractice1 {
	/*
	 * ��Ŀǰ��״̬�£��ᵼ��Ӣ�۵�Ѫ����Ϊ������ ������Ϊ��Ѫ�̵߳���hurt()
	 * ��������ʱ������notify���п��ܻỽ����һ����Ѫ�̣߳���͵��²�ͣ�ļ�Ѫ��
	 * 
	 * ����취�ǣ� ��Ѫ�̱߳����Ѻ�Ҫ�ٴβ鿴��ǰѪ���������ǰѪ��<=1,��ô�ͼ����ȴ�
	 * 
	 * //��if��Ϊwhile�������Ѻ󣬻��ظ��鿴hp��ֵ��ֻ��hp����1���Ż�����ִ��
	 * 
	 * //��if��Ϊwhile�������Ѻ󣬻��ظ��鿴hp��ֵ��ֻ��hp����1���Ż�����ִ�� //if(hp <= 1) { while (hp <=1)
	 * { try { this.wait(); } catch (InterruptedException e) {
	 * e.printStackTrace(); } }
	 */
	static class RecoverThread implements Runnable {
		private Hero6 hero;

		public RecoverThread(Hero6 hero) {
			this.hero = hero;
		}

		public void run() {
			while (true) {
				hero.recover();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class HurtThread implements Runnable {
		private Hero6 hero;

		public HurtThread(Hero6 hero) {
			this.hero = hero;
		}

		public void run() {
			while (true) {
				hero.hurt();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		final Hero6 gareen = new Hero6();
		gareen.name = "����";
		gareen.hp = 616;
		
		for(int i=0;i<2;i++){//2����Ѫ�߳�
			new Thread(new RecoverThread(gareen)).start();
		}
		for(int i=0;i<5;i++){
			new Thread(new HurtThread(gareen)).start();
		}
	}

}
