package pers.oyxx.someDemo.MultiThreading;

public class Hero2 {
	public String name; 
    public float hp;
     
    public int damage;
     
    public void attackHero(Hero2 h) {
    	//����ͣʱ��ȥ���������̸߳��Իᾡ��ȥռ��CPU��Դ
        //�̵߳����ȼ�Ч���ſ��Կ��ó���
       /*try {
            //Ϊ�˱�ʾ������Ҫʱ�䣬ÿ�ι�����ͣ500����
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        h.hp-=damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"����");
    }
 
    //��Ѫ
    public void hurt(){
    	hp-=1;
    }
    //��Ѫ
    public void recover(){
    	hp+=1;
    }
    
    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
