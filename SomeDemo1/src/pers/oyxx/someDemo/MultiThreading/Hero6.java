package pers.oyxx.someDemo.MultiThreading;

public class Hero6 {
	public String name;
	public float hp;

	public int damage;
	
	public synchronized void recover(){
		while(hp>1000){//用while不用if的原因是用if的话在wait状态会被唤醒后会直接执行下面的加血语句，而不是再去检查hp有没有到1000，
				//而用while就算被唤醒之后还是在检查状态中，可以保证不出错，
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp+=1;
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
		this.notify();
	}
	
	public synchronized void hurt(){
		//把if改为while，被唤醒后，会重复查看hp的值，只有hp大于1，才会往下执行
        //if (hp <= 1) {
		while(hp<=1){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp-=1;
		System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
		this.notify();
	}
	
	public void attackHero(Hero6 h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "死了！");
    }
  
    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
	
}
