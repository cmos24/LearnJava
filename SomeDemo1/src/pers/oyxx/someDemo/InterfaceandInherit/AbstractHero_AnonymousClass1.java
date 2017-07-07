package pers.oyxx.someDemo.InterfaceandInherit;

/*在匿名类中使用外部的局部变量，外部的局部变量必须修饰为final

为什么要声明为final，其机制比较复杂，请参考第二个Hero代码中的解释

注：在jdk8中，已经不需要强制修饰成final了，如果没有写final，不会报错，因为编译器偷偷的帮你加上了看不见的final*/

public abstract class AbstractHero_AnonymousClass1 {

	public abstract void attack();

	public static void main(String[] args) {
		//在匿名类中使用外部的局部变量，外部的局部变量必须修饰为final
        final int damage = 5;
        
        AbstractHero_AnonymousClass1 hero =new AbstractHero_AnonymousClass1(){
        	public void attack(){
        		System.out.printf("新的攻击方式，造成%d点伤害%n",damage);
        	}
        };
	}
}
