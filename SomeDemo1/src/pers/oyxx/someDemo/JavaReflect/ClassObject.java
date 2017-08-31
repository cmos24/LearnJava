package pers.oyxx.someDemo.JavaReflect;

//��ȡ�����
public class ClassObject {
	/*���� 1 : ʲô�������
	����������֮ǰ����˵������Ϥ�Ķ���֮�������
	gareen��teemo����Hero�������ǵ��������ڣ������в�ͬ�����ƣ�Ѫ�����˺�ֵ��
	
	Ȼ��˵˵��֮�������
	Hero��Item�����࣬���ǵ����������в�ͬ�ķ�������ͬ�����ԡ�
	
	����󣬾����������������࣬����ʲô���ԣ�ʲô������*/
	
	/*���� 2 : ��ȡ����� 
	��ȡ�������3�ַ�ʽ
	1. Class.forName
	2. Hero.class
	3. new Hero().getClass()
	
	��һ��JVM�У�һ���ֻ࣬����һ���������ڡ������������ַ�ʽȡ����������󣬶���һ���ġ�
	
	ע�� ׼ȷ�Ľ���һ��ClassLoader�£�һ���ֻ࣬����һ���������ڡ�ͨ��һ��JVM�£�ֻ����һ��ClassLoader��
	��Ϊ��û������ClassLoader��� ������ʱ��չ���ˡ�*/
	
	public static void main(String[] args) {
		String className="pers.oyxx.someDemo.JavaReflect.Hero";
		try{
			
			Class class1=Class.forName(className);
			Class class2=Hero.class;
			Class class3=new Hero().getClass();
//			����ʲô;����ȡ����󣬶��ᵼ�¾�̬���Ա���ʼ��������ֻ��ִ��һ�Ρ�
			System.out.println("3�ַ�����õ�name�Ƿ���ͬ��");
			System.out.println(class1==class2);
			System.out.println(class2==class3);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
}
