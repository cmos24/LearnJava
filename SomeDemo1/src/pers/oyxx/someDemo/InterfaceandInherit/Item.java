package pers.oyxx.someDemo.InterfaceandInherit;

public abstract class Item {
	// 使用后是否会消失
	public abstract boolean disposable();

	String name;

	public static void main(String[] args) {
		
		/*
		 * 创建一个Item的匿名类
		 * 
		 * Item有抽象方法disposable()
		 */
		
		class LifePition extends Item {
			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return true;
			}
		}
		;

		class Weapon extends Item {
			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return false;
			}
		}
		;

		LifePition smallRed = new LifePition();
		Weapon electSword = new Weapon();
		System.out.println("该物品使用后是否会消失？"+smallRed.disposable());
		System.out.println("该物品使用后是否会消失？"+electSword.disposable());
	}// 主类结尾
}
