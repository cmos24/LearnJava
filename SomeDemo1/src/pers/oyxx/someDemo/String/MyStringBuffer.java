package pers.oyxx.someDemo.String;

public class MyStringBuffer implements IStringBuffer {

	int capacity = 16;// 容量
	int length = 0;
	public char[] value;// 用于存放字符数组

	// 无参构造函数根据容量初始化value
	public MyStringBuffer() {
		value = new char[capacity];
	}

	// 有参构造方法
	public MyStringBuffer(String str) {
		this();
		if (null == str) {
			return;
		}
		if (capacity < str.length()) {
			capacity = value.length * 2;
			value = new char[capacity];// 这步很关键，因为原来的char[capacity]对象一旦创建，长度是不会跟着capacity变化的，要给value重新引用一个
		}
		if (capacity >= str.length()) {
			System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
		}
		length = str.length();
	}

	// 追加字符串
	@Override
	public void append(String str) {
		// 数组边界判断
		if ((str.length() + length) > capacity) {// 字符数组容量不够
			String src = value.toString();
			src += str;
			char[] temp = src.toCharArray();
			capacity = (str.length() + length) * 2;// 扩容
			value = new char[capacity];
			for (int i = 0; i < src.length(); i++) {
				value[i] = temp[i];
			}
		} else {// 字符数组容量足够
			char[] appendChar = str.toCharArray();
			for (int i = 0; i < str.length(); i++) {
				value[length + i] = appendChar[i];
			}
		}
		length += str.length();
	}

	// 追加字符
	@Override
	public void append(char c) {
		String c1 = Character.toString(c);
		insert(value.length-1, c1);
	}

	// 插入字符串
	@Override
	public void insert(int pos, String str) {
		String src1 = new String(value).substring(0, pos);
		String src2 = new String(value).substring(pos, value.length - 1);
		String src = src1.trim() + str + src2.trim();
		char[] temp = src.toCharArray();
		// 数组边界判断
		if ((length + str.length()) > capacity) {// 字符数组容量不够
			capacity = (str.length() + length) * 2;// 扩容
			value = new char[capacity];
		}
		for (int i = 0; i < src.length(); i++) {
			value[i] = temp[i];
		}
		length += str.length();
	}

	// 插入字符
	@Override
	public void insert(int pos, char c) {
		String c1 = Character.toString(c);
		insert(pos, c1);
	}

	@Override
	public void delete(int start) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int start, int end) {
		// TODO Auto-generated method stub

	}

	// 反转
	@Override
	public void reverse() {
		char temp;
		for (int i = 0; i < (value.length / 2); i++) {
			temp = value[i];
			value[i] = value[value.length - i - 1];// 因为数组计算从0开始，不减1会越界
			value[value.length - i - 1] = temp;
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

}
