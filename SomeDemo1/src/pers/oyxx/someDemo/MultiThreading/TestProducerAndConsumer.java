package pers.oyxx.someDemo.MultiThreading;

//生产者消费者问题测试类
public class TestProducerAndConsumer {
	public static void main(String[] args) {
		MyStack<Character> mystack=new MyStack<Character>();
		new ProducerThread(mystack,"Producer1").start();
		new ProducerThread(mystack,"Producer2").start();
		new ConsumerThread(mystack,"Consumer1").start();
		new ConsumerThread(mystack,"Consumer2").start();
		new ConsumerThread(mystack,"Consumer3").start();
	}
}
