package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*ORM=Object Relationship Database Mapping 

����͹�ϵ���ݿ��ӳ�� 

��˵��һ�����󣬶�Ӧ���ݿ����һ����¼
*/
//ROM
public class ORM {

	public static Hero get(int id){
		Hero hero = new Hero();
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8",
				"root", "123456"); Statement s = c.createStatement();) {
			String sql = "select * from hero where id = " + id;

			ResultSet rs = s.executeQuery(sql);
			// ��Ϊid��Ψһ�ģ�ResultSet���ֻ����һ����¼
			// ����ʹ��if����while
			if(rs.next()){
				hero=new Hero();
				String name=rs.getString(2);
				float hp=rs.getFloat(3);
				int damage=rs.getInt(4);
				hero.name=name;
				hero.hp=hp;
				hero.damage=damage;
				hero.id=id;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return hero;
	}
	
	public static void main(String[] args) {
		Hero h=get(211);
		System.out.println(h.name);
	}

}
