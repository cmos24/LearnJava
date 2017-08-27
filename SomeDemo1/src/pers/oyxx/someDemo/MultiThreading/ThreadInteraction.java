package pers.oyxx.someDemo.MultiThreading;

//线程交互
public class ThreadInteraction {
	/*
	 * 线程之间有交互通知的需求，考虑如下情况： 有两个线程，处理同一个英雄。 一个加血，一个减血。
	 * 
	 * 减血的线程，发现血量=1，就停止减血，直到加血的线程为英雄加了血，才可以继续减血
	 */
	public static void main(String[] args) {
		// 步骤 1 : 不好的解决方式
		/*
		 * 故意设计减血线程频率更高，盖伦的血量迟早会到达1 减血线程中使用while循环判断是否是1，如果是1就不停的循环,直到加血线程回复了血量
		 * 这是不好的解决方式，因为会大量占用CPU,拖慢性能
		 */
		// 步骤 2 : 使用wait和notify进行线程交互
		/*
		 * 在Hero类中：hurt()减血方法：当hp=1的时候，执行this.wait(). this.wait()表示
		 * 让占有this的线程等待，并临时释放占有
		 * 进入hurt方法的线程必然是减血线程，this.wait()会让减血线程临时释放对this的占有。
		 * 这样加血线程，就有机会进入recover()加血方法了。
		 * 
		 * 
		 * recover() 加血方法：增加了血量，执行this.notify(); this.notify()
		 * 表示通知那些等待在this的线程，可以苏醒过来了。 等待在this的线程，恰恰就是减血线程。 一旦recover()结束，
		 * 加血线程释放了this，减血线程，就可以重新占有this，并执行后面的减血工作。
		 */
		final Hero5 gareen = new Hero5();
		gareen.name = "盖伦";
		gareen.hp = 616;

		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					// 无需循环判断
					// while(gareen.hp==1){
					// continue;
					// }
					gareen.hurt();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		
		Thread t2=new Thread(){
			public void run(){
				while(true){
					gareen.recover();
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();

/*		步骤 3 : 关于wait、notify和notifyAll  提问
		留意wait()和notify() 这两个方法是什么对象上的？

		 
		public synchronized void hurt() {
		  。。。
		  this.wait();
		  。。。
		}
		 

		 
		public synchronized void recover() {
		   。。。
		   this.notify();
		}
		 


		这里需要强调的是，wait方法和notify方法，并不是Thread线程上的方法，它们是Object上的方法。 

		因为所有的Object都可以被用来作为同步对象，所以准确的讲，wait和notify是同步对象上的方法。

		wait()的意思是： 让占用了这个同步对象的线程，临时释放当前的占用，并且等待。 所以调用wait是有前提条件的，一定是在synchronized块里，否则就会出错。

		notify() 的意思是，通知一个等待在这个同步对象上的线程，你可以苏醒过来了，有机会重新占用当前对象了。

		notifyAll() 的意思是，通知所有的等待在这个同步对象上的线程，你们可以苏醒过来了，有机会重新占用当前对象了。*/
		
	}
}
