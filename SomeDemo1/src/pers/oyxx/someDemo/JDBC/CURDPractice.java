package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*���һ������
 
public static void execute(String sql) 

�������ܵĲ�����SQL��䣬���������ӣ�ɾ���������޸ģ����������������ÿ�δ���ͬ��SQL�����Ϊ����*/
//��ϰ-�� ɾ ��
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
