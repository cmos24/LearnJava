package pers.oyxx.someDemo.JavaReflect;

import java.lang.reflect.Method;

//���÷���
public class CallMethod {

	public static void main(String[] args) {
		/*���� 1 : ���÷���
		����ΪHero��name���ԣ�����setter��getter
		ͨ��������Ƶ���Hero��setName*/
		Hero2 h=new Hero2();
		
		try{
			//��ȡ�����Ľ���setName������������String�ķ���
			Method m=h.getClass().getMethod("setName", String.class);
			//��h���󣬵����������
			m.invoke(h, "����");
			//ʹ�ô�ͳ�ķ�ʽ������getName����
			System.out.println(h.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
