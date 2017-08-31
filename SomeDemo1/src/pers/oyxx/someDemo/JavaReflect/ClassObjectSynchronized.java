package pers.oyxx.someDemo.JavaReflect;

/*练习-在静态方法上加synchronized，同步对象是什么？
在之前有一个练习，练习-在类前面加修饰符synchronized

在对象方法前，加上修饰符synchronized ，同步对象是当前实例。
那么如果在类方法前，加上修饰符 synchronized，同步对象是什么呢？

编写代码进行验证*/
public class ClassObjectSynchronized {
	/*当synchronized修饰静态方法的时候， 同步对象就是这个类的类对象。

	如代码中的例子，当第一个线程进入method1的时候，需要占用TestReflection.class才能执行。
	
	第二个线程进入method2的时候，进去不，只有等第一个线程释放了对TestReflection.class的占用，才能够执行。 反推过来，第二个线程也是需要占用TestReflection.class。 那么TestReflection.class就是method2的同步对象。
	
	换句话说，静态方法被修饰为synchronized的时候，其同步对象就是当前类的类对象。*/
	
	
	
	public static void method1(){
		synchronized(ClassObjectSynchronized.class){
			//对于method1而言，同步对象是ClassObjectSynchronized.class，只有占用TestReflection.class才可以执行到这里
			System.out.println(Thread.currentThread().getName()+"进入当前方法");
			try {
				System.out.println("运行5秒");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized void method2(){
		//对于用synchonized修饰的method2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，占用了TestReflection.class之后
		// 就无法进入method2，推断出，method2的同步对象，就是TestReflection.class
		System.out.println(Thread.currentThread().getName()+"进入当前方法");
		try {
			System.out.println("运行5秒");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//用2个线程分别调用ClassObjectSynchonized的两个方法测试
		Thread t1=new Thread(){
			public void run(){
				System.out.println("t1尝试调用method1");
				ClassObjectSynchronized.method1();
				System.out.println("method1调用结束");
			}
		};
		t1.setName("t1");
		t1.start();
		
		Thread t2=new Thread(){
			public void run(){
				System.out.println("t2尝试调用method2");
				ClassObjectSynchronized.method2();
				System.out.println("method2调用结束");
			}
		};
		t2.setName("t2");
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("从输出结果可以看到method1被调用的时候ClassObjectSynchronized是同步状态的，t2在method1调用结束前不能调用method2");
	}

}
