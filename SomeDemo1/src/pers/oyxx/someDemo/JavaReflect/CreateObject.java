package pers.oyxx.someDemo.JavaReflect;

import java.lang.reflect.Constructor;

//��������
public class CreateObject {
	/*�봫ͳ��ͨ��new ����ȡ����ķ�ʽ��ͬ 
	������ƣ������õ�Product�ġ������,Ȼ��ͨ��������ȡ������������ 
	��ͨ�����������󴴽�һ������*/
	public static void main(String[] args){
		// ���� 1 : ����һ������
		/*ͨ��������ƴ���һ������*/
		
		//��ͳʹ��new��ʽ��������
		Hero h1=new Hero();
		h1.name="teemo";
		System.out.println(h1);
		
		try{
			//ʹ�÷���ķ�ʽ��������
			String className="pers.oyxx.someDemo.JavaReflect.Hero";
			//�����
			Class pClass=Class.forName(className);
			//������
			Constructor c=pClass.getConstructor();
			//ͨ��������ʵ����
			Hero h2=(Hero)c.newInstance();
			h2.name="gareen";
			System.out.println(h2);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
