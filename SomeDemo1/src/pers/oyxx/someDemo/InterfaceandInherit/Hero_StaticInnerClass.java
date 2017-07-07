package pers.oyxx.someDemo.InterfaceandInherit;

/*��һ������������һ����̬�ڲ���
����з�ˮ�������з�ˮ��û��Ѫ��ʱ�򣬼�������Ӣ�۶�ȡ��ʤ��������ֻ��ĳһ�������Ӣ��ȡ��ʤ����
��Ǿ�̬�ڲ��಻ͬ����̬�ڲ���ˮ�����ʵ���� ����Ҫһ���ⲿ���ʵ��Ϊ����������ֱ��ʵ����
�﷨��new �ⲿ��.��̬�ڲ���();
��Ϊû��һ���ⲿ���ʵ���������ھ�̬�ڲ������治���Է����ⲿ���ʵ�����Ժͷ���
���˿��Է����ⲿ���˽�о�̬��Ա�⣬��̬�ڲ������ͨ��ûʲô�������*/

//Hero�ľ�̬�ڲ���汾
public class Hero_StaticInnerClass {
	public static String name;
	protected float hp;

	private static void battleWin() {
		System.out.println("battle win");
	}

	// �з���ˮ��
	static class EnemyCrystal {
		int hp = 5000;

		// ���ˮ����Ѫ��Ϊ0��������ʤ��
		public void checkIfVictory() {
			if (hp == 0) {
				Hero_StaticInnerClass.battleWin();

				// ��̬�ڲ��಻��ֱ�ӷ����ⲿ��Ķ�������,��̬��Ա����
				System.out.println(name + " win this game");
			}
		}
	}
	
	public static void main(String[] args){
		//ʵ������̬�ڲ���
		Hero_StaticInnerClass.EnemyCrystal crystal=new Hero_StaticInnerClass.EnemyCrystal();
		crystal.checkIfVictory();
	}
}
