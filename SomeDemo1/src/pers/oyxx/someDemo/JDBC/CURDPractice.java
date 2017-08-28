package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*设计一个方法
 
public static void execute(String sql) 

方法接受的参数是SQL语句，无论是增加，删除，还是修改，都调用这个方法，每次传不同的SQL语句作为参数*/
//练习-增 删 改
public class CURDPractice {

	public static void execute(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "123456"); Statement s = c.createStatement();) {
 
            s.execute(sql);
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		execute("delete from hero where id = 3");
	}

}
