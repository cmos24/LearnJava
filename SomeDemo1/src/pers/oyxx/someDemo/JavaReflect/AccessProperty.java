package pers.oyxx.someDemo.JavaReflect;

import java.lang.reflect.Field;

//��������-ͨ����������޸Ķ��������
public class AccessProperty {

	public static void main(String[] args) {
		Hero1 h=new Hero1();
		//ʹ�ô�ͳ��ʽ�޸�name��ֵΪgareen
		h.setName("gareen");
		
		try {
			//��ȡ��Hero1�Ľ�name���ֶ�
			Field f1=h.getClass().getDeclaredField("name");//getDeclaredField�ǿ��Ի�ȡһ����������ֶ�.getFieldֻ�ܻ�ȡ���public �ֶ�.
			//�޸�����ֶε�ֵ
			f1.setAccessible(true);//name��private���εģ���� f1.setAccessible(true);�������ÿ�д
			f1.set(h, "teemo");
			//��ӡ���޸ĺ��ֵ
			System.out.println(h.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*getField��getDeclaredField������
		�����������������ڻ�ȡ�ֶ�
		getField ֻ�ܻ�ȡpublic�ģ������Ӹ���̳������ֶΡ�
		getDeclaredField ���Ի�ȡ�������е��ֶΣ�����private�ģ����ǲ��ܻ�ȡ�̳������ֶΡ�
		(ע�� ����ֻ�ܻ�ȡ��private���ֶΣ��������ܷ��ʸ�private�ֶε�ֵ,���Ǽ���setAccessible(true))*/
		
//		private�ɶ� ,����д�ǿ϶��ģ�ֻ����� f1.setAccessible(true);�������ÿ�д
	}

}
