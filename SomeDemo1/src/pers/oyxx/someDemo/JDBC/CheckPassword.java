package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQL����ж��˺������Ƿ���ȷ
public class CheckPassword {
	/*
	 * 1. ����һ���û������ֶ�name,password 2. ����һ������
	 * 
	 * insert into user values(null,'dashen','thisispassword');
	 * 
	 * 
	 * 3. SQL����ж��˺������Ƿ���ȷ
	 * 
	 * �ж��˺��������ȷ��ʽ�Ǹ����˺ź����뵽����ȥ�����ݣ���������ݣ��ͱ���������ȷ�ˣ����û���ݣ��ͱ����������
	 * 
	 * ��ǡ���ķ�ʽ �ǰ�uers�������ȫ���鵽�ڴ��У��������бȽϡ� ���users������100���������أ� �ڴ涼�����õġ�
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
			// ��ȷ�����ǣ�thisispassword
			String password = "thisispassword";

			String sql = "select * from user where name='" + name + "'and password='" + password + "'";
			// ִ�в�ѯ���
			ResultSet rs = s.executeQuery(sql);
			if (rs.next())
				System.out.println("������ȷ");
			else
				System.out.println("�������");

			/*
			 * ���� 3 : ��ȡ���� ���� ִ�е�sql���Ϊ
			 * 
			 * select count(*) from hero
			 * 
			 * 
			 * Ȼ��ͨ��ResultSet��ȡ����
			 * 
			 */
			String sql1 = "select count(*) from hero";
			ResultSet rs1 = s.executeQuery(sql1);
			int total = 0;
			while (rs1.next()) {
				total = rs1.getInt(1);
			}
			System.out.println("��hero���ܹ��У�" + total + "������");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
