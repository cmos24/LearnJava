package pers.oyxx.someDemo.JavaReflect;

public class Hero {
	/*步骤 3 : 获取类对象的时候，会导致类属性被初始化
	为Hero增加一个静态属性,并且在静态初始化块里进行初始化，参考 类属性初始化。 */
	static String copyright;
	static{
		System.out.println("初始化 copyright");
		copyright="版权由Riot Games公司所有";
	}
	
	public String name;
	public float hp;
	public int damage;
	
	@Override
	public String toString(){
		return name;
	}
	
	public void Attack(){
		
	}

}
