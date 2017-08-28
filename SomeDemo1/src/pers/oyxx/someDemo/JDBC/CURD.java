package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*CRUD是最常见的数据库操作，即增删改查 
C 增加(Create) 
R 读取查询(Retrieve) 
U 更新(Update) 
D 删除(Delete) 

在JDBC中增加，删除，修改的操作都很类似，只是传递不同的SQL语句就行了。 

查询因为要返回数据，所以和上面的不一样，在查询章节讲解。*/
public class CURD {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF8", "root", "123456");
				Statement s=c.createStatement();
			)
		{
			System.out.println("数据库已连接上"+c);
			//步骤 1 : 增加
			String sql1="insert into hero values(null,"+"'亚索'"+","+525.0f+","+180+")";
			s.execute(sql1);
			
			//步骤 2 : 删除
			String sql2="delete from hero where name='亚索'";
			s.execute(sql2);
			
			//步骤 3 : 修改
			String sql3="update hero set name='name 5' where id=2";
			s.execute(sql3);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
	}

}
