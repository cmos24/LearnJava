package pers.oyxx.someDemo.JavaGeneric;

import java.util.ArrayList;

//������ϰ
public class GenericPractice1 {
	/*
	 * �������ʾ��Ϊ�˱�����ͬ���͵�3�ּ��ϣ���Ҫ���3������
	 * 
	 * ����? extends�� �Ѵ�����ʵ�ֻ����һ�ַ��� ����Ƚ� ���ƴ���
	 */
	/*package generic;
	 
	import java.util.ArrayList;
	 
	import charactor.ADHero;
	import charactor.APHero;
	import charactor.Hero;
	 
	public class TestGeneric {
	 
	    public static void iterate(ArrayList<Hero> list) {
	        for (Hero hero : list) {
	            System.out.println(hero.name);
	        }
	    }
	 
	    public static void iterateAP(ArrayList<APHero> list) {
	        for (Hero hero : list) {
	            System.out.println(hero.name);
	        }
	    }
	 
	    public static void iterateAD(ArrayList<ADHero> list) {
	        for (Hero hero : list) {
	            System.out.println(hero.name);
	        }
	    }
	 
	    public static void main(String[] args) {
	        ArrayList<Hero> hs = new ArrayList<>();
	        ArrayList<APHero> aphs = new ArrayList<>();
	        ArrayList<ADHero> adhs = new ArrayList<>();
	 
	        iterate(hs);
	        iterateAP(aphs);
	        iterateAD(adhs);
	    }
	 
	}*/
	public static void iterate(ArrayList<? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
  
    public static void main(String[] args) {
        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
  
        iterate(hs);
        iterate(aphs);
        iterate(adhs);
    }

}
