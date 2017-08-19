package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//练习-英雄二叉树
/*根据上面的学习和理解，设计一个Hero二叉树，HeroNode. 
可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。

随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。*/
public class HeroNode {
	public HeroNode leftHero;
	 
    public HeroNode rightHero;
 
    // 声明为Hero类型
    public Hero1 value;
 
    public void add(Hero1 v) {
 
        if (null == value)
            value = v;
 
        else {
 
            // 如果新英雄血量，比本节点大，就放在左边
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
            h.hp = (float) (Math.random() * 900 + 100); // 100-1000的随机血量
            hs.add(h);
        }
        System.out.println("初始化10个Hero");
        System.out.println(hs);
 
        HeroNode heroTree = new HeroNode();
        for (Hero1 hero : hs) {
            heroTree.add(hero);
        }
        System.out.println("根据血量倒排序后的Hero");
        List<Object> treeSortedHeros = heroTree.values();
        System.out.println(treeSortedHeros);
 
    }

}
