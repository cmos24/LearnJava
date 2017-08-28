package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQL语句判断账号密码是否正确
public class CheckPassword {
	/*
	 * 1. 创建一个用户表，有字段name,password 2. 插入一条数据
	 * 
	 * insert into user values(null,'dashen','thisispassword');
	 * 
	 * 
	 * 3. SQL语句判断账号密码是否正确
	 * 
	 * 判断账号密码的正确方式是根据账号和密码到表中去找数据，如果有数据，就表明密码正确了，如果没数据，就表明密码错误。
	 * 
	 * 不恰当的方式 是把uers表的数据全部查到内存中，挨个进行比较。 如果users表里有100万条数据呢？ 内存都不够用的。
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF8",
				"root", "123456"); Statement s = c.createStatement();) {
			String name = "dashen";
			// 正确密码是：thisispassword
			String password = "thisispassword";

			String sql = "select * from user where name='" + name + "'and password='" + password + "'";
			// 执行查询语句
			ResultSet rs = s.executeQuery(sql);
			if (rs.next())
				System.out.println("密码正确");
			else
				System.out.println("密码错误");

			/*
			 * 步骤 3 : 获取总数 提问 执行的sql语句为
			 * 
			 * select count(*) from hero
			 * 
			 * 
			 * 然后通过ResultSet获取出来
			 * 
			 */
			String sql1 = "select count(*) from hero";
			ResultSet rs1 = s.executeQuery(sql1);
			int total = 0;
			while (rs1.next()) {
				total = rs1.getInt(1);
			}
			System.out.println("表hero中总共有：" + total + "条数据");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
