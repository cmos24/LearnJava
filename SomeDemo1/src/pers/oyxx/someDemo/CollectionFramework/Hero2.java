package pers.oyxx.someDemo.CollectionFramework;

//���ڲ��ԱȽ�����Hero��
public class Hero2 {
	public String name;
	public float hp;
	public int damage;
	
	public Hero2(){
		
	}
	public Hero2(String name){
		this.name=name;
	}	
	public Hero2(String name,float hp,int damage){
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
	@Override
	public String toString(){
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}
}
