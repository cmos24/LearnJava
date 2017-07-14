package pers.oyxx.someDemo.ExceptionsHandling;

/*可以看到，最后结果是取finally的返回值3.
同时，故意把method设计成调用 return1(),return2(),return3()。 
可以观察到，try里的 返回和 finally的返回都是执行了的，不过最后选择使用finally里的返回的值*/

//异常处理2
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
		System.out.println("调用return1()");
		return 1;
	}

	public static int return2() {
		System.out.println("调用return2()");
		return 2;
	}

	public static int return3() {
		System.out.println("调用return3()");
		return 3;
	}
}
