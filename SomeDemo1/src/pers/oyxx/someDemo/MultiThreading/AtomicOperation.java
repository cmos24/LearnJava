package pers.oyxx.someDemo.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

//原子操作
public class AtomicOperation {
//	步骤 1 : 原子性操作概念
	/*所谓的原子性操作即不可中断的操作，比如赋值操作
	 
	int i = 5;
	 

	原子性操作本身是线程安全的 
	但是 i++ 这个行为，事实上是有3个原子性操作组成的。
	步骤 1. 取 i 的值
	步骤 2. i + 1
	步骤 3. 把新的值赋予i
	这三个步骤，每一步都是一个原子操作，但是合在一起，就不是原子操作。就不是线程安全的。 
	换句话说，一个线程在步骤1 取i 的值结束后，还没有来得及进行步骤2，另一个线程也可以取 i的值了。
	这也是分析同步问题产生的原因 中的原理。
	i++ ，i--， i = i+1 这些都是非原子性操作。
	只有int i = 1,这个赋值操作是原子性的。*/
	public static void main(String[] args) {
//		步骤 2 : AtomicInteger
		/*JDK6 以后，新增加了一个包java.util.concurrent.atomic，里面有各种原子类，比如AtomicInteger。
		而AtomicInteger提供了各种自增，自减等方法，这些方法都是原子性的。 换句话说，自增方法 incrementAndGet 是线程安全的，同一个时间，只有一个线程可以调用这个方法。*/
		AtomicInteger atomicI=new AtomicInteger();
		int ii=atomicI.decrementAndGet();//自减
		int jj=atomicI.incrementAndGet();//自增
		int kk=atomicI.addAndGet(3);
		System.out.println(ii+" "+jj+" "+kk);
		
		
//		步骤 3 : 同步测试
		/*分别使用基本变量的非原子性的++运算符和 原子性的AtomicInteger对象的 incrementAndGet 来进行多线程测试。*/
		int number =100000;
		Thread[] ts1=new Thread[number];
		for(int i=0;i<number;i++){
			Thread t=new Thread(){
				public void run(){
					value++;
				}
			};
			t.start();
			ts1[i]=t;
		}
		
		//等待这些线程结束
		for(Thread t:ts1){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%d个线程进行value++后，value的值变成：%d%n",number,value);
		
		Thread[] t2=new Thread[number];
		for(int i=0;i<number;i++){
			Thread t=new Thread(){
				public void run(){
					atomicValue.incrementAndGet();
				}
			};
			t.start();
			t2[i]=t;
		}
		for(Thread t:t2){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		 System.out.printf("%d个线程进行atomicValue.incrementAndGet();后，atomicValue的值变成:%d%n", number,atomicValue.intValue());
		
	}

	private static int value=0;
	private static AtomicInteger atomicValue=new AtomicInteger();
//	private static AtomicInteger atomicValue=new AtomicInteger();//atomicValue的值等于new AtomicInteger(n)中的n
	
	
}
