package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//执行查询SQL语句
public class Retrieve {

	public static void main(String[] args) {
		/*步骤 1 : 查询语句
		executeQuery 执行SQL查询语句
		
		注意： 在取第二列的数据的时候，用的是rs.get(2) ，而不是get(1). 这个是整个Java自带的api里唯二的地方，使用基1的，即2就代表第二个。
		
		另一个地方是在PreparedStatement这里*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "123456");
				Statement s=c.createStatement();
			)
		{
			String sql="select * from hero";
			//执行查询语句，并把结果集返回给ResultSet
			ResultSet rs =s.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");//可以使用字段名
				String name=rs.getString(2);//也可以使用字段的顺序
				float hp=rs.getFloat("hp");
				int damage=rs.getInt(4);
				System.out.printf("%d\t%s\t%f\t%d%n",id,name,hp,damage);				
			}
			//不一定要在这里关闭ResultSet，因为Statement关闭的时候会自动关闭ResultSet
			//rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
