package pers.oyxx.someDemo.ClassandProject;

//��֤����黹�ǹ��캯����ִ�У�static���������������ʹ��
public class HeroExample {
	public static String copyright = "RIOT";
	
	static{
		copyright="���캯����ִ�У�������ִ��";
	}

	String name; // ����
	public float hp; // Ѫ��
	float armor; // ����
	int moveSpeed; // �ƶ��ٶ�

	public HeroExample() {
		copyright="�������ִ�У����캯����ִ��";
	}

	public HeroExample(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

	// ����
	public void revive(HeroExample h) {
		// h.hp=383f;//���������޸ĳɹ�
		h = new HeroExample("��Ī", 383);// ���ﲢ���ܴﵽ�޸���Īhp��Ŀ�ģ���Ϊh�뿪������֮�����Ч�ˣ�������ָ���µ�teemo����
	}
}
