package pers.oyxx.someDemo.InterfaceandInherit;

/*1. ����Animal�࣬�������ж���ĳ����ࡣ
2. ����һ���ܱ�����������������legs������¼������ȵ���Ŀ��
3. ����һ���ܱ����Ĺ�������������ʼ��legs���ԡ�
4. �������󷽷�eat��
5. �������巽��walk����ӡ������������ߵģ������ȵ���Ŀ����
*/

public abstract class AbstractAnimal {
	protected int legs;

	protected AbstractAnimal(int legs) {
		this.legs = legs;
	}

	public abstract void eat();
	
	public void walk(){
		System.out.println("��������");
	}
}
