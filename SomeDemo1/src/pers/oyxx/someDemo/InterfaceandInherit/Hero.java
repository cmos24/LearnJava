package pers.oyxx.someDemo.InterfaceandInherit;

public class Hero {
	String name;
	float hp;
	float armor;
	int moveSpeed;
	
	public Hero(){
		//System.out.println("Hero���޲ι��췽��");
	}
	public Hero(String str){
		System.out.println("Hero��һ���вι��췽��"+str);
	}
	public void finalize(){
		System.out.println("����������ڱ�����");
	}

}
