package pers.oyxx.someDemo.MultiThreading;

//步骤 4 : 创建多线程-匿名类
public class StartUpAThread4 {
	/*
	 * 使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码 匿名类的一个好处是可以很方便的访问外部的局部变量。
	 * 前提是外部的局部变量需要被声明为final。(JDK7以后就不需要了)
	 */
	//注： 启动线程是start()方法，run()并不能启动一个新的线程
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
          
        //匿名类——因为只用一次且使用目的明确，所以直接在这里把run写成gareen.attackHero(teemo);
        Thread t1=new Thread(){
        	public void run(){
        		//匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
        		while(!teemo.isDead()){
        			gareen.attackHero(teemo);
        		}
        	}
        };
        
        t1.start();
        
        Thread t2=new Thread(){
        	public void run(){
        		while(!leesin.isDead()){
        			bh.attackHero(leesin);
        		}
        	}
        };
        
        t2.start();
	}

}
