package pers.oyxx.someDemo.InterfaceandInherit;

public class LifePotion extends Item {

	@Override
	public boolean disposable() {
		// 消耗品使用后会消失
		return true;
	}

}
