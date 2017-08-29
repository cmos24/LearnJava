package pers.oyxx.someDemo.JDBC;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

/*步骤 1 : 数据库连接池原理-传统方式
当有多个线程，每个线程都需要连接数据库执行SQL语句的话，那么每个线程都会创建一个连接，并且在使用完毕后，关闭连接。

创建连接和关闭连接的过程也是比较消耗时间的，当多线程并发的时候，系统就会变得很卡顿。

同时，一个数据库同时支持的连接总数也是有限的，如果多线程并发量很大，那么数据库连接的总数就会被消耗光，后续线程发起的数据库连接就会失败。*/

/*步骤 2 : 数据库连接池原理-使用池
与传统方式不同，连接池在使用之前，就会创建好一定数量的连接。
如果有任何线程需要使用连接，那么就从连接池里面借用，而不是自己重新创建. 
使用完毕后，又把这个连接归还给连接池供下一次或者其他线程使用。
倘若发生多线程并发情况，连接池里的连接被借用光了，那么其他线程就会临时等待，直到有连接被归还回来，再继续使用。
整个过程，这些连接都不会被关闭，而是不断的被循环使用，从而节约了启动和关闭连接的时间。*/

//自己实现一个数据库连接池
public class ConnectionPool {
	/* 步骤 3 : ConnectionPool构造方法和初始化
	1. ConnectionPool() 构造方法约定了这个连接池一共有多少连接
	
	2. 在init() 初始化方法中，创建了size条连接。 注意，这里不能使用try-with-resource这种自动关闭连接的方式，因为连接恰恰需要保持不关闭状态，供后续循环使用
	
	3. getConnection， 判断是否为空，如果是空的就wait等待，否则就借用一条连接出去
	
	4. returnConnection， 在使用完毕后，归还这个连接到连接池，并且在归还完毕后，调用notifyAll，通知那些等待的线程，有新的连接可以借用了。
	
	注：连接池设计用到了多线程的wait和notifyAll，这些内容可以在多线程交互章节查阅学习。*/
	
	List<Connection> cs=new ArrayList<Connection>();

	int size;

	/**
	 * 线程池大小
	 */
	public ConnectionPool(int size){
		this.size=size;
		init();
	}

	//初始化线程池
	public void init(){
		//这里恰恰不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
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
