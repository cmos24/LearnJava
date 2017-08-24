package pers.oyxx.someDemo.MultiThreading;

//启动一个线程
public class StartUpAThread {
	public static void main(String[] args) {
		// 步骤 1 : 线程概念
		/*
		 * 首先要理解进程(Processor)和线程(Thread)的区别 进程：启动一个LOL.exe就叫一个进程。
		 * 接着又启动一个DOTA.exe，这叫两个进程。 线程：线程是在进程内部同时做的事情，比如在LOL里，有很多事情要同时做，比如"盖伦”
		 * 击杀“提莫”，同时“赏金猎人”又在击杀“盲僧”，这就是由多线程来实现的。
		 */
		Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
         
        //盖伦攻击提莫
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }
 
        //赏金猎人攻击盲僧
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }
	}
}
