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

���ݿ���ʶ��� 

ʵ���Ͼ�����������ϰ-ORM�е�˼·�������ݿ���صĲ�������װ����������棬�����ط�������JDBC�Ĵ���*/
public class HeroDAO implements HeroDAOInterface{
	/*�����HeroDAO��
	ʵ�ֽӿ�DAO

	���HeroDAO�ʹ�-ORM�ܽӽ������˼����Ľ���
	1. �������ĳ�ʼ�������˹��췽��HeroDAO�

	public HeroDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	��Ϊ������ʼ��ֵ��Ҫִ��һ�Σ����Է�����������ʣ�����������Ҳ����Ҫд�ˣ���������

	2.�ṩ��һ��getConnection������������ ���е����ݿ��������Ҫ�����õ�һ�����ݿ�����Connection����ǰ������ÿ�������ﶼ��дһ����
	���Ҫ�Ķ����룬��ôÿ���ط�����Ҫ�޸ġ�ͨ�����ַ�ʽ��ֻ��Ҫ�޸���һ���ط��Ϳ����ˡ������ø�����ά��������Ҳ���Ӽ�ࡣ*/

	
	//private Connection connection;
	
	//���������ݿ�������빹�캯����
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
	public void add(Hero hero) {//����
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
			System.out.println("����ɹ�");
		}catch(SQLException e){
			e.printStackTrace();
		}
				
	}


	@Override
	public void update(Hero hero) {//�����޸�
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
			
			System.out.println("�޸ĳɹ�");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}




	@Override
	public void delete(int id) {//ɾ��
		String sql="delete from hero where id=?";
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			ps.setInt(1, id);
			ps.execute();
			System.out.println("ɾ���ɹ�");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}




	@Override
	public Hero get(int id) {//ͨ��id��ö���
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
				System.out.println("������id="+id+"��Hero");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return hero;
	}




	@Override
	public List<Hero> list() {//�������hero�����list
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
	public List<Hero> list(int start, int count) {//��ҳ
		List<Hero> list=new ArrayList<Hero>();
		List<Hero> listAll=null;
		String sql="select * from hero order by id desc limit ?,?";//��limit��ҳ������°��������ŵ�sql����������﷨����
		try(
				Connection c=getConnection();
				PreparedStatement ps=c.prepareStatement(sql);
		){
			//�����ʼλ�ó���������������
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
		manwang.name="����";
		manwang.hp=700.0f;
		manwang.damage=150;
		//����
		mwDao.add(manwang);
		System.out.println("�޸�ǰ�������˺�="+mwDao.get(manwang.id).damage);
		manwang.damage=180;
		//���£��޸ģ�����
		mwDao.update(manwang);
		System.out.println("�޸ĺ��������˺�="+mwDao.get(manwang.id).damage);
		//ɾ��
		mwDao.delete(manwang.id);

		
		List<Hero> hl=mwDao.list();
		System.out.println("hero������"+hl.size()+"��Ӣ�ۣ��ֱ��ǣ�");
		for(Hero each:hl){
			System.out.println(each);
		}
		
		
		List<Hero> pl=mwDao.list(0,5);
		Iterator iterator=pl.iterator();
		System.out.println("��ҳЧ����");
		while(iterator.hasNext()){
			Hero h=(Hero)iterator.next();
			System.out.println(h);
		}
	}

}
