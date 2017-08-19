package pers.oyxx.someDemo.CollectionFramework;

public class Hero1 implements Flag{
	 public String name;
	    public float hp;
	 
	    public int damage;
	 
	    public Hero1() {
	 
	    }
	 
	    public Hero1(String name) {
	 
	        this.name = name;
	    }
	 
	    public String toString() {
	        return String.format("[name:%s hp:%.0f]%n", name,hp);
	    }
 
}
