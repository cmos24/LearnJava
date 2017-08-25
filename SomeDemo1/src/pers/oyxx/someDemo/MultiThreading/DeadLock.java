package pers.oyxx.someDemo.MultiThreading;

//死锁
public class DeadLock {
	/*
	 * 3个同步对象a, b, c 3个线程 t1,t2,t3
	 * 
	 * 故意设计场景，使这3个线程彼此死锁
	 */
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					System.out.println("t1已经占用对象a");
					// 等待一秒等其他线程占用好对应的对象
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println("t1 试图占有b");
				synchronized (b) {
					System.out.println("t1占有b成功");
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (b) {
					System.out.println("t2已经占用对象b");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t2 试图占有c");
				synchronized (c) {
					System.out.println("t2占有c成功");
				}

			}
		};

		Thread t3 = new Thread() {
			public void run() {
				synchronized (c) {
					System.out.println("t3已经占用对象c");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t3 试图占有a");
				synchronized (a) {
					System.out.println("t3占有a成功");
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();

	}
}
