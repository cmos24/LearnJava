package pers.oyxx.someDemo.InterfaceandInherit;

/*在匿名类中使用外部的局部变量，外部的局部变量必须修饰为final

为什么要声明为final，其机制比较复杂，请参考第二个Hero代码中的解释

注：在jdk8中，已经不需要强制修饰成final了，如果没有写final，不会报错，因为编译器偷偷的帮你加上了看不见的final*/

public abstract class AbstractHero_AnonymousClass2 {

	public abstract void attack();

	public static void main(String[] args) {

        //在匿名类中使用外部的局部变量damage 必须修饰为final
        int damage = 5;
         
        //这里使用本地类AnonymousHero来模拟匿名类的隐藏属性机制
         
        //事实上的匿名类，会在匿名类里声明一个damage属性，并且使用构造方法初始化该属性的值
        //在attack中使用的damage，真正使用的是这个内部damage，而非外部damage
         
        //假设外部属性不需要声明为final
        //那么在attack中修改damage的值，就会被暗示为修改了外部变量damage的值
         
        //但是他们俩是不同的变量，是不可能修改外部变量damage的
        //所以为了避免产生误导，外部的damage必须声明为final,"看上去"就不能修改了
        
        class AnonymousHero extends AbstractHero_AnonymousClass2{
        	int damage;
        	public AnonymousHero(int damage){
        		this.damage=damage;
        	}	
        	public void attack(){
        		System.out.printf("新的攻击方式，造成%d点伤害%n",damage);
        	}
        };
        
        AnonymousHero hero =new AnonymousHero(10);
        hero.attack();
        
	}
}