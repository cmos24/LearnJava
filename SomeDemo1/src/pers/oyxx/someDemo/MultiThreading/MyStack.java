package pers.oyxx.someDemo.MultiThreading;

import java.util.LinkedList;

//线程安全的栈
public class MyStack<T> {
	private LinkedList<T> values=new LinkedList<T>();
	
	//入栈
	public synchronized void push(T t){
		while(values.size()>200){//当栈里的数据时200的时候，访问push的线程就会等待
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
	//查看-不涉及数据修改不用设计成线程安全
	public T peek(){
		return values.getLast();
	}
	//弹出
	public synchronized T pull(){
		while(values.size()<=0){//当栈里的数据是0的时候，访问pull的线程就会等待
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
