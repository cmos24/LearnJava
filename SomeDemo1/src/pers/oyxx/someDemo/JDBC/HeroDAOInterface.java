package pers.oyxx.someDemo.JDBC;

import java.util.List;

//DAO接口
public interface HeroDAOInterface {
	//增加
	public void add(Hero hero);
	//修改
	public void update(Hero hero);
	// 删除
	public void delete(int id);
	// 获取
	public Hero get(int id);
	// 查询
	public List<Hero> list();
	// 分页查询
	public List<Hero> list(int start,int count);
}
