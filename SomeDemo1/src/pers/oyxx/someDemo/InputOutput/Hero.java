package pers.oyxx.someDemo.InputOutput;

import java.io.Serializable;

public class Hero implements Serializable {
	// ��ʾ����൱ǰ�İ汾��������˱仯����������������ԣ���Ӧ���޸�����汾��
	private static final long serialVersionUID = 1L;
	public String name;
	public float hp;
	
	/**
	 * @param Heroname
	 * 		Ӣ������
	 */
	public Hero(String Heroname){
		name=Heroname;
	}
	public Hero(){
		
	}
}