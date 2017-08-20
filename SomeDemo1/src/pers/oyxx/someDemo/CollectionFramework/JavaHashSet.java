package pers.oyxx.someDemo.CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;

//HashSet
public class JavaHashSet {

	public static void main(String[] args) {
		//示例 1 : 元素不能重复
		HashSet<String> hs=new HashSet<String>();
		hs.add("gareen");
		System.out.println(hs);
		
		//第二次插入同样的数据是放不进去的，容器只会保留一个
		hs.add("gareen");
		System.out.println(hs);
		
		
		//示例 2 : 没有顺序
		/*	Set中的元素，没有顺序。 
		严格的说，是没有按照元素的插入顺序排列
		HashSet的具体顺序，既不是按照插入顺序，也不是按照hashcode的顺序。*/
		/*以下是HasetSet源代码中的部分注释
		 /
		 * It makes no guarantees as to the iteration order of the set; 
		 * in particular, it does not guarantee that the order will remain constant over time. 
		 /
		不保证Set的迭代顺序; 确切的说，在不同条件下，元素的顺序都有可能不一样*/
		// 换句话说，同样是插入0-9到HashSet中， 在JVM的不同版本中，看到的顺序都是不一样的。 所以在开发的时候，不能依赖于某种臆测的顺序，这个顺序本身是不稳定的
		
		hs.clear();
		hs.add("1");
		hs.add("9");
		hs.add("5");
		// Set中的元素排列，不是按照插入顺序
		System.out.println(hs);
		
		//示例 3 : 遍历
		/*Set不提供get()来获取指定位置的元素 
		所以遍历需要用到迭代器，或者增强型for循环*/
		
		//遍历Set可以采用迭代器iterator
		System.out.println("采用迭代器iterator");
		for(Iterator<String> iterator=hs.iterator();iterator.hasNext();){
			String i=(String)iterator.next();
			System.out.println(i);
		}
		
		//或者采用增强型for循环
		System.out.println("采用增强型for循环");
		for(String i:hs){
			System.out.println(i);
		}
		
		//示例 4 : HashSet和HashMap的关系
		/*通过观察HashSet的源代码（如何查看源代码）
		可以发现HashSet自身并没有独立的实现，而是在里面封装了一个Map.
		HashSet是作为Map的key而存在的(所以不能重复)
		而value是一个命名为PRESENT的static的Object对象，因为是一个类属性，所以只会有一个。
 
		private static final Object PRESENT = new Object();*/
		
		
		
	}

}
