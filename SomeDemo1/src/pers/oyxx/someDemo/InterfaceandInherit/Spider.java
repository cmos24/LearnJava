package pers.oyxx.someDemo.InterfaceandInherit;

/*1. Spider�̳�Animal�ࡣ
2. ����Ĭ�Ϲ������������ø��๹������ָ������֩�붼��8���ȡ�
3. ʵ��eat����*/

public class Spider extends AbstractAnimal{

	protected Spider() {
		super(8);
	}

	@Override
	public void eat() {
		System.out.println("֩�������");
	}

}
