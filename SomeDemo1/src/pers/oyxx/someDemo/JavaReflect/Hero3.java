package pers.oyxx.someDemo.JavaReflect;

public class Hero3 {
	public String name;
	public float hp;
	public int damage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Hero3(){
		
	}
	public Hero3(String name){
		this.name=name;
	}
	
	
	@Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void attackHero(Hero3 h2) {
        System.out.println(this.name+ " ÕýÔÚ¹¥»÷ " + h2.getName());
    }
	
	
}
