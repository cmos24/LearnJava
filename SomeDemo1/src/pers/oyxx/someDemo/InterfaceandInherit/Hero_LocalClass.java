package pers.oyxx.someDemo.InterfaceandInherit;

/*������������Ϊ�����ֵ������� 
���ڲ��಻һ�����ǣ��ڲ�����������ڳ�Ա��λ�ã��������Ժͷ���ƽ�ȵ�λ�á� 
�������������һ����ֱ�������ڴ�������棬��������������forѭ����ȵȵط�*/

//Hero��ı�����汾
public abstract class Hero_LocalClass {
	String name; // ����

	float hp; // Ѫ��

	float armor; // ����

	int moveSpeed; // �ƶ��ٶ�

	public abstract void attack();

	public static void main(String[] args) {
          
        //����������������ڣ������������Զ��������
    	class SomeHero extends Hero_LocalClass{

			@Override
			public void attack() {
				//�ⲻ���ڲ������Կ��Է��ʸ���ķ�final��Ա
    			System.out.println( name+ " new AttackType");				
			}
    	}
    	SomeHero h =new SomeHero();
    	h.name="�ز�ʦ";
    	h.attack();

    }
}
