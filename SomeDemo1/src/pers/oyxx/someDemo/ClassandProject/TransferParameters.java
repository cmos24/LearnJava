package pers.oyxx.someDemo.ClassandProject;

public class TransferParameters {
	String name; // ����

	public float hp; // Ѫ��

	float armor; // ����

	int moveSpeed; // �ƶ��ٶ�

	public TransferParameters() {

	}

	// ��Ѫ
	public void huixue(int xp) {
		hp = hp + xp;
		// ��Ѫ��Ϻ�Ѫƿ=0
		xp = 0;// �ڷ����ڣ��޷��޸ķ�����Ļ������Ͳ�������������ġ�xueping��������ֵ��ִ���������֮�󲢲�����0
	}

	public TransferParameters(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

}
