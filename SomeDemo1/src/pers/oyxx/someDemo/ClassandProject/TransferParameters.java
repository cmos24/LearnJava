package pers.oyxx.someDemo.ClassandProject;

public class TransferParameters {
	String name; // 姓名

	public float hp; // 血量

	float armor; // 护甲

	int moveSpeed; // 移动速度

	public TransferParameters() {

	}

	// 回血
	public void huixue(int xp) {
		hp = hp + xp;
		// 回血完毕后，血瓶=0
		xp = 0;// 在方法内，无法修改方法外的基本类型参数，所以输入的“xueping”参数的值在执行这个函数之后并不会变成0
	}

	public TransferParameters(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

}
