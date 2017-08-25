package pers.oyxx.someDemo.MultiThreading;

//java���߳�ͬ��4
public class Concurrency4 {
	// ���� 6 : ʹ��hero������Ϊͬ������
	/*
	 * ��Ȼ������󶼿���������Ϊͬ�����󣬶����е��̷߳��ʵĶ���ͬһ��hero�������Ծ�ʹ��gareen����Ϊͬ������
	 * ��һ���ģ�����Hero��hurt������
	 * ���ϣ� synchronized (this) { } 
	 * ��ʾ���ڶ���Ϊͬ�����󣬼�Ҳ��gareenΪͬ������
	 */
	public static void main(String[] args) {
		 final Hero4 gareen = new Hero4();
	        gareen.name = "����";
	        gareen.hp = 10000;
	          
	        int n = 10000;
	  
	        Thread[] addThreads = new Thread[n];
	        Thread[] reduceThreads = new Thread[n];
	          
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                     
	                    //ʹ��gareen��Ϊsynchronized
	                    //synchronized (gareen) {//����recover����ǰ����synchronized���Σ����������߳�run�������治��ͬ��gareen������
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
	                    //ʹ��gareen��Ϊsynchronized
	                    //�ڷ���hurt����synchronized(this)
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
	          
	        System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ���� %.0f%n", n,n,gareen.hp);
	          
	}

}
