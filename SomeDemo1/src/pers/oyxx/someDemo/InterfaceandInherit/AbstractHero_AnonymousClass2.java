package pers.oyxx.someDemo.InterfaceandInherit;

/*����������ʹ���ⲿ�ľֲ��������ⲿ�ľֲ�������������Ϊfinal

ΪʲôҪ����Ϊfinal������ƱȽϸ��ӣ���ο��ڶ���Hero�����еĽ���

ע����jdk8�У��Ѿ�����Ҫǿ�����γ�final�ˣ����û��дfinal�����ᱨ����Ϊ������͵͵�İ�������˿�������final*/

public abstract class AbstractHero_AnonymousClass2 {

	public abstract void attack();

	public static void main(String[] args) {

        //����������ʹ���ⲿ�ľֲ�����damage ��������Ϊfinal
        int damage = 5;
         
        //����ʹ�ñ�����AnonymousHero��ģ����������������Ի���
         
        //��ʵ�ϵ������࣬����������������һ��damage���ԣ�����ʹ�ù��췽����ʼ�������Ե�ֵ
        //��attack��ʹ�õ�damage������ʹ�õ�������ڲ�damage�������ⲿdamage
         
        //�����ⲿ���Բ���Ҫ����Ϊfinal
        //��ô��attack���޸�damage��ֵ���ͻᱻ��ʾΪ�޸����ⲿ����damage��ֵ
         
        //�����������ǲ�ͬ�ı������ǲ������޸��ⲿ����damage��
        //����Ϊ�˱�������󵼣��ⲿ��damage��������Ϊfinal,"����ȥ"�Ͳ����޸���
        
        class AnonymousHero extends AbstractHero_AnonymousClass2{
        	int damage;
        	public AnonymousHero(int damage){
        		this.damage=damage;
        	}	
        	public void attack(){
        		System.out.printf("�µĹ�����ʽ�����%d���˺�%n",damage);
        	}
        };
        
        AnonymousHero hero =new AnonymousHero(10);
        hero.attack();
        
	}
}