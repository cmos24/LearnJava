package pers.oyxx.someDemo.MultiThreading;

//线程交互的Hero
public class Hero5 {
	public String name;
	public float hp;
	public int damage;

	public synchronized void recover() {
		hp += 1;
		System.out.printf("%s回血1点，回血后血量是%.0f%n", name, hp);
		// 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
		this.notify();
	}

	public synchronized void hurt() {
		if (1 == hp) {
			try {
				System.out.println("线程等待中");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hp -= 1;
		System.out.printf("%s减血1点，减血后血量是%.0f%n",name,hp);
	}
	
	public void attckHero(Hero5 h){
		h.hp-=damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
		if(h.isDead()){
			System.out.println(h.name+"死了！");
		}
	}
	
	public boolean isDead(){
		return hp<=0?true:false;
	}
	
	
}
