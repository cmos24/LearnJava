package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//execute��executeUpdate������
public class ExecuteAndExecuteUpdate {
	/*
	 * ���� 1 : ��ͬ�� 
	 * execute��executeUpdate����ͬ�㣺������ִ�����ӣ�ɾ�����޸�
	 */
	/*
	 * ���� 2 : ��ͬ��
	 * ��ͬ1�� execute����ִ�в�ѯ��� Ȼ��ͨ��getResultSet���ѽ����ȡ����
	 * 	executeUpdate����ִ�в�ѯ��� 
	 * ��ͬ2:
	 *	execute����boolean���ͣ�true��ʾִ�е��ǲ�ѯ��䣬false��ʾִ�е���insert,delete,update�ȵ�
	 * 	executeUpdate���ص���int����ʾ�ж����������ܵ���Ӱ��
	 */
	public static void main(String[] args) {
		list(5,5);
	}
	
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
			String sql="select * from hero limit "+start+","+count;
			boolean isQuery=s.execute(sql);
			if(isQuery){
				// ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
				ResultSet rs=s.getResultSet();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					float hp=rs.getFloat(3);
					int damage=rs.getInt(4);
					System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
