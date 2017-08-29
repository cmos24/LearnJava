package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ORMPractice {
	
	 public static Hero get(int id){
		 Hero hero=null;
		 try{
				Class.forName("com.mysql.jdbc.Driver");			
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			String sql="select * from hero where id=?";
			try(
					Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
							"root","123456");
					PreparedStatement ps=c.prepareStatement(sql);
			) {
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				//��Ϊ����id��Ӧ������Ψһ�ģ�����rs��ֻ��һ���������if()�����˲���while()
				if(rs.next()){
					hero=new Hero();
					hero.id=rs.getInt(1);
					hero.name=rs.getString(2);
					hero.hp=rs.getFloat(3);
					hero.damage=rs.getInt(4);
				}else{
					System.out.println("������idΪ"+id+"��Hero");
					return hero;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return hero;
	 }

	//��һ��Hero������뵽���ݿ���
	public static void add(Hero hero){
		try{
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String sql="insert into hero value(null,?,?,?)";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
						"root","123456");
				PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		) {
			//���ò���
			ps.setString(1, hero.name);
			ps.setFloat(2,hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			System.out.println("����ɹ�");
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				hero.id=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// �����Hero�����Ӧ������ɾ����
	public static void delete(Hero hero){
		int id=hero.id;
		try{
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String sql="delete from hero where id=?";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
						"root","123456");
				PreparedStatement ps=c.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			ps.execute();
			System.out.println("ɾ���ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// ��������Hero����
	public static void update(Hero hero){
		int id=hero.id;
		try{
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String sql="update hero set name=? , hp=? , damage=? where id=?";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
						"root","123456");
				PreparedStatement ps=c.prepareStatement(sql);
		) {
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
			System.out.println("���³ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// �����е�Hero���ݲ�ѯ������ת��ΪHero����󣬷���һ�������з���
	public static List<Hero> list(){
		List<Hero> list=new ArrayList<Hero>();
		try{
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String sql="select * from hero";
		try(
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
						"root","123456");
				PreparedStatement ps=c.prepareStatement(sql);
		) {
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Hero h=new Hero();
				h.id=rs.getInt(1);
				h.name=rs.getString(2);
				h.hp=rs.getFloat(3);
				h.damage=rs.getInt(4);
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		Hero manwang=new Hero();
		manwang.name="����";
		manwang.hp=700.0f;
		manwang.damage=150;
		//����
		add(manwang);
		System.out.println("�޸�ǰ�������˺�="+get(manwang.id).damage);
		manwang.damage=180;
		//���£��޸ģ�����
		update(manwang);
		System.out.println("�޸ĺ��������˺�="+get(manwang.id).damage);
		//ɾ��
		delete(manwang);

		
		List<Hero> hl=list();
		System.out.println("hero������"+hl.size()+"��Ӣ�ۣ��ֱ��ǣ�");
		for(Hero each:hl){
			System.out.println(each);
		}
		
		
	}

}
