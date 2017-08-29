package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/*当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如说是55. 

删除这条数据的前一条，54.

如果54不存在，则删除53，以此类推直到删除上一条数据。*/
//练习-自增长id
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
			ps1.setString(1,"寒冰");
			ps1.setFloat(2, 353.0f);
			ps1.setInt(3, 100);
			ps1.execute();
			
			ResultSet rs=ps1.getGeneratedKeys();
			int id = 0;
			while(rs.next()){
				id=rs.getInt(1);
			}
			System.out.println("新插入的数据id="+id);
			while((id-1)>=0){
				ps3.setInt(1, (id-1));
				ResultSet rs1=ps3.executeQuery();
				rs1.last();//将指针指向最后一行
				int size=rs1.getRow();//获得最后一行的行数
				if(0==size){
					id-=1;
				}else{
					ps2.setInt(1,(id-1));
					ps2.execute();
					System.out.println("id="+(id-1)+"的数据存在，删除该数据");
					break;
				}				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
