package pers.oyxx.someDemo.InterfaceandInherit;

/*1. ����Fish�࣬���̳�Animal��
2. ��дAnimal��walk�����Ա����㲻������û���ȡ�
3. ʵ��Pet�ӿ�
4. �޲ι��췽��
5. �ṩһ��private ��name����*/

public class Fish extends AbstractAnimal implements Pet{
	private String name;	

	public Fish() {
		super(0);
	}

	public void walk(){
		System.out.println("�㲻���߶���û����");
	}
	
	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void play() {
		System.out.println("��ϲ����������");
	}

	@Override
	public void eat() {
		System.out.println("���С��");
	}
	
}
