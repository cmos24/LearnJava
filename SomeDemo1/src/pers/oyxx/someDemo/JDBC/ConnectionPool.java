package pers.oyxx.someDemo.JDBC;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

/*���� 1 : ���ݿ����ӳ�ԭ��-��ͳ��ʽ
���ж���̣߳�ÿ���̶߳���Ҫ�������ݿ�ִ��SQL���Ļ�����ôÿ���̶߳��ᴴ��һ�����ӣ�������ʹ����Ϻ󣬹ر����ӡ�

�������Ӻ͹ر����ӵĹ���Ҳ�ǱȽ�����ʱ��ģ������̲߳�����ʱ��ϵͳ�ͻ��úܿ��١�

ͬʱ��һ�����ݿ�ͬʱ֧�ֵ���������Ҳ�����޵ģ�������̲߳������ܴ���ô���ݿ����ӵ������ͻᱻ���Ĺ⣬�����̷߳�������ݿ����Ӿͻ�ʧ�ܡ�*/

/*���� 2 : ���ݿ����ӳ�ԭ��-ʹ�ó�
�봫ͳ��ʽ��ͬ�����ӳ���ʹ��֮ǰ���ͻᴴ����һ�����������ӡ�
������κ��߳���Ҫʹ�����ӣ���ô�ʹ����ӳ�������ã��������Լ����´���. 
ʹ����Ϻ��ְ�������ӹ黹�����ӳع���һ�λ��������߳�ʹ�á�
�����������̲߳�����������ӳ�������ӱ����ù��ˣ���ô�����߳̾ͻ���ʱ�ȴ���ֱ�������ӱ��黹�������ټ���ʹ�á�
�������̣���Щ���Ӷ����ᱻ�رգ����ǲ��ϵı�ѭ��ʹ�ã��Ӷ���Լ�������͹ر����ӵ�ʱ�䡣*/

//�Լ�ʵ��һ�����ݿ����ӳ�
public class ConnectionPool {
	/* ���� 3 : ConnectionPool���췽���ͳ�ʼ��
	1. ConnectionPool() ���췽��Լ����������ӳ�һ���ж�������
	
	2. ��init() ��ʼ�������У�������size�����ӡ� ע�⣬���ﲻ��ʹ��try-with-resource�����Զ��ر����ӵķ�ʽ����Ϊ����ǡǡ��Ҫ���ֲ��ر�״̬��������ѭ��ʹ��
	
	3. getConnection�� �ж��Ƿ�Ϊ�գ�����ǿյľ�wait�ȴ�������ͽ���һ�����ӳ�ȥ
	
	4. returnConnection�� ��ʹ����Ϻ󣬹黹������ӵ����ӳأ������ڹ黹��Ϻ󣬵���notifyAll��֪ͨ��Щ�ȴ����̣߳����µ����ӿ��Խ����ˡ�
	
	ע�����ӳ�����õ��˶��̵߳�wait��notifyAll����Щ���ݿ����ڶ��߳̽����½ڲ���ѧϰ��*/
	
	List<Connection> cs=new ArrayList<Connection>();

	int size;

	/**
	 * �̳߳ش�С
	 */
	public ConnectionPool(int size){
		this.size=size;
		init();
	}

	//��ʼ���̳߳�
	public void init(){
		//����ǡǡ����ʹ��try-with-resource�ķ�ʽ����Ϊ��Щ���Ӷ���Ҫ��"��"�ģ���Ҫ���Զ��ر���
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for(int i=0;i<size;i++){
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
							"root","123456");
				cs.add(c);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public synchronized Connection getConnection(){
		while(cs.isEmpty()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		Connection c =cs.remove(0);
		return c;
	}

	public synchronized void returnConnection(Connection c){
		cs.add(c);
		this.notifyAll();
	}

	
}
