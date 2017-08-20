package pers.oyxx.someDemo.CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;

//HashSet
public class JavaHashSet {

	public static void main(String[] args) {
		//ʾ�� 1 : Ԫ�ز����ظ�
		HashSet<String> hs=new HashSet<String>();
		hs.add("gareen");
		System.out.println(hs);
		
		//�ڶ��β���ͬ���������ǷŲ���ȥ�ģ�����ֻ�ᱣ��һ��
		hs.add("gareen");
		System.out.println(hs);
		
		
		//ʾ�� 2 : û��˳��
		/*	Set�е�Ԫ�أ�û��˳�� 
		�ϸ��˵����û�а���Ԫ�صĲ���˳������
		HashSet�ľ���˳�򣬼Ȳ��ǰ��ղ���˳��Ҳ���ǰ���hashcode��˳��*/
		/*������HasetSetԴ�����еĲ���ע��
		 /
		 * It makes no guarantees as to the iteration order of the set; 
		 * in particular, it does not guarantee that the order will remain constant over time. 
		 /
		����֤Set�ĵ���˳��; ȷ�е�˵���ڲ�ͬ�����£�Ԫ�ص�˳���п��ܲ�һ��*/
		// ���仰˵��ͬ���ǲ���0-9��HashSet�У� ��JVM�Ĳ�ͬ�汾�У�������˳���ǲ�һ���ġ� �����ڿ�����ʱ�򣬲���������ĳ���ܲ��˳�����˳�����ǲ��ȶ���
		
		hs.clear();
		hs.add("1");
		hs.add("9");
		hs.add("5");
		// Set�е�Ԫ�����У����ǰ��ղ���˳��
		System.out.println(hs);
		
		//ʾ�� 3 : ����
		/*Set���ṩget()����ȡָ��λ�õ�Ԫ�� 
		���Ա�����Ҫ�õ���������������ǿ��forѭ��*/
		
		//����Set���Բ��õ�����iterator
		System.out.println("���õ�����iterator");
		for(Iterator<String> iterator=hs.iterator();iterator.hasNext();){
			String i=(String)iterator.next();
			System.out.println(i);
		}
		
		//���߲�����ǿ��forѭ��
		System.out.println("������ǿ��forѭ��");
		for(String i:hs){
			System.out.println(i);
		}
		
		//ʾ�� 4 : HashSet��HashMap�Ĺ�ϵ
		/*ͨ���۲�HashSet��Դ���루��β鿴Դ���룩
		���Է���HashSet����û�ж�����ʵ�֣������������װ��һ��Map.
		HashSet����ΪMap��key�����ڵ�(���Բ����ظ�)
		��value��һ������ΪPRESENT��static��Object������Ϊ��һ�������ԣ�����ֻ����һ����
 
		private static final Object PRESENT = new Object();*/
		
		
		
	}

}
