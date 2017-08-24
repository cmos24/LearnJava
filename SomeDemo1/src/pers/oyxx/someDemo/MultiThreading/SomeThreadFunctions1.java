package pers.oyxx.someDemo.MultiThreading;

//常见的线程方法1
public class SomeThreadFunctions1 {

	public static void main(String[] args) {
		// 示例 1 : 当前线程暂停
		/*
		 * Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响 Thread.sleep(1000);
		 * 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，这时就会抛出
		 * InterruptedException
		 */

		Thread t1 = new Thread() {
			public void run() {
				int seconds = 0;
				int flag = 2;// 只能玩十秒还行
				while (flag > 0) {
					flag--;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("已经玩了LOL %d 秒%n", seconds++);
				}
			}
		};
		t1.start();

		// 示例 2 : 加入到当前线程中
		/*
		 * 首先解释一下主线程的概念 所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
		 * 在44行执行t.join，即表明在主线程中加入该线程。 主线程会等待该线程结束完毕， 才会往下运行。
		 */
		final Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 616;
		gareen.damage = 50;

		final Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 300;
		teemo.damage = 30;

		final Hero bh = new Hero();
		bh.name = "赏金猎人";
		bh.hp = 500;
		bh.damage = 65;

		final Hero leesin = new Hero();
		leesin.name = "盲僧";
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

		// 代码执行到这里，一直是main线程在运行
		try {
			// t1线程加入到main线程中来，只有t2线程运行结束，才会继续往下走
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
		// 会观察到盖伦把提莫干掉之后t3线程才运行
		t3.start();

		
		

	}

}
