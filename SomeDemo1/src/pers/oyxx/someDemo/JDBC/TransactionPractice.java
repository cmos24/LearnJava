package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionPractice {

	public static void main(String[] args) {
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "123456");
                Statement st4Query = c.createStatement();
                Statement st4Delete = c.createStatement();
                Scanner s = new Scanner(System.in);) {
 
            //把自动提交关闭
            c.setAutoCommit(false);
            //查出前10条
            ResultSet rs =st4Query.executeQuery("select id from Hero order by id asc limit 0,10 ");
            while(rs.next()){
                int id = rs.getInt(1);
                System.out.println("试图删除id="+id+" 的数据");
                st4Delete.execute("delete from Hero where id = " +id);
            }
             
            //是否删除这10条
            while(true){
                System.out.println("是否要删除数据(Y/N)");
                 
                String str = s.next();
                if ("Y".equals(str)) {
                    //如果输入的是Y，则提交删除操作
                    c.commit();
                    System.out.println("提交删除");
                    break;
                } else if ("N".equals(str)) {
                    System.out.println("放弃删除");
                    break;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
