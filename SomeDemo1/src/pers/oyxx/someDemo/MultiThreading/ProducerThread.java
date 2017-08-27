package pers.oyxx.someDemo.MultiThreading;

//�������߳���
public class ProducerThread extends Thread{
	private MyStack<Character> stack;
	
	public ProducerThread(MyStack<Character> stack,String name){
		super(name);//��������߳�һ������
		this.stack=stack;
	}
	
	//���������д�ַ�
	public char getRandomChar(){
		return (char)(Math.random()*('Z'-'A'+1)+'A');
	}
	
	public void run(){
		while(true){
			char c=getRandomChar();
			
			System.out.println(this.getName()+"ѹ��:"+c);
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
