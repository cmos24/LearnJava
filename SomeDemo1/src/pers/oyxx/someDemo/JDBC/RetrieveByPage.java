package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*设计一个方法，进行分页查询
 
public static void list(int start, int count)
 

start 表示开始页数，count表示一页显示的总数
list(0,5) 表示第一页，一共显示5条数据
list(10,5) 表示第三页，一共显示5条数据
*/
//分页查询
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
			String sql="select *from hero limit "+start+","+count;//注意limit后面的空格不能缺少，否则这条sql语句语法不正确
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
