package pers.oyxx.someDemo.MultiThreading;

/*����һ���龰��ÿ������ִ�е�ʱ�䶼��1��
�տ�ʼ�Ǽ��1�������̳߳����������

Ȼ����ʱ��Խ��Խ�̣�ִ��������̻߳�û�����ü��������µ����������ˡ�
�ͻ�۲쵽�̳߳���������̱߳�������ִ����Щ����*/
// ���� 3 : �����Զ����̳߳�
public class TestMyThread1 {
	public static void main(String[] args){
		MyThreadsPool pool=new MyThreadsPool();
		int sleep=1000;
		while(true){
			pool.add(new Runnable(){//ÿ������ִ��1��
				@Override
				public void run(){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			try {//ÿ�μ���������ļ��������ֱ�����0.1��
				Thread.sleep(sleep);
				sleep=(sleep<=100?100:sleep-100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
