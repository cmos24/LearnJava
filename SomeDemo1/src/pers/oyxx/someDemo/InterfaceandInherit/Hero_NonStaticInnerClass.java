package pers.oyxx.someDemo.InterfaceandInherit;

/*�Ǿ�̬�ڲ��� BattleScore ��ս���ɼ���
�Ǿ�̬�ڲ������ֱ����һ�������涨��
���磺
ս���ɼ�ֻ����һ��Ӣ�۶�����ڵ�ʱ���������
����ʵ����BattleScore ��ʱ�򣬱��뽨����һ�����ڵ�Ӣ�۵Ļ�����
�﷨: new �ⲿ��().new �ڲ���()
��ΪHero�ķǾ�̬�ڲ��࣬�ǿ���ֱ�ӷ����ⲿ���privateʵ������name��*/


//Hero��ķǾ�̬�ڲ���汾
public class Hero_NonStaticInnerClass {
	private String name;
	float hp;
	float armor;
	int movespeed;

	// �Ǿ�̬�ڲ��ֻ࣬��һ���ⲿ�������ڵ�ʱ�򣬲�������
	// ս���ɼ�ֻ����һ��Ӣ�۶�����ڵ�ʱ���������
	class BattleScore {
		int kill;
		int die;
		int assit;

		public void legendary() {
			if (kill >= 8)
				System.out.println(name + "����");
			else
				System.out.println(name + "��û����");
		}
	}

	public static void main(String[] args) {
		Hero_NonStaticInnerClass garen = new Hero_NonStaticInnerClass();
		garen.name = "����";
		// ʵ�����ڲ���
		// BattleScore����ֻ����һ��Ӣ�۶�����ڵ�ʱ���������
		// ������ʵ�������뽨����һ���ⲿ�����Ļ���֮��
		BattleScore score = garen.new BattleScore();
		score.kill = 9;
		score.legendary();

	}
}
