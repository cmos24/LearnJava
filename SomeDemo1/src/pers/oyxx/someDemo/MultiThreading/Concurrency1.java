package pers.oyxx.someDemo.MultiThreading;

/*多线程的同步问题指的是多个线程同时修改一个数据的时候，可能导致的问题 

多线程的问题，又叫Concurrency 问题*/
//同步
public class Concurrency1 {
	/*
	 * 假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击 就是有多个线程在减少盖伦的hp 同时又有多个线程在回复盖伦的hp
	 * 假设线程的数量是一样的，并且每次改变的值都是1，那么所有线程结束后，盖伦应该还是10000滴血。 但是。。。
	 * 
	 * 注意： 不是每一次运行都会看到错误的数据产生，多运行几次，或者增加运行的次数
	 */
	public static void main(String[] args) {
		final Hero2 gareen = new Hero2();
		gareen.name = "盖伦";
		gareen.hp = 10000;
		System.out.printf("盖伦初始血量为%.0f%n", gareen.hp);

		// 多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题

		// 假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击

		// 用JAVA代码来表示，就是有多个线程在减少盖伦的hp
		// 同时又有多个线程在回复盖伦的hp

		// n个线程增加盖伦的hp
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
			//放进一个线程数组用于批量操作
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
		
		//等待所有减少线程结束
		for(Thread eachThread:reduceThreads){
			try {
				eachThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//等待所有增加线程结束
		for(Thread eachThread:addThreads){
			try {
				eachThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//代码执行到这里，所有增加和减少线程都结束了
        
        //增加和减少线程的数量是一样的，每次都增加，减少1.
        //那么所有线程都结束后，盖伦的hp应该还是初始值
           
        //但是事实上观察到的是：
		
		System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f",n,n,gareen.hp);

	}

}
