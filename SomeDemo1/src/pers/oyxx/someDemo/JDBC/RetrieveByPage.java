package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*���һ�����������з�ҳ��ѯ
 
public static void list(int start, int count)
 

start ��ʾ��ʼҳ����count��ʾһҳ��ʾ������
list(0,5) ��ʾ��һҳ��һ����ʾ5������
list(10,5) ��ʾ����ҳ��һ����ʾ5������
*/
//��ҳ��ѯ
public class RetrieveByPage {
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
			String sql="select *from hero limit "+start+","+count;//ע��limit����Ŀո���ȱ�٣���������sql����﷨����ȷ
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				float hp=rs.getFloat(3);
				int damage=rs.getInt(4);				
				System.out.printf("%d\t%s\t%f\t%d%n",id,name,hp,damage);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		list(0,10);
	}

}
