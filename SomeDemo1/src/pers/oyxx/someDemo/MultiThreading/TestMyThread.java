package pers.oyxx.someDemo.MultiThreading;

//�����Զ����̳߳�
public class TestMyThread {

	public static void main(String[] args) {
		MyThreadsPool threadPool=new MyThreadsPool();
		
		for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("ִ������");
                    //��������Ǵ�ӡһ�仰
                    //�����Ƿ����ļ�
                    //������������
                }
            };
           
            threadPool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		
		
		
	}
}
