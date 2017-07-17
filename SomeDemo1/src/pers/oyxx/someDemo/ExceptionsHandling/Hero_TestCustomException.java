package pers.oyxx.someDemo.ExceptionsHandling;

//测试自定义异常
public class Hero_TestCustomException {
	public String name;
	protected double hp;

	public String toString() {
		return name;
	}

	/*
	 * 在Hero的attack方法中，当发现敌方英雄的血量为0的时候，抛出该异常 1. 创建一个EnemyHeroIsDeadException实例
	 * 2. 通过throw 抛出该异常 3. 当前方法通过 throws 抛出该异常
	 * 
	 * 在外部调用attack方法的时候，就需要进行捕捉，并且捕捉的时候，可以通过e.getMessage() 获取当时出错的具体原因
	 */
	public void attackHero(Hero_TestCustomException h) throws CustomException {
		if (h.hp <= 0) {
			throw new CustomException(h.name + "已经死亡，不能攻击");
		}
	}

	public static void main(String[] args) {
		Hero_TestCustomException garen = new Hero_TestCustomException();
		garen.name = "Garen";
		garen.hp = 1000d;

		Hero_TestCustomException teemo = new Hero_TestCustomException();
		teemo.name = "Teemo";
		teemo.hp = 1000d;
		teemo.hp -= 1000d;// 将teemo的hp变为0

		try {
			garen.attackHero(teemo);
		} catch (CustomException e) {
			System.out.println("异常的具体原因:" + e.getMessage());
			e.printStackTrace();
		}

	}
}
