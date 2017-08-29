package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*首先初始化一个有3条连接的数据库连接池
然后创建100个线程，每个线程都会从连接池中借用连接，并且在借用之后，归还连接。 拿到连接之后，执行一个耗时1秒的SQL语句。

运行程序，就可以观察到如图所示的效果*/
//测试自定义的数据库连接池
public class TestConnectionPool {

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPool(3);

		for (int i = 0; i < 100; i++) {
			Thread t = new Thread() {
				public void run() {
					Connection c = cp.getConnection();
					System.out.println(this.getName()+ ":\t 获取了一个连接，并开始工作"  );
					try (Statement s = c.createStatement();) {
						//模拟时耗１秒的数据库ＳＱＬ语句
						Thread.sleep(1000);
						s.execute("select * from hero");

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//线程运行完之后把用完的连接放回池子里
					cp.returnConnection(c);
				}
			};
			t.setName("Thread"+i);
			t.start();
		}
	}

}
