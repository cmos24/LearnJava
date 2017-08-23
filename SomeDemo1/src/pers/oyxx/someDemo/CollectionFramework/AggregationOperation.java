package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Comparator;

//���Ͽ�ܡ����ۺ�
public class AggregationOperation {
	//�ۺϲ���
	public static void main(String[] args) {
		Random r=new Random();
		List<Hero2> heros=new ArrayList<Hero2>();
		for(int i=0;i<10;i++){
			heros.add(new Hero2("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("��ʼ�����Ϻ�����ݣ����һ�������ظ���");
		System.out.println(heros);
		
		//��ͳ��ʽ
		Collections.sort(heros,new Comparator<Hero2>(){//�����࣬�Ƚ���Comparator�ǳ����࣬������ʹ�õ�ʱ��˳��ѷ���ʵ����
			@Override
			public int compare(Hero2 h1,Hero2 h2){
				return (int)(h2.hp-h1.hp);
			}
		});
		System.out.println("�����ļ������ݣ�");
		System.out.println(heros);
		System.out.println("ͨ����ͳ��ʽ�ҳ���hp�����ߵ�Ӣ���ǣ�");
		System.out.println(heros.get(2));
		
		//�þۺϵķ�ʽ����
		/*String name =heros
            .stream()
            .sorted((h1,h2)->h1.hp>h2.hp?-1:1)
            .skip(2)
            .map(h->h.getName())
            .findFirst()
            .get();
 
        System.out.println("ͨ���ۺϲ����ҳ�����hp�����ߵ�Ӣ��������:" + name);*/
	}
}
