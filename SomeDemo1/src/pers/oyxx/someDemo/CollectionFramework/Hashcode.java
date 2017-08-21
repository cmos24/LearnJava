package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Hashcodeԭ�����
public class Hashcode {
	public static void main(String[] args){
		//���� 1 : List���ҵĵ�Ч��
		/*������List�д�������ظ����ƣ�û��˳���2000000��Hero
		Ҫ�����ֽ�����hero 1000000���Ķ����ҳ���
		List�������Ƕ�ÿһ�����а���������ֱ���ҵ����ֽ�����hero 1000000����Ӣ�ۡ�
		��������£���Ҫ�����ͱȽ�2000000�Σ������ҵ���Ӧ��Ӣ�ۡ�
		�����߼���
		1. ��ʼ��2000000������ArrayList��
		2. ���������е�����˳��
		3. ����10�β�ѯ��ͳ��ÿһ�����ĵ�ʱ��
		��ͬ���������������£��������¼���������ġ� �ڱ����ϣ�������ʱ������600��������*/
		List<Hero> heros1=new ArrayList<Hero>();
		//��ʼ��List
		for(int i=0;i<2000000;i++){
			heros1.add(new Hero("Hero"+i));
		}
		//����10�β��ң��۲�����ƽ��ֵ
		for(int i=0;i<10;i++){
			//����������Ԫ�ص�˳��
			Collections.shuffle(heros1);
			long startTime=System.currentTimeMillis();
			for(Hero h:heros1){
				if(h.name.equals("Hero1000000")){
					System.out.println("��List���ҵ���"+h);
					break;
				}
			}
			long endTime=System.currentTimeMillis();
			System.out.println("����"+(endTime-startTime)+"����");
		}
		
		//���� 2 : HashMap�����ܱ���
		/*ʹ��HashMap ��ͬ���Ĳ���
		1. ��ʼ��2000000������HashMap�С�
		2. ����10�β�ѯ
		3. ͳ��ÿһ�εĲ�ѯ���ĵ�ʱ��
		���Թ۲쵽����������ʱ�䣬���ѵ�ʱ����1��������*/
		HashMap<Integer,Hero> heros2=new HashMap<Integer,Hero>();
		//��ʼ��HashMap
		for(int i=0;i<2000000;i++){
			heros2.put(i, new Hero("hero"+i));
		}
		//����10�β�ѯ
		for(int i=0;i<10;i++){
			long startTime=System.currentTimeMillis();
			Hero hero=heros2.get(1000000);
			System.out.println("��HashMap���ҵ���"+hero);
			long endTime=System.currentTimeMillis();
			System.out.println("����"+(endTime-startTime)+"����");
		}
		
		
		
		
	}//main����β��
}
