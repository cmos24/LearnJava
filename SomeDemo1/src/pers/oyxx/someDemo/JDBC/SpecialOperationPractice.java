package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/*������һ������֮��ͨ����ȡ������id���õ��������ݵ�id������˵��55. 

ɾ���������ݵ�ǰһ����54.

���54�����ڣ���ɾ��53���Դ�����ֱ��ɾ����һ�����ݡ�*/
//��ϰ-������id
public class SpecialOperationPractice {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String insSql="insert into hero value(null,?,?,?)";
		String delSql="delete from hero where id=?";
		String selSql="select * from hero where id=?";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8","root","123456");
				PreparedStatement ps1=c.prepareStatement(insSql,Statement.RETURN_GENERATED_KEYS);
				PreparedStatement ps2=c.prepareStatement(delSql);
				PreparedStatement ps3=c.prepareStatement(selSql);
			) {
			ps1.setString(1,"����");
			ps1.setFloat(2, 353.0f);
			ps1.setInt(3, 100);
			ps1.execute();
			
			ResultSet rs=ps1.getGeneratedKeys();
			int id = 0;
			while(rs.next()){
				id=rs.getInt(1);
			}
			System.out.println("�²��������id="+id);
			while((id-1)>=0){
				ps3.setInt(1, (id-1));
				ResultSet rs1=ps3.executeQuery();
				rs1.last();//��ָ��ָ�����һ��
				int size=rs1.getRow();//������һ�е�����
				if(0==size){
					id-=1;
				}else{
					ps2.setInt(1,(id-1));
					ps2.execute();
					System.out.println("id="+(id-1)+"�����ݴ��ڣ�ɾ��������");
					break;
				}				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
