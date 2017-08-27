package pers.oyxx.someDemo.MultiThreading;

//�߳̽�����Hero
public class Hero5 {
	public String name;
	public float hp;
	public int damage;

	public synchronized void recover() {
		hp += 1;
		System.out.printf("%s��Ѫ1�㣬��Ѫ��Ѫ����%.0f%n", name, hp);
		// ֪ͨ��Щ�ȴ���this�����ϵ��̣߳������ѹ����ˣ����20�У��ȴ��ŵļ�Ѫ�̣߳����ѹ���
		this.notify();
	}

	public synchronized void hurt() {
		if (1 == hp) {
			try {
				System.out.println("�̵߳ȴ���");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hp -= 1;
		System.out.printf("%s��Ѫ1�㣬��Ѫ��Ѫ����%.0f%n",name,hp);
	}
	
	public void attckHero(Hero5 h){
		h.hp-=damage;
		System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
		if(h.isDead()){
			System.out.println(h.name+"���ˣ�");
		}
	}
	
	public boolean isDead(){
		return hp<=0?true:false;
	}
	
	
}
