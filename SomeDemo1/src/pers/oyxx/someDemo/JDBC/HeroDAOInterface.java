package pers.oyxx.someDemo.JDBC;

import java.util.List;

//DAO�ӿ�
public interface HeroDAOInterface {
	//����
	public void add(Hero hero);
	//�޸�
	public void update(Hero hero);
	// ɾ��
	public void delete(int id);
	// ��ȡ
	public Hero get(int id);
	// ��ѯ
	public List<Hero> list();
	// ��ҳ��ѯ
	public List<Hero> list(int start,int count);
}
