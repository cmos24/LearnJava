package pers.oyxx.someDemo.JavaReflect;

public class Hero {
	/*���� 3 : ��ȡ������ʱ�򣬻ᵼ�������Ա���ʼ��
	ΪHero����һ����̬����,�����ھ�̬��ʼ��������г�ʼ�����ο� �����Գ�ʼ���� */
	static String copyright;
	static{
		System.out.println("��ʼ�� copyright");
		copyright="��Ȩ��Riot Games��˾����";
	}
	
	public String name;
	public float hp;
	public int damage;
	
	@Override
	public String toString(){
		return name;
	}
	
	public void Attack(){
		
	}

}
