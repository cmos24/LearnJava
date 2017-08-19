package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//��ϰ-Ӣ�۶�����
/*���������ѧϰ����⣬���һ��Hero��������HeroNode. 
���������Ӣ�۶��������벻ͬ��Hero���󣬲��Ұ���Hero��Ѫ��������

�������10��Hero����ÿ��Hero�����в�ͬ��Ѫ��ֵ���������HeroNode�󣬰���������ӡ������*/
public class HeroNode {
	public HeroNode leftHero;
	 
    public HeroNode rightHero;
 
    // ����ΪHero����
    public Hero1 value;
 
    public void add(Hero1 v) {
 
        if (null == value)
            value = v;
 
        else {
 
            // �����Ӣ��Ѫ�����ȱ��ڵ�󣬾ͷ������
            if (v.hp > value.hp) {
                if (null == leftHero)
                    leftHero = new HeroNode();
                leftHero.add(v);
            }
 
            else {
                if (null == rightHero)
                    rightHero = new HeroNode();
                rightHero.add(v);
            }
 
        }
 
    }
 
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
 
        if (null != leftHero)
            values.addAll(leftHero.values());
 
        values.add(value);
 
        if (null != rightHero)
 
            values.addAll(rightHero.values());
 
        return values;
    }
 
    public static void main(String[] args) {
 
        List<Hero1> hs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero1 h = new Hero1();
            h.name = "hero " + i;
            h.hp = (float) (Math.random() * 900 + 100); // 100-1000�����Ѫ��
            hs.add(h);
        }
        System.out.println("��ʼ��10��Hero");
        System.out.println(hs);
 
        HeroNode heroTree = new HeroNode();
        for (Hero1 hero : hs) {
            heroTree.add(hero);
        }
        System.out.println("����Ѫ����������Hero");
        List<Object> treeSortedHeros = heroTree.values();
        System.out.println(treeSortedHeros);
 
    }

}
