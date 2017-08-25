package pers.oyxx.someDemo.MultiThreading;

//本身作为同步对象的Hero对象
public class Hero4 {
	public String name;
	public float hp;
	public int damage;
	
	
	//回血
	//直接在方法前加上修饰符synchronized
    //其所对应的同步对象，就是this
    //和hurt方法达到的效果一样
	public synchronized void recover(){
		hp+=1;
	}
	
	
	//掉血
	public void hurt(){
		//使用this作为同步对象,这样线程调用hurt()方法的时候就调用recover()的线程或者其他调用hurt()的线程就不能使用Hero对象了
		synchronized(this){
			hp-=1;
		}		
	}
	
	public void attackHero(Hero4 h){
		h.hp-=damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead()){
			System.out.println(h.name +"死了！");
		}
	}
	
	public boolean isDead(){
		return 0>=hp?true:false;
	}
}
