package pers.oyxx.someDemo.InterfaceandInherit;

/*����������ʹ���ⲿ�ľֲ��������ⲿ�ľֲ�������������Ϊfinal

ΪʲôҪ����Ϊfinal������ƱȽϸ��ӣ���ο��ڶ���Hero�����еĽ���

ע����jdk8�У��Ѿ�����Ҫǿ�����γ�final�ˣ����û��дfinal�����ᱨ����Ϊ������͵͵�İ�������˿�������final*/

public abstract class AbstractHero_AnonymousClass1 {

	public abstract void attack();

	public static void main(String[] args) {
		//����������ʹ���ⲿ�ľֲ��������ⲿ�ľֲ�������������Ϊfinal
        final int damage = 5;
        
        AbstractHero_AnonymousClass1 hero =new AbstractHero_AnonymousClass1(){
        	public void attack(){
        		System.out.printf("�µĹ�����ʽ�����%d���˺�%n",damage);
        	}
        };
	}
}
