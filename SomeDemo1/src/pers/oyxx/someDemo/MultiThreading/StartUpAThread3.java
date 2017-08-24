package pers.oyxx.someDemo.MultiThreading;

/*
 * 创建类Battle，实现Runnable接口 启动的时候，首先创建一个Battle对象，然后再根据该Battle对象创建一个线程对象，并启动
 * 
 * Battle battle1 = new Battle(gareen,teemo); new Thread(battle1).start();
 * 
 * 
 * battle1 对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程。
 * 必须，借助一个线程对象的start()方法，才会启动一个新的线程。
 * 所以，在创建Thread对象的时候，把battle1作为构造方法的参数传递进去，这个线程启动的时候，就会去执行battle1.run()方法了。
 */
//步骤 3 : 创建多线程-实现Runnable接口
public class StartUpAThread3 {
	
	public static void main(String[] args) {
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
        
        Battle battle1=new Battle(gareen, teemo);
        new Thread(battle1).start();
        
        Battle battle2=new Battle(bh,leesin);
        new Thread(battle2).start();
	}

}
