package pers.oyxx.someDemo.InterfaceandInherit;

public class Hero {
	String name;
	float hp;
	float armor;
	int moveSpeed;
	
	public Hero(){
		//System.out.println("Hero的无参构造方法");
	}
	public Hero(String str){
		System.out.println("Hero的一个有参构造方法"+str);
	}
	public void finalize(){
		System.out.println("这个对象正在被回收");
	}

}
