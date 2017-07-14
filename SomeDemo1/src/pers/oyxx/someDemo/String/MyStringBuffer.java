package pers.oyxx.someDemo.String;

public class MyStringBuffer implements IStringBuffer {

	int capacity = 16;// ����
	int length = 0;
	public char[] value;// ���ڴ���ַ�����

	// �޲ι��캯������������ʼ��value
	public MyStringBuffer() {
		value = new char[capacity];
	}

	// �вι��췽��
	public MyStringBuffer(String str) {
		this();
		if (null == str) {
			return;
		}
		if (capacity < str.length()) {
			capacity = value.length * 2;
			value = new char[capacity];// �ⲽ�ܹؼ�����Ϊԭ����char[capacity]����һ�������������ǲ������capacity�仯�ģ�Ҫ��value��������һ��
		}
		if (capacity >= str.length()) {
			System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
		}
		length = str.length();
	}

	// ׷���ַ���
	@Override
	public void append(String str) {
		// ����߽��ж�
		if ((str.length() + length) > capacity) {// �ַ�������������
			String src = value.toString();
			src += str;
			char[] temp = src.toCharArray();
			capacity = (str.length() + length) * 2;// ����
			value = new char[capacity];
			for (int i = 0; i < src.length(); i++) {
				value[i] = temp[i];
			}
		} else {// �ַ����������㹻
			char[] appendChar = str.toCharArray();
			for (int i = 0; i < str.length(); i++) {
				value[length + i] = appendChar[i];
			}
		}
		length += str.length();
	}

	// ׷���ַ�
	@Override
	public void append(char c) {
		String c1 = Character.toString(c);
		insert(value.length-1, c1);
	}

	// �����ַ���
	@Override
	public void insert(int pos, String str) {
		String src1 = new String(value).substring(0, pos);
		String src2 = new String(value).substring(pos, value.length - 1);
		String src = src1.trim() + str + src2.trim();
		char[] temp = src.toCharArray();
		// ����߽��ж�
		if ((length + str.length()) > capacity) {// �ַ�������������
			capacity = (str.length() + length) * 2;// ����
			value = new char[capacity];
		}
		for (int i = 0; i < src.length(); i++) {
			value[i] = temp[i];
		}
		length += str.length();
	}

	// �����ַ�
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

	// ��ת
	@Override
	public void reverse() {
		char temp;
		for (int i = 0; i < (value.length / 2); i++) {
			temp = value[i];
			value[i] = value[value.length - i - 1];// ��Ϊ��������0��ʼ������1��Խ��
			value[value.length - i - 1] = temp;
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

}
