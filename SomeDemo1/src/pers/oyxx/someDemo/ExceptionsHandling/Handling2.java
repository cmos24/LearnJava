package pers.oyxx.someDemo.ExceptionsHandling;

/*���Կ������������ȡfinally�ķ���ֵ3.
ͬʱ�������method��Ƴɵ��� return1(),return2(),return3()�� 
���Թ۲쵽��try��� ���غ� finally�ķ��ض���ִ���˵ģ��������ѡ��ʹ��finally��ķ��ص�ֵ*/

//�쳣����2
public class Handling2 {

	public static void main(String[] args) {
		System.out.println(testMethod());
	}

	@SuppressWarnings("finally")
	public static int testMethod() {
		try {
			return return1();
		} catch (Exception e) {
			return return2();
		} finally {
			return return3();
		}
	}

	public static int return1() {
		System.out.println("����return1()");
		return 1;
	}

	public static int return2() {
		System.out.println("����return2()");
		return 2;
	}

	public static int return3() {
		System.out.println("����return3()");
		return 3;
	}
}
