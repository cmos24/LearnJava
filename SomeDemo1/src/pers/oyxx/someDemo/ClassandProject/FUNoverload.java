package pers.oyxx.someDemo.ClassandProject;

// ��������
public class FUNoverload {
	public FUNoverload() {
		System.out.println("�����޲ι��캯��");
	}

	public FUNoverload(char c) {
		this();//���ù��캯��ֻ����this()�������ú�����,����ֻ���ڹ��캯���ĵ�һ���������
		System.out.println("�вι��캯��1:" + c);
	}

	public FUNoverload(String... c) {// �ɱ������Ĳ���,�ڷ�����,ʹ�ò�������ķ�ʽ����������
		System.out.println("�вι��캯��2:");
		for(int i=0;i<c.length;i++){
			System.out.print(" "+c[i]);
		}		
	}
	
}
