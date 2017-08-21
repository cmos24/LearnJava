package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//����
public class ArrayListGeneric {

	public static void main(String[] args) {
		// ���� 1 : ���� Generic
		/*
		 * ��ָ�����͵����������Դ���κ����͵�Ԫ�� 
		 * ָ���˷��͵�������ֻ�ܴ��ָ�����͵�Ԫ���Լ�������
		 */
		
		//���ڲ�ʹ�÷��͵������������������Ӣ�ۣ�Ҳ�������������Ʒ
		List<Object> heros=new ArrayList<Object>();
		
		heros.add(new Hero("����"));
		
		//�������ڴ��Ӣ�۵�����������Ҳ���Դ����Ʒ��
		heros.add(new Item("����"));
		
		//����ת�ͻ��������
		Hero h1=(Hero)heros.get(0);
		//��������������ŵĶ���̫���ʱ�򣬾ͼǲ�����ĸ�λ�÷ŵ����������͵Ķ�����
		//Hero h2=(Hero)heros.get(1);//���лᱨ����Ϊ����heros���±�Ϊ1��Ԫ�ز���Hero���͵�
		
		//���뷺��Generic
		//����������ʱ�򣬾�ָ����������ֻ�ܷ�Hero���͵Ķ��󣬷������ľͻ����
		List<Hero> genericheros=new ArrayList<Hero>();
		genericheros.add(new Hero("����"));
		//�������Hero���ͣ������ͷŲ���ȥ
        //genericheros.add(new Item("����"));
		
		//����֮�⻹�ܴ��Hero�����࣬��Ϊ����ת���ɸ�����һ���ܳɹ��ģ�
		//genericheros.add(new APHero());
		
		//������ȡ�����ݵ�ʱ�򣬲���Ҫ�ٽ���ת���ˣ���Ϊ����ŵĿ϶���Hero������������
		Hero h=genericheros.get(0);
		
		//���� 2 : ���͵ļ�д
		/*Ϊ�˲�ʹ���������־��棬��Ҫǰ��ʹ�÷��ͣ���������		 
		List<Hero> genericheros = new ArrayList<Hero>();		 
		����JDK7�ṩ��һ��������΢���ٴ������ķ��ͼ�д��ʽ		 
		List<Hero> genericheros2 = new ArrayList<>();*/
		List<Hero> genericheros1=new ArrayList<Hero>();
		List<Hero> genericheros2=new ArrayList<>();
		
		
		
			
	}

}
