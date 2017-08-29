package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*���ȳ�ʼ��һ����3�����ӵ����ݿ����ӳ�
Ȼ�󴴽�100���̣߳�ÿ���̶߳�������ӳ��н������ӣ������ڽ���֮�󣬹黹���ӡ� �õ�����֮��ִ��һ����ʱ1���SQL��䡣

���г��򣬾Ϳ��Թ۲쵽��ͼ��ʾ��Ч��*/
//�����Զ�������ݿ����ӳ�
public class TestConnectionPool {

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPool(3);

		for (int i = 0; i < 100; i++) {
			Thread t = new Thread() {
				public void run() {
					Connection c = cp.getConnection();
					System.out.println(this.getName()+ ":\t ��ȡ��һ�����ӣ�����ʼ����"  );
					try (Statement s = c.createStatement();) {
						//ģ��ʱ�ģ�������ݿ�ӣѣ����
						Thread.sleep(1000);
						s.execute("select * from hero");

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//�߳�������֮�����������ӷŻس�����
					cp.returnConnection(c);
				}
			};
			t.setName("Thread"+i);
			t.start();
		}
	}

}
