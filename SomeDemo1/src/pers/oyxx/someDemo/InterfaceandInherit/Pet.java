package pers.oyxx.someDemo.InterfaceandInherit;

/*����UML�ഴ��pet������ӿ�
1. �ṩgetName() ���ظó��������
2. �ṩsetName(String name) Ϊ�ó�������
3. �ṩ play()����*/

public interface Pet {
	//Ϊ�ó�������
	void setName(String name);
	//���ظó�������
	String getName();
	
	void play();


}
