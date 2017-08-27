package pers.oyxx.someDemo.MultiThreading;

import java.util.LinkedList;

//�̰߳�ȫ��ջ
public class MyStack<T> {
	private LinkedList<T> values=new LinkedList<T>();
	
	//��ջ
	public synchronized void push(T t){
		while(values.size()>200){//��ջ�������ʱ200��ʱ�򣬷���push���߳̾ͻ�ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		values.addLast(t);
		this.notifyAll();
	}
	//�鿴-���漰�����޸Ĳ�����Ƴ��̰߳�ȫ
	public T peek(){
		return values.getLast();
	}
	//����
	public synchronized T pull(){
		while(values.size()<=0){//��ջ���������0��ʱ�򣬷���pull���߳̾ͻ�ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return values.removeLast();
		
	}
}
