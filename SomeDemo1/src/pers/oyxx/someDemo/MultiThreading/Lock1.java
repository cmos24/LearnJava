package pers.oyxx.someDemo.MultiThreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Lock����
public class Lock1 {
	//���� 2 : ʹ��Lock����ʵ��ͬ��Ч��
	/*Lock��һ���ӿڣ�Ϊ��ʹ��һ��Lock������Ҫ�õ�
 
	Lock lock = new ReentrantLock();
	 
	
	�� synchronized (someObject) ���Ƶģ�lock()��������ʾ��ǰ�߳�ռ��lock����һ��ռ�ã������߳̾Ͳ���ռ���ˡ�
	�� synchronized ��ͬ���ǣ�һ��synchronized ��������ͻ��Զ��ͷŶ�someObject��ռ�á� lockȴ�������unlock���������ֶ��ͷţ�Ϊ�˱�֤�ͷŵ�ִ�У��������unlock() ����finally�н��С�
	
	*/
	public static String now(){
		return (new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date()));
	}
	public static void log(String msg){
		System.out.printf("%s %s %s %n",now(),Thread.currentThread().getName(),msg);
	}
	
	public static void main(String[] args){
		Lock lock=new ReentrantLock();
		
		Thread t1=new Thread(){
			public void run(){
				try {
				log("�߳�����");
                log("��ͼռ�ж���lock");
                
                lock.lock();
                
                log("ռ�ж���lock");
                log("����5���ҵ����");               
				Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					log("�ͷŶ���lock");
					lock.unlock();
				}
			}
		};
		t1.setName("t1");
		t1.start();
		try {
            //����t1��2��
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
		Thread t2=new Thread(){
			public void run(){
				try {
					log("�߳�����");
                    log("��ͼռ�ж���lock");
                    
                    lock.lock();
                    
                    log("ռ�ж���lock");
                    log("����5���ҵ�����");
                    Thread.sleep(5000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					log("�ͷŶ���lock");
                    lock.unlock();
				}
				log("�߳̽���");
			}
		};
		t2.setName("t2");
		t2.start();
				
		
		
		
	}
}
