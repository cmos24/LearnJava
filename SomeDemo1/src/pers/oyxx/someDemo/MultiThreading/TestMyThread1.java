package pers.oyxx.someDemo.MultiThreading;

/*创造一个情景，每个任务执行的时间都是1秒
刚开始是间隔1秒钟向线程池中添加任务

然后间隔时间越来越短，执行任务的线程还没有来得及结束，新的任务又来了。
就会观察到线程池里的其他线程被唤醒来执行这些任务*/
// 步骤 3 : 测试自定义线程池
public class TestMyThread1 {
	public static void main(String[] args){
		MyThreadsPool pool=new MyThreadsPool();
		int sleep=1000;
		while(true){
			pool.add(new Runnable(){//每个任务执行1秒
				@Override
				public void run(){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			try {//每次加入新任务的间隔都会变短直至变成0.1秒
				Thread.sleep(sleep);
				sleep=(sleep<=100?100:sleep-100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
