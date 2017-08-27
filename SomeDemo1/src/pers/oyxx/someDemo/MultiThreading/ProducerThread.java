package pers.oyxx.someDemo.MultiThreading;

//生产者线程类
public class ProducerThread extends Thread{
	private MyStack<Character> stack;
	
	public ProducerThread(MyStack<Character> stack,String name){
		super(name);//赋予这个线程一个名字
		this.stack=stack;
	}
	
	//生成随机大写字符
	public char getRandomChar(){
		return (char)(Math.random()*('Z'-'A'+1)+'A');
	}
	
	public void run(){
		while(true){
			char c=getRandomChar();
			
			System.out.println(this.getName()+"压入:"+c);
			stack.push(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
