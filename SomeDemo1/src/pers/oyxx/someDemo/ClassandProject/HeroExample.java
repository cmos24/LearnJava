package pers.oyxx.someDemo.ClassandProject;

//验证构造块还是构造函数先执行，static变量（类变量）的使用
public class HeroExample {
	public static String copyright = "RIOT";
	
	static{
		copyright="构造函数先执行，构造块后执行";
	}

	String name; // 姓名
	public float hp; // 血量
	float armor; // 护甲
	int moveSpeed; // 移动速度

	public HeroExample() {
		copyright="构造块先执行，构造函数后执行";
	}

	public HeroExample(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

	// 复活
	public void revive(HeroExample h) {
		// h.hp=383f;//这样才能修改成功
		h = new HeroExample("提莫", 383);// 这里并不能达到修改提莫hp的目的，因为h离开作用域之后就无效了，并不能指向新的teemo对象
	}
}
