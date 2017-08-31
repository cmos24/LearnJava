package pers.oyxx.someDemo.JavaReflect;

/*��ϰ-�ھ�̬�����ϼ�synchronized��ͬ��������ʲô��
��֮ǰ��һ����ϰ����ϰ-����ǰ������η�synchronized

�ڶ��󷽷�ǰ���������η�synchronized ��ͬ�������ǵ�ǰʵ����
��ô������෽��ǰ���������η� synchronized��ͬ��������ʲô�أ�

��д���������֤*/
public class ClassObjectSynchronized {
	/*��synchronized���ξ�̬������ʱ�� ͬ��������������������

	������е����ӣ�����һ���߳̽���method1��ʱ����Ҫռ��TestReflection.class����ִ�С�
	
	�ڶ����߳̽���method2��ʱ�򣬽�ȥ����ֻ�еȵ�һ���߳��ͷ��˶�TestReflection.class��ռ�ã����ܹ�ִ�С� ���ƹ������ڶ����߳�Ҳ����Ҫռ��TestReflection.class�� ��ôTestReflection.class����method2��ͬ������
	
	���仰˵����̬����������Ϊsynchronized��ʱ����ͬ��������ǵ�ǰ��������*/
	
	
	
	public static void method1(){
		synchronized(ClassObjectSynchronized.class){
			//����method1���ԣ�ͬ��������ClassObjectSynchronized.class��ֻ��ռ��TestReflection.class�ſ���ִ�е�����
			System.out.println(Thread.currentThread().getName()+"���뵱ǰ����");
			try {
				System.out.println("����5��");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized void method2(){
		//������synchonized���ε�method2���ԣ���Ȼ�и�ͬ������ͨ���۲췢�֣���ĳ���߳���method1�У�ռ����TestReflection.class֮��
		// ���޷�����method2���ƶϳ���method2��ͬ�����󣬾���TestReflection.class
		System.out.println(Thread.currentThread().getName()+"���뵱ǰ����");
		try {
			System.out.println("����5��");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//��2���̷ֱ߳����ClassObjectSynchonized��������������
		Thread t1=new Thread(){
			public void run(){
				System.out.println("t1���Ե���method1");
				ClassObjectSynchronized.method1();
				System.out.println("method1���ý���");
			}
		};
		t1.setName("t1");
		t1.start();
		
		Thread t2=new Thread(){
			public void run(){
				System.out.println("t2���Ե���method2");
				ClassObjectSynchronized.method2();
				System.out.println("method2���ý���");
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
	
		System.out.println("�����������Կ���method1�����õ�ʱ��ClassObjectSynchronized��ͬ��״̬�ģ�t2��method1���ý���ǰ���ܵ���method2");
	}

}
