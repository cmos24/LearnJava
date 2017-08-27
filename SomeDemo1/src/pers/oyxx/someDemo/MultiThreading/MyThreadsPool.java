package pers.oyxx.someDemo.MultiThreading;

import java.util.LinkedList;

/*ÿһ���̵߳������ͽ������ǱȽ�����ʱ���ռ����Դ�ġ� 

�����ϵͳ���õ��˺ܶ���̣߳������������ͽ��������ᵼ��ϵͳ�����ܱ俨����Ӧ������ 

Ϊ�˽��������⣬�����̳߳��������˼�롣 

�̳߳ص�ģʽ����������������ģʽ�����ѵĶ�����һ��һ�����ܹ����е�����*/
public class MyThreadsPool {
//	���� 1 : �̳߳����˼·
/*	�̳߳ص�˼·��������������ģ���Ǻܽӽ��ġ�
	1. ׼��һ����������
	2. һ��������10�� �������߳�
	3. �տ�ʼ���������ǿյģ������̶߳�wait�����档
	4. ֱ��һ���ⲿ�߳��������������������һ�������񡱣��ͻ���һ���������̱߳�����notify
	5. ����������߳�ȡ�������񡱣�����ִ���������ִ����Ϻ󣬼����ȴ���һ������ĵ�����
	6. �����ʱ���ڣ��н϶��������룬��ô�ͻ��ж���̱߳����ѣ�ȥִ����Щ����

	�����������У�������Ҫ�����µ��̣߳�����ѭ��ʹ����Щ�Ѿ����ڵ��߳�*/
	
/*	���� 2 : ����һ���Զ����̳߳� 
	����һ���Զ�����̳߳أ���Ȼ�������ƺͽ�׳�������Ѿ�����˵���̳߳صĹ���ԭ��

	�����ĸ�����̳߳�������񣬻ῴ���ж����߳���ִ����Щ���� 
	�߳�7ִ�����������ֻص��������һ����������ʱ���߳�7����ִ���µ�����*/
	
	//�̳߳ش�С
	int threadPoolSize;
	//��������
	LinkedList<Runnable> tasks=new LinkedList<Runnable>(); 
	
	// ��ͼ����������߳�
	public MyThreadsPool(){
		threadPoolSize=10;//�̳߳س�ʼ����ʱ���趨��С
		
		synchronized(tasks){//�����Ĺ����������̲߳��ܵ����������߳�
			for(int i=0;i<threadPoolSize;i++){
				new TaskConsumeThread("�����������߳� " + i).start();
			}
		}
	}
	
	public void add(Runnable r){
		synchronized(tasks){
			tasks.add(r);
			//���ѵȴ��������������߳�
			tasks.notifyAll();
		}
	}
	
	class TaskConsumeThread extends Thread{
		public TaskConsumeThread(String name){
			super(name);
		}
		
		Runnable task;
		
		public void run(){
			System.out.println("������ " + this.getName());
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
					// �������������߳̿��Լ����������
					tasks.notifyAll();
				}
				System.out.println(this.getName() + " ��ȡ�����񣬲�ִ��");
				task.run();
			}
		}
	}
	
	
}
