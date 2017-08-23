package pers.oyxx.someDemo.JavaGeneric;

import java.util.ArrayList;

//泛型练习
public class GenericPractice1 {
	/*
	 * 如代码所示，为了遍历不同泛型的3种集合，需要设计3个方法
	 * 
	 * 借助? extends， 把代码减肥到只是用一种方法 代码比较 复制代码
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
