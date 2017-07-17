package pers.oyxx.someDemo.ExceptionsHandling;

//�����Զ����쳣
public class Hero_TestCustomException {
	public String name;
	protected double hp;

	public String toString() {
		return name;
	}

	/*
	 * ��Hero��attack�����У������ֵз�Ӣ�۵�Ѫ��Ϊ0��ʱ���׳����쳣 1. ����һ��EnemyHeroIsDeadExceptionʵ��
	 * 2. ͨ��throw �׳����쳣 3. ��ǰ����ͨ�� throws �׳����쳣
	 * 
	 * ���ⲿ����attack������ʱ�򣬾���Ҫ���в�׽�����Ҳ�׽��ʱ�򣬿���ͨ��e.getMessage() ��ȡ��ʱ����ľ���ԭ��
	 */
	public void attackHero(Hero_TestCustomException h) throws CustomException {
		if (h.hp <= 0) {
			throw new CustomException(h.name + "�Ѿ����������ܹ���");
		}
	}

	public static void main(String[] args) {
		Hero_TestCustomException garen = new Hero_TestCustomException();
		garen.name = "Garen";
		garen.hp = 1000d;

		Hero_TestCustomException teemo = new Hero_TestCustomException();
		teemo.name = "Teemo";
		teemo.hp = 1000d;
		teemo.hp -= 1000d;// ��teemo��hp��Ϊ0

		try {
			garen.attackHero(teemo);
		} catch (CustomException e) {
			System.out.println("�쳣�ľ���ԭ��:" + e.getMessage());
			e.printStackTrace();
		}

	}
}
