package pers.oyxx.someDemo.InterfaceandInherit;

public class ADHero extends Hero implements AD {
	/*
	 * ��Ϊ���࣬������� ������ø���Ĺ��췽���� Ĭ������£�����ø�����޲εĹ��췽���� ���ǣ�������û���޲ι��췽��
	 * ��ʱ��(�ṩ���вι��췽�������Ҳ���ʾ�ṩ�޲ι��췽��)������ͻ��׳��쳣����Ϊ������ȥ���ø�����޲ι��췽����
	 * ���ʱ�򣬱���ͨ��superȥ���ø��������ģ����ڵģ��вεĹ��췽��
	 */
	public ADHero() {
		super("");
		System.out.println("ADHero���޲ι��췽��");
	}

	public ADHero(String str) {
		super(str);// ����Ĺ��캯�������������Ĺ��캯����һ��
		System.out.println("ADHero��һ���вι��췽��" + str);
	}

	@Override
	public void physicAttack() {
		System.out.println("do physicAttack");
	}

	// ���ø�������
	public String getName0() {
		return super.name;
	}

	public String getName1() {
		return this.name;
	}

}
