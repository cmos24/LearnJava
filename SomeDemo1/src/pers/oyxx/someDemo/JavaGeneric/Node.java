package pers.oyxx.someDemo.JavaGeneric;

import java.util.ArrayList;
import java.util.List;

//支持泛型的二叉树——把二叉树中的Node类，改造成支持泛型
public class Node<T> {
	public Node<T> leftNode;// 左子节点
	public Node<T> rightNode;// 右子节点
	public T value;// 值

	// 插入数据
	public void add(T t) {
		// 如果节点没有值就赋值给这个节点
		if (null == value) {
			value = t;
		} else {
			// 如果节点有值，判断插入的值和节点的值哪个大
			if ((Integer) t <= (Integer) value) {
				if (null == leftNode)
					leftNode = new Node<T>();
				leftNode.add(t);
			} else {
				if (null == rightNode) {
					rightNode = new Node<T>();
					rightNode.add(t);
				}
			}
		}
	}

	// 中序遍历所有节点
	public List<T> values() {
		List<T> values = new ArrayList<>();
		// 左节点的遍历结果
		if (null != leftNode) {
			values.addAll(leftNode.values());
		}
		// 当前节点
		values.add(value);
		// 右节点的遍历结果
		if (null != rightNode) {
			values.addAll(rightNode.values());
		}
		return values;
	}

	public static void main(String[] args) {
		int[] randoms = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
		Node<Integer> root = new Node<Integer>();
		for (int number : randoms) {
			root.add(number);
		}
		System.out.println(root.values());

		/*
		 * 但是这样的泛型有个弊端，在比较的时候，泛型T被转换为了Integer进行大小比较。换句话说，如果写成非Integer泛型，
		 * 就会出现类型转换异常
		 * 
		 * new Node<Hero>
		 * 
		 * 
		 * 这个问题的解决，需要用到后面的 ? extends模式
		 */

	}
}
