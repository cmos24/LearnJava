package pers.oyxx.someDemo.InterfaceandInherit;

/*1. ����������String���������������֡�
2. ����һ������������ʹ��String����ָ��è�����֣��ù�����������ó��๹������ָ�����е�è����4���ȡ�
3. ����һ���޲εĹ��������ù���������ǰһ������������this�ؼ��֣�������һ�����ַ�����Ϊ����
4. ʵ��Pet�ӿڷ�����
5. ʵ��eat������*/

public class Cat extends AbstractAnimal implements Pet {
	public String petName;

	public Cat() {
		this("");
	}

	public Cat(String petName) {
		super(4);
		this.petName = petName;
	}

	public void setName(String petName) {
		this.petName = petName;
	}

	public String getName() {
		return this.petName;
	}

	public void play() {
		System.out.println("èϲ��������");
	}

	public void eat() {
		System.out.println("è��è��");
	}
}
