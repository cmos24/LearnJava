package pers.oyxx.someDemo.MultiThreading;

//步骤 7 : 答案-多线程交互
public class ThreadInteractionPractice1 {
	/*
	 * 在目前的状态下，会导致英雄的血量变为负数。 这是因为减血线程调用hurt()
	 * 方法结束时，调用notify，有可能会唤醒另一个减血线程，这就导致不停的减血。
	 * 
	 * 解决办法是： 减血线程被唤醒后，要再次查看当前血量，如果当前血量<=1,那么就继续等待
	 * 
	 * //把if改为while，被唤醒后，会重复查看hp的值，只有hp大于1，才会往下执行
	 * 
	 * //把if改为while，被唤醒后，会重复查看hp的值，只有hp大于1，才会往下执行 //if(hp <= 1) { while (hp <=1)
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
		gareen.name = "盖伦";
		gareen.hp = 616;
		
		for(int i=0;i<2;i++){//2个加血线程
			new Thread(new RecoverThread(gareen)).start();
		}
		for(int i=0;i<5;i++){
			new Thread(new HurtThread(gareen)).start();
		}
	}

}
