package pers.oyxx.someDemo.MultiThreading;

//������Ϊͬ�������Hero����
public class Hero4 {
	public String name;
	public float hp;
	public int damage;
	
	
	//��Ѫ
	//ֱ���ڷ���ǰ�������η�synchronized
    //������Ӧ��ͬ�����󣬾���this
    //��hurt�����ﵽ��Ч��һ��
	public synchronized void recover(){
		hp+=1;
	}
	
	
	//��Ѫ
	public void hurt(){
		//ʹ��this��Ϊͬ������,�����̵߳���hurt()������ʱ��͵���recover()���̻߳�����������hurt()���߳̾Ͳ���ʹ��Hero������
		synchronized(this){
			hp-=1;
		}		
	}
	
	public void attackHero(Hero4 h){
		h.hp-=damage;
		System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead()){
			System.out.println(h.name +"���ˣ�");
		}
	}
	
	public boolean isDead(){
		return 0>=hp?true:false;
	}
}
