package pers.oyxx.someDemo.WebProgramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//ChatAndroid�ʵ�������ݿ���
public class DictionaryDAO {
	// ���캯������mysql����
	public DictionaryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//������ݿ�����
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
	
	//��öԻ��������
	public List<Dictionary> query(String recieve){
//		List<Dictionary> ds=null;//ԭ������д���������add()���ܲ������ݣ����ص���null���Ի����
		List<Dictionary> ds=new ArrayList<Dictionary>();
		String sql="select * from dictionary where receive=?";
		try(Connection c=getConnection();
			PreparedStatement ps=c.prepareStatement(sql);
		) {
			ps.setString(1, recieve);
//			ps.setString(1, sql);//ԭ������д����һֱ�����ݿ����Ҳ�����Ӧ����
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
