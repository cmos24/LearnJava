package pers.oyxx.someDemo.InterfaceandInherit;

/*������ָ����������һ�����ͬʱʵ��������ʹ������Ӽ�ྫ��
ͨ������£�Ҫʹ��һ���ӿڻ��߳����࣬�����봴��һ������

�е�ʱ��Ϊ�˿���ʹ�ã�ֱ��ʵ����һ�������࣬����������ʵ������󷽷���
��Ȼʵ���˳��󷽷�����ô����һ���µ��ֻ࣬������࣬û��������
�������࣬����������*/

//Hero������汾
public abstract class AbstractHero_AnonymousClass {
	String name; // ����

	float hp; // Ѫ��

	float armor; // ����

	int moveSpeed; // �ƶ��ٶ�

	public abstract void attack();
	
	public static void main(String[] args){	
		ADHero adh=new ADHero();
		adh.physicAttack();
		System.out.println(adh);//ͨ����ӡadh�����Կ���adh�����������ADHero��
		
		AbstractHero_AnonymousClass hero=new AbstractHero_AnonymousClass() {
			//����ʵ��attack����
			@Override
			public void attack() {
				System.out.println("new AttackType");
			}
		};
		hero.attack();
		//ͨ����ӡhero�����Կ���hero�����������AbstractHero_AnonymousClass$1��ôһ��ϵͳ�Զ����������
		System.out.println(hero);
				
	}

}
