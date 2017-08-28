package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//练习-一次性 插入100条数据
public class InsertPractice {
	//借助循环，和上面学习到的JDBC的知识，向数据库中插入100条数据，并在mysql-front中观察查询结果
	public static void main(String[] args) {
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
			for(int i=0;i<100;i++){
				String sql="insert into hero values(null,"+"'英雄"+i+"'"+","+313.0f+","+50+");";
				s.execute(sql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("循环插入数据结束");
	}

}
