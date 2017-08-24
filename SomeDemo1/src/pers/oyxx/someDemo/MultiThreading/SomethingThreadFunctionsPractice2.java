package pers.oyxx.someDemo.MultiThreading;

//常用线程方法练习-英雄充能
public class SomethingThreadFunctionsPractice2 {
	/*
	 * 英雄有可以放一个技能叫做: 波动拳-a du gen。 每隔一秒钟，可以发一次，但是只能连续发3次。
	 * 
	 * 发完3次之后，需要充能5秒钟，充满，再继续发。
	 * 
	 * 借助本章节学习到的知识点，实现这个效果
	 */
	public static void main(String[] args) {
		Hero3 h=new Hero3();
		h.adugen();
	}

}
