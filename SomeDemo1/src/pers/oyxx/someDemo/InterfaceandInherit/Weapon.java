package pers.oyxx.someDemo.InterfaceandInherit;

public class Weapon extends Item {

	@Override
	public boolean disposable() {
		// 装备使用后不会消失
		return false;
	}

}
