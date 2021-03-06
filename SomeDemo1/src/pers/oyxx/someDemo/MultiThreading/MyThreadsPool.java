package pers.oyxx.someDemo.MultiThreading;

import java.util.LinkedList;

/*每一个线程的启动和结束都是比较消耗时间和占用资源的。 

如果在系统中用到了很多的线程，大量的启动和结束动作会导致系统的性能变卡，响应变慢。 

为了解决这个问题，引入线程池这种设计思想。 

线程池的模式很像生产者消费者模式，消费的对象是一个一个的能够运行的任务*/
public class MyThreadsPool {
//	步骤 1 : 线程池设计思路
/*	线程池的思路和生产者消费者模型是很接近的。
	1. 准备一个任务容器
	2. 一次性启动10个 消费者线程
	3. 刚开始任务容器是空的，所以线程都wait在上面。
	4. 直到一个外部线程往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify
	5. 这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。
	6. 如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。

	在整个过程中，都不需要创建新的线程，而是循环使用这些已经存在的线程*/
	
/*	步骤 2 : 开发一个自定义线程池 
	这是一个自定义的线程池，虽然不够完善和健壮，但是已经足以说明线程池的工作原理

	缓慢的给这个线程池添加任务，会看到有多条线程来执行这些任务。 
	线程7执行完毕任务后，又回到池子里，下一次任务来的时候，线程7又来执行新的任务。*/
	
	//线程池大小
	int threadPoolSize;
	//任务容器
	LinkedList<Runnable> tasks=new LinkedList<Runnable>(); 
	
	// 试图消费任务的线程
	public MyThreadsPool(){
		threadPoolSize=10;//线程池初始化的时候设定大小
		
		synchronized(tasks){//启动的过程中其他线程不能调用消费者线程
			for(int i=0;i<threadPoolSize;i++){
				new TaskConsumeThread("任务消费者线程 " + i).start();
			}
		}
	}
	
	public void add(Runnable r){
		synchronized(tasks){
			tasks.add(r);
			//唤醒等待的任务消费者线程
			tasks.notifyAll();
		}
	}
	
	class TaskConsumeThread extends Thread{
		public TaskConsumeThread(String name){
			super(name);
		}
		
		Runnable task;
		
		public void run(){
			System.out.println("启动： " + this.getName());
			while(true){
				synchronized(tasks){
					while(tasks.isEmpty()){
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task=tasks.removeLast();
					// 允许添加任务的线程可以继续添加任务
					tasks.notifyAll();
				}
				System.out.println(this.getName() + " 获取到任务，并执行");
				task.run();
			}
		}
	}
	
	
}
