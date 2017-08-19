package pers.oyxx.someDemo.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

//示例 1 : 二叉树概念
/*
 * 二叉树由各种节点组成 二叉树特点： 每个节点都可以有左子节点，右子节点 每一个节点都有一个值
 */

// 示例 2 : 二叉树排序-插入数据
/*
 * 假设通过二叉树对如下10个随机数进行排序 67,7,30,73,10,0,78,81,10,74 排序的第一个步骤是把数据插入到该二叉树中
 * 插入基本逻辑是，小、相同的放左边，大的放右边
 */
//二叉树
public class BinaryTree {
	// 左子节点
	public BinaryTree leftNode;
	// 右子节点
	public BinaryTree rightNode;
	// 值
	public Object value;

	// 插入数据
	public void add(Object v) {
		// 如果当前节点没有值，就把数据放在当前节点上
		if (null == value) {
			value = v;
			// 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
		} else { // 新增的值比当前值小或者相同
			if ((Integer) v - ((Integer) value) <= 0) {
				if (null == leftNode)
					leftNode = new BinaryTree();
				leftNode.add(v);
				
			} else { // 新增的值，比当前的值大
				if (null == rightNode)
					rightNode = new BinaryTree();
				rightNode.add(v);
				
			}
		}
	}

	// 示例 3 : 二叉树排序-遍历
	/*
	 * 通过上一个步骤的插入行为，实际上，数据就已经排好序了。 接下来要做的是看，把这些已经排好序的数据，遍历成我们常用的List或者数组的形式
	 */
	// 中序遍历所有的节点，把它们放进一个List或者数组中
	public List<Object> values() {
		List<Object> values = new ArrayList<Object>();
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
		int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };

		BinaryTree roots = new BinaryTree();
		for (int number : randoms) {
			roots.add(number);
		}
		System.out.println("二叉树创建成功");
		System.out.println(roots.values());

	}
}
