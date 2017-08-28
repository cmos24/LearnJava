package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//预编译
public class JDBCPreparedStatement {
	/*
	 * 步骤 1 : 使用PreparedStatement 
 	 * 和 Statement一样，PreparedStatement也是用来执行sql语句的
	 * 与创建Statement不同的是，需要根据sql语句创建PreparedStatement
	 * 除此之外，还能能够通过设置参数，指定相应的值，而不是Statement那样使用字符串拼接
	 * 
	 * 注： 这是JAVA里唯二的基1的地方，另一个是查询语句中的ResultSet也是基1的。
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="insert into hero values(null,?,?,?)";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF8","root","123456");
				//根据sql语句创建PreparedStatement
				PreparedStatement ps=c.prepareStatement(sql);
			) 
		{
			//设置参数
			ps.setString(1, "提莫");
			ps.setFloat(2, 313.0f);
			ps.setInt(3, 50);
			//执行
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
