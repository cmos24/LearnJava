package pers.oyxx.someDemo.String;

public interface IStringBuffer {
	public void append(String str);// ׷���ַ���

	public void append(char c);// ׷���ַ�

	public void insert(int pos, String str);// ��ָ��λ�ò����ַ���

	public void insert(int pos, char c);// ��ָ��λ�ò����ַ�

	public void delete(int start); // �ӿ�ʼλ��ɾ��ʣ�µ�

	public void delete(int start, int end); // �ӿ�ʼλ��ɾ������λ��-1

	public void reverse(); // ��ת

	public int length(); // ���س���
}
