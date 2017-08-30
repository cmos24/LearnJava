package pers.oyxx.someDemo.WebProgramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//ChatAndroid词典操作数据库类
public class DictionaryDAO {
	// 构造函数加载mysql驱动
	public DictionaryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//获得数据库连接
	private Connection getConnection() {
		Connection c=null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/android?characterEncoding=UTF8&useSSL=true",
					"root" , "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	//获得对话结果容器
	public List<Dictionary> query(String recieve){
//		List<Dictionary> ds=null;//原本这样写导致下面的add()不能插入数据，返回的是null所以会出错
		List<Dictionary> ds=new ArrayList<Dictionary>();
		String sql="select * from dictionary where receive=?";
		try(Connection c=getConnection();
			PreparedStatement ps=c.prepareStatement(sql);
		) {
			ps.setString(1, recieve);
//			ps.setString(1, sql);//原本这样写导致一直在数据库中找不到对应的行
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt(1);
				String receive=rs.getString("receive");
				String response=rs.getString("response");
				Dictionary d=new Dictionary();
				d.id=id;
				d.receive=receive;
				d.response=response;
				ds.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ds;
	}

}
