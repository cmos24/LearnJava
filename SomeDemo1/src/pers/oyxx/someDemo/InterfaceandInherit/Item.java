package pers.oyxx.someDemo.InterfaceandInherit;

public abstract class Item {
	// ʹ�ú��Ƿ����ʧ
	public abstract boolean disposable();

	String name;

	public static void main(String[] args) {
		
		/*
		 * ����һ��Item��������
		 * 
		 * Item�г��󷽷�disposable()
		 */
		
		class LifePition extends Item {
			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return true;
			}
		}
		;

		class Weapon extends Item {
			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return false;
			}
		}
		;

		LifePition smallRed = new LifePition();
		Weapon electSword = new Weapon();
		System.out.println("����Ʒʹ�ú��Ƿ����ʧ��"+smallRed.disposable());
		System.out.println("����Ʒʹ�ú��Ƿ����ʧ��"+electSword.disposable());
	}// �����β
}
