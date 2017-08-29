package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//事务
public class Transaction {
	/*步骤 1 : 不使用事务的情况
	没有事务的前提下
	假设业务操作是：加血，减血各做一次
	结束后，英雄的血量不变
	而减血的SQL
	不小心写错写成了 updata(而非update)
	那么最后结果是血量增加了，而非期望的不变*/
	public static void main(String[] args) {
		/*步骤 2 : 使用事务
		在事务中的多个操作，要么都成功，要么都失败
		通过 c.setAutoCommit(false);关闭自动提交
		使用 c.commit();进行手动提交
		在22行-35行之间的数据库操作，就处于同一个事务当中，要么都成功，要么都失败
		所以，虽然第一条SQL语句是可以执行的，但是第二条SQL语句有错误，其结果就是两条SQL语句都没有被提交。 除非两条SQL语句都是正确的。*/
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "123456");
            Statement s = c.createStatement();) {
        	// 有事务的前提下
            // 在事务中的多个操作，要么都成功，要么都失败
        	
        	c.setAutoCommit(false);//关闭自动提交
        	
        	//加血的SQL
        	String sql1="update hero set hp=hp+1 where id=317";
        	s.execute(sql1);
        	
        	//减血的SQL
        	//不小心写错成 updata
        	String sql2="update hero set hp=hp-1 where id=317";
        	s.execute(sql2);
        	
        	//手动提交
        	c.commit();
        	
        } catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
