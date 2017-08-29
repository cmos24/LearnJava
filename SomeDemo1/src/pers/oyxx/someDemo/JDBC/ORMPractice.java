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
				//因为表中id对应的行是唯一的，所以rs中只有一个结果，用if()就行了不用while()
				if(rs.next()){
					hero=new Hero();
					hero.id=rs.getInt(1);
					hero.name=rs.getString(2);
					hero.hp=rs.getFloat(3);
					hero.damage=rs.getInt(4);
				}else{
					System.out.println("不存在id为"+id+"的Hero");
					return hero;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return hero;
	 }

	//把一个Hero对象插入到数据库中
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
			//设置参数
			ps.setString(1, hero.name);
			ps.setFloat(2,hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			System.out.println("插入成功");
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				hero.id=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 把这个Hero对象对应的数据删除掉
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
			System.out.println("删除成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 更新这条Hero对象
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
			System.out.println("更新成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
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
		manwang.name="蛮王";
		manwang.hp=700.0f;
		manwang.damage=150;
		//插入
		add(manwang);
		System.out.println("修改前蛮王的伤害="+get(manwang.id).damage);
		manwang.damage=180;
		//更新（修改）数据
		update(manwang);
		System.out.println("修改后蛮王的伤害="+get(manwang.id).damage);
		//删除
		delete(manwang);

		
		List<Hero> hl=list();
		System.out.println("hero表中有"+hl.size()+"个英雄，分别是：");
		for(Hero each:hl){
			System.out.println(each);
		}
		
		
	}

}
