package pers.oyxx.someDemo.InterfaceandInherit;

public class Hero {
	public String name;
	public float hp;//为了让这个属性能在另一个包使用访问修饰符可以用public
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
