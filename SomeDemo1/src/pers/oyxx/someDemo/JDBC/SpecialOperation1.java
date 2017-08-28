package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//一些特殊操作
public class SpecialOperation1 {

	public static void main(String[] args) {
	/* 步骤 1 : 获取自增长id
	在Statement通过execute或者executeUpdate执行完插入语句后，MySQL会为新插入的数据分配一个自增长id，(前提是这个表的id设置为了自增长,在Mysql创建表的时候，AUTO_INCREMENT就表示自增长)
	 
	CREATE TABLE hero (
	  id int(11) AUTO_INCREMENT,
	  ...
	}
	 
	
	但是无论是execute还是executeUpdate都不会返回这个自增长id是多少。需要通过Statement的getGeneratedKeys获取该id
	注： 第20行的代码，后面加了个Statement.RETURN_GENERATED_KEYS参数，以确保会返回自增长ID。 通常情况下不需要加这个，有的时候需要加，所以先加上，保险一些
	 
	PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String sql="insert into hero values(null,?,?,?)";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8", "root", "123456");
				PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			)
		{
			//ps.setInt(0, 66);
			ps.setString(1, "亚索");
			ps.setFloat(2, 616.0f);
			ps.setInt(3,200);
			ps.execute();
			
			// 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next()){
				int id=rs.getInt(1);
				System.out.println(id);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
