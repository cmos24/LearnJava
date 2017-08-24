package pers.oyxx.someDemo.MultiThreading;

public class Hero2 {
	public String name; 
    public float hp;
     
    public int damage;
     
    public void attackHero(Hero2 h) {
    	//把暂停时间去掉，多条线程各自会尽力去占有CPU资源
        //线程的优先级效果才可以看得出来
       /*try {
            //为了表示攻击需要时间，每次攻击暂停500毫秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"死亡");
    }
 
    //掉血
    public void hurt(){
    	hp-=1;
    }
    //回血
    public void recover(){
    	hp+=1;
    }
    
    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
