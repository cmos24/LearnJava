package pers.oyxx.someDemo.InterfaceandInherit;

public class ���ջ��Ʋ��� {
	public String name;
	protected float hp;

	public String toString() {
		return name;
	}

	public void finalize() {

		System.out.println("���Ӣ�����ڱ�����");
	}

	public static void main(String[] args) {
		// ֻ��һ����
		���ջ��Ʋ��� h;
		for (int i = 0; i < 1000; i++) {

			// ���������µĶ���
			// ÿ����һ������ǰһ�����󣬾�û������ָ����
			// ��Щ���󣬾������������յ�����
			// ���������ѻ��ıȽ϶��ʱ�򣬾ͻᴥ����������
			// һ��������󱻻��գ�����finalize()�����ͻᱻ����
			h = new ���ջ��Ʋ���();
		}

	}
}
