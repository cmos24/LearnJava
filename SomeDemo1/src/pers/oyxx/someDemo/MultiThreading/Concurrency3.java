package pers.oyxx.someDemo.MultiThreading;

//多线程同步3
public class Concurrency3 {
	// 步骤 5 : 使用synchronized 解决同步问题
	/*
	 * 所有需要修改hp的地方，有要建立在占有someObject的基础上。 而对象 someObject在同一时间，只能被一个线程占有。
	 * 间接地，导致同一时间，hp只能被一个线程修改。
	 */
	public static void main(String[] args) {
		final Object someObject = new Object();
		final Hero2 gareen = new Hero2();
		gareen.name = "盖伦";
		gareen.hp = 10000;

		int n = 10000;

		Thread[] addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];

		for (int i = 0; i < n; i++) {
			Thread t1 = new Thread() {
				public void run() {
					// 任何线程要修改hp值都要先占用someObject,避免脏数据的产生
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
	
		System.out.printf("%d个增加线程和%d个减少线程结束后%n%s的Hp等于：%.0f",n,n,gareen.name,gareen.hp);
	
	
	}

}
