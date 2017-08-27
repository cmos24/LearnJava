package pers.oyxx.someDemo.MultiThreading;

public class Hero6 {
	public String name;
	public float hp;

	public int damage;
	
	public synchronized void recover(){
		while(hp>1000){//��while����if��ԭ������if�Ļ���wait״̬�ᱻ���Ѻ��ֱ��ִ������ļ�Ѫ��䣬��������ȥ���hp��û�е�1000��
				//����while���㱻����֮�����ڼ��״̬�У����Ա�֤������
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp+=1;
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
		this.notify();
	}
	
	public synchronized void hurt(){
		//��if��Ϊwhile�������Ѻ󣬻��ظ��鿴hp��ֵ��ֻ��hp����1���Ż�����ִ��
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
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
		this.notify();
	}
	
	public void attackHero(Hero6 h) {
        h.hp -= damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "���ˣ�");
    }
  
    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
	
}
