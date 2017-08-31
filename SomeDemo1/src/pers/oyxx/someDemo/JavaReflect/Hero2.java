package pers.oyxx.someDemo.JavaReflect;

public class Hero2 {
	public String name;
    public float hp;
    public int damage;
    public int id;
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Hero2(){
         
    }
    public Hero2(String string) {
        name =string;
    }
 
    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void attackHero(Hero2 h2) {
        // TODO Auto-generated method stub
         
    }
}
