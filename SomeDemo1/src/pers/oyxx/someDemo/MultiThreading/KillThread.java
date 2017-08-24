package pers.oyxx.someDemo.MultiThreading;

public class KillThread extends Thread{
	private Hero h1;
	private Hero h2;
	
	/**
	 * 
	 * @param h1
	 * 	����������Hero
	 * @param h2
	 * 	��������Hero
	 */
	public KillThread(Hero h1,Hero h2){
		this.h1=h1;
		this.h2=h2;
	}
	
	public void run(){
		while(!h2.isDead()){
			h1.attackHero(h2);
		}
	}
}
