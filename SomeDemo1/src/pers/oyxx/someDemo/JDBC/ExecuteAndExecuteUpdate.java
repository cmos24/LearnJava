package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//execute与executeUpdate的区别
public class ExecuteAndExecuteUpdate {
	/*
	 * 步骤 1 : 相同点 
	 * execute与executeUpdate的相同点：都可以执行增加，删除，修改
	 */
	/*
	 * 步骤 2 : 不同点
	 * 不同1： execute可以执行查询语句 然后通过getResultSet，把结果集取出来
	 * 	executeUpdate不能执行查询语句 
	 * 不同2:
	 *	execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
	 * 	executeUpdate返回的是int，表示有多少条数据受到了影响
	 */
	public static void main(String[] args) {
		list(5,5);
	}
	
	public static void list(int start,int count){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF8","root","123456");
				Statement s=c.createStatement();
			)
		{
			String sql="select * from hero limit "+start+","+count;
			boolean isQuery=s.execute(sql);
			if(isQuery){
				// 执行查询语句，并把结果集返回给ResultSet
				ResultSet rs=s.getResultSet();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					float hp=rs.getFloat(3);
					int damage=rs.getInt(4);
					System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
