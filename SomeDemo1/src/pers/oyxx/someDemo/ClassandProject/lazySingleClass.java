package pers.oyxx.someDemo.ClassandProject;

//��������ģʽ
public class lazySingleClass {
	//˽�л����췽��ʹ�ø����޷����ⲿͨ��new ����ʵ����
	private lazySingleClass(){
		
	}
	//׼��һ�������ԣ�����ָ��һ��ʵ�������󣬵�����ʱָ��null
	private static lazySingleClass instance=null;
	//public static ����������ʵ������
	public static lazySingleClass getInstance(){
		//��һ�η��ʵ�ʱ�򣬷���instanceû��ָ���κζ�����ʱʵ����һ������
		if(null==instance){
			instance =new lazySingleClass();
		}
		//���� instanceָ��Ķ���
		return instance;	
	}
}
