package pers.oyxx.someDemo.MultiThreading;

//java多线程同步4
public class Concurrency4 {
	// 步骤 6 : 使用hero对象作为同步对象
	/*
	 * 既然任意对象都可以用来作为同步对象，而所有的线程访问的都是同一个hero对象，索性就使用gareen来作为同步对象
	 * 进一步的，对于Hero的hurt方法，
	 * 加上： synchronized (this) { } 
	 * 表示当期对象为同步对象，即也是gareen为同步对象
	 */
	public static void main(String[] args) {
		 final Hero4 gareen = new Hero4();
	        gareen.name = "盖伦";
	        gareen.hp = 10000;
	          
	        int n = 10000;
	  
	        Thread[] addThreads = new Thread[n];
	        Thread[] reduceThreads = new Thread[n];
	          
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                     
	                    //使用gareen作为synchronized
	                    //synchronized (gareen) {//这里recover方法前加了synchronized修饰，所以在这线程run方法里面不用同步gareen对象了
	                        gareen.recover();
	                    //}
	                     
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            };
	            t.start();
	            addThreads[i] = t;
	              
	        }
	          
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                    //使用gareen作为synchronized
	                    //在方法hurt中有synchronized(this)
	                    gareen.hurt();
	                     
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            };
	            t.start();
	            reduceThreads[i] = t;
	        }
	          
	        for (Thread t : addThreads) {
	            try {
	                t.join();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        for (Thread t : reduceThreads) {
	            try {
	                t.join();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	          
	        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n,n,gareen.hp);
	          
	}

}
