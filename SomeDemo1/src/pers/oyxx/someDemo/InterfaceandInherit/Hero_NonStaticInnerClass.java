package pers.oyxx.someDemo.InterfaceandInherit;

/*非静态内部类 BattleScore “战斗成绩”
非静态内部类可以直接在一个类里面定义
比如：
战斗成绩只有在一个英雄对象存在的时候才有意义
所以实例化BattleScore 的时候，必须建立在一个存在的英雄的基础上
语法: new 外部类().new 内部类()
作为Hero的非静态内部类，是可以直接访问外部类的private实例属性name的*/


//Hero类的非静态内部类版本
public class Hero_NonStaticInnerClass {
	private String name;
	float hp;
	float armor;
	int movespeed;

	// 非静态内部类，只有一个外部类对象存在的时候，才有意义
	// 战斗成绩只有在一个英雄对象存在的时候才有意义
	class BattleScore {
		int kill;
		int die;
		int assit;

		public void legendary() {
			if (kill >= 8)
				System.out.println(name + "超神！");
			else
				System.out.println(name + "还没超神！");
		}
	}

	public static void main(String[] args) {
		Hero_NonStaticInnerClass garen = new Hero_NonStaticInnerClass();
		garen.name = "盖伦";
		// 实例化内部类
		// BattleScore对象只有在一个英雄对象存在的时候才有意义
		// 所以其实例化必须建立在一个外部类对象的基础之上
		BattleScore score = garen.new BattleScore();
		score.kill = 9;
		score.legendary();

	}
}
