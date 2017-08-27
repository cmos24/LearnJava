package pers.oyxx.someDemo.MultiThreading;

//测试自定义线程池
public class TestMyThread {

	public static void main(String[] args) {
		MyThreadsPool threadPool=new MyThreadsPool();
		
		for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };
           
            threadPool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		
		
		
	}
}
