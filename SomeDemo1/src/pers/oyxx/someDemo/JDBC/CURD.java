package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*CRUD����������ݿ����������ɾ�Ĳ� 
C ����(Create) 
R ��ȡ��ѯ(Retrieve) 
U ����(Update) 
D ɾ��(Delete) 

��JDBC�����ӣ�ɾ�����޸ĵĲ����������ƣ�ֻ�Ǵ��ݲ�ͬ��SQL�������ˡ� 

��ѯ��ΪҪ�������ݣ����Ժ�����Ĳ�һ�����ڲ�ѯ�½ڽ��⡣*/
public class CURD {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF8", "root", "123456");
				Statement s=c.createStatement();
			)
		{
			System.out.println("���ݿ���������"+c);
			//���� 1 : ����
			String sql1="insert into hero values(null,"+"'����'"+","+525.0f+","+180+")";
			s.execute(sql1);
			
			//���� 2 : ɾ��
			String sql2="delete from hero where name='����'";
			s.execute(sql2);
			
			//���� 3 : �޸�
			String sql3="update hero set name='name 5' where id=2";
			s.execute(sql3);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
	}

}
