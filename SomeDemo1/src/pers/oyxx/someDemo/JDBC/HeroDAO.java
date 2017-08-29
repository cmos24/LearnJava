package pers.oyxx.someDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*DAO=DataAccess Object 

数据库访问对象 

实际上就是运用了练习-ORM中的思路，把数据库相关的操作都封装在这个类里面，其他地方看不到JDBC的代码*/
public class HeroDAO implements HeroDAOInterface{
	/*设计类HeroDAO，
	实现接口DAO

	这个HeroDAO和答案-ORM很接近，做了几个改进：
	1. 把驱动的初始化放在了构造方法HeroDAO里：

	public HeroDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	因为驱动初始化值需要执行一次，所以放在这里更合适，其他方法里也不需要写了，代码更简洁

	2.提供了一个getConnection方法返回连接 所有的数据库操作都需要事先拿到一个数据库连接Connection，以前的做法每个方法里都会写一个，
	如果要改动密码，那么每个地方都需要修改。通过这种方式，只需要修改这一个地方就可以了。代码变得更容易维护，而且也更加简洁。*/

	
	//private Connection connection;
	
	//将连接数据库操作放入构造函数中
	public HeroDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	private Connection getConnection() throws SQLException{
		Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF8&useSSL=true",
				"root", "123456");
		return connection;
	}
	
	@Override
	public void add(Hero hero) {//插入
		String sql="insert into hero value(null,?,?,?)";
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		){
			ps.setString(1, hero.name);
			ps.setFloat(2,hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				int id=rs.getInt(1);
				hero.id=id;
			}
			System.out.println("插入成功");
		}catch(SQLException e){
			e.printStackTrace();
		}
				
	}


	@Override
	public void update(Hero hero) {//更新修改
		String sql="update hero set name=? , hp=? , damage=? where id=?";
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
			
			System.out.println("修改成功");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}




	@Override
	public void delete(int id) {//删除
		String sql="delete from hero where id=?";
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			ps.setInt(1, id);
			ps.execute();
			System.out.println("删除成功");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}




	@Override
	public Hero get(int id) {//通过id获得对象
		Hero hero = null;
		String sql="select * from hero where id=?";
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				hero=new Hero();
				hero.id=rs.getInt(1);
				hero.name=rs.getString(2);
				hero.hp=rs.getFloat(3);
				hero.damage=rs.getInt(4);				
			}else{
				System.out.println("不存在id="+id+"的Hero");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return hero;
	}




	@Override
	public List<Hero> list() {//获得所有hero对象的list
		List<Hero> list=new ArrayList<Hero>();
		String sql="select * from hero";
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Hero h=new Hero();
				h.id=rs.getInt(1);
				h.name=rs.getString(2);
				h.hp=rs.getFloat(3);
				h.damage=rs.getInt(4);
				list.add(h);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}




	@Override
	public List<Hero> list(int start, int count) {//分页
		List<Hero> list=new ArrayList<Hero>();
		List<Hero> listAll=null;
		String sql="select * from hero order by id desc limit ?,?";//用limit分页的情况下把排序语句放到sql语句的最后是语法错误
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			//如果起始位置超过表中数据数量
			listAll= list();
			if(start>=listAll.size()){
				return null;
			}
			
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Hero h=new Hero();
				h.id=rs.getInt(1);
				h.name=rs.getString(2);
				h.hp=rs.getFloat(3);
				h.damage=rs.getInt(4);
				list.add(h);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	
					
	
	public static void main(String[] args) {
		HeroDAO mwDao=new HeroDAO();
		
		Hero manwang=new Hero();
		manwang.name="蛮王";
		manwang.hp=700.0f;
		manwang.damage=150;
		//插入
		mwDao.add(manwang);
		System.out.println("修改前蛮王的伤害="+mwDao.get(manwang.id).damage);
		manwang.damage=180;
		//更新（修改）数据
		mwDao.update(manwang);
		System.out.println("修改后蛮王的伤害="+mwDao.get(manwang.id).damage);
		//删除
		mwDao.delete(manwang.id);

		
		List<Hero> hl=mwDao.list();
		System.out.println("hero表中有"+hl.size()+"个英雄，分别是：");
		for(Hero each:hl){
			System.out.println(each);
		}
		
		
		List<Hero> pl=mwDao.list(0,5);
		Iterator iterator=pl.iterator();
		System.out.println("分页效果：");
		while(iterator.hasNext()){
			Hero h=(Hero)iterator.next();
			System.out.println(h);
		}
	}

}
