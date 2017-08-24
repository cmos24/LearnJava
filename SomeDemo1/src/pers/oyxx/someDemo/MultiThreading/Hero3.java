package pers.oyxx.someDemo.MultiThreading;

public class Hero3 {
	public String name;
	public float hp;

	public int damage;

	public void attackHero(Hero3 h) {

		h.hp -= damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

		if (h.isDead())
			System.out.println(h.name + "死亡");
	}

	private int totalTime = 3;

	public void adugen() {
		while (true) {
			for (int i = 0; i < totalTime; i++) {
				System.out.printf("波动拳第%d发%n", i + 1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("开始为时5秒的充能");
			try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
		}
	}

	public boolean isDead() {
		return 0 >= hp ? true : false;
	}
}
