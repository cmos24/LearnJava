package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//��ϰ-һ���� ����100������
public class InsertPractice {
	//����ѭ����������ѧϰ����JDBC��֪ʶ�������ݿ��в���100�����ݣ�����mysql-front�й۲��ѯ���
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
				String sql="insert into hero values(null,"+"'Ӣ��"+i+"'"+","+313.0f+","+50+");";
				s.execute(sql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("ѭ���������ݽ���");
	}

}
