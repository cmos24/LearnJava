package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Ԥ����
public class JDBCPreparedStatement {
	/*
	 * ���� 1 : ʹ��PreparedStatement 
 	 * �� Statementһ����PreparedStatementҲ������ִ��sql����
	 * �봴��Statement��ͬ���ǣ���Ҫ����sql��䴴��PreparedStatement
	 * ����֮�⣬�����ܹ�ͨ�����ò�����ָ����Ӧ��ֵ��������Statement����ʹ���ַ���ƴ��
	 * 
	 * ע�� ����JAVA��Ψ���Ļ�1�ĵط�����һ���ǲ�ѯ����е�ResultSetҲ�ǻ�1�ġ�
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="insert into hero values(null,?,?,?)";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF8","root","123456");
				//����sql��䴴��PreparedStatement
				PreparedStatement ps=c.prepareStatement(sql);
			) 
		{
			//���ò���
			ps.setString(1, "��Ī");
			ps.setFloat(2, 313.0f);
			ps.setInt(3, 50);
			//ִ��
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
