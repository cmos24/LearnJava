import pers.oyxx.someDemo.InterfaceandInherit.*;

public class main2 {
	public static void main(String[] arg) {
		// new ADHero();// 会先调用父类的无参构造方法再调用子类的无参构造方法
		// Hero h = new ADHero("abc");//
		// 先调用父类的无参构造方法再调用子类的对应有参构造方法，要调用父类的某个有参构造方法要在子类对应的有参构造方法中用super()对象来调用
		// System.out.println(h.toString());// 所有类都继承自Object，都有toString()方法

		// 只有一引用
		// Hero hero;
		// for (int i = 0; i < 10000; i++) {
		//
		// // 不断生成新的对象
		// // 每创建一个对象，前一个对象，就没有引用指向了
		// // 那些对象，就满足垃圾回收的条件
		// // 当，垃圾堆积的比较多的时候，就会触发垃圾回收
		// // 一旦这个对象被回收，它的finalize()方法就会被调用
		// hero = new Hero();//这里重写的finalize()为什么没有执行?
		// }

		REWriteSuperFun resf = new REWriteSuperFun();
		resf.equals();//重写equals()方法
		System.out.println(resf.toString());//重写toString()方法

		LifePotion BigRed = new LifePotion();
		if(true==BigRed.disposable()){
			System.out.println("BigRed是消耗品，使用后会消失");
		}
		Weapon ElecSword = new Weapon();
		if(false==ElecSword.disposable()){
			System.out.println("ElecSword不是消耗品，使用后不会消失");
		}


	}// main函数尾部
}
