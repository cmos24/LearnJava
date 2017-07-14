package pers.oyxx.someDemo.InterfaceandInherit;

public class ADAPHero implements AD, AP {

	@Override
	public void magicAttack() {
		System.out.println("do magicAttack");
	}

	@Override
	public void physicAttack() {
		System.out.println("do physicAttack");
	}

}
