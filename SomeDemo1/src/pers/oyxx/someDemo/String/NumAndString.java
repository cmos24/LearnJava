package pers.oyxx.someDemo.String;

public class NumAndString {

	// �������� ת ��װ��
	public void BasetoClass() {
		int i = 24;
		Integer integer = new Integer(i);
		System.out.println("ת�����װ���ֵ=" + integer.intValue());
	}

	// ��װ�� ת ��������
	public void ClasstoBase() {
		Integer integer = new Integer(66);
		int i = integer.intValue();
		System.out.println("ת����������͵�ֵ=" + i);
	}

	// װ�����
	public void autoClassBase() {
		int i1 = 24;
		Integer integer1 = new Integer(0);
		integer1 = i1;// װ�䡪����������ֱ���Զ�ת���ɷ�װ��

		int i2 = 0;
		Integer integer2 = new Integer(66);
		i2 = integer2;// ���䡪����װ��ֱ���Զ�ת���ɻ�������
	}

	// int�����ֵ����Сֵ
	public void INTminmax() {
		System.out.println("int���ֵ" + Integer.MAX_VALUE);
		System.out.println("int��Сֵ" + Integer.MIN_VALUE);
	}

	// ���֡��ַ�����ת
	public void NUMtoString() {
		//����ת�ַ���
		int i1 = 24;
		String str1 = String.valueOf(i1);//����1��ʹ��String��ľ�̬����valueOf
		
		Integer integer1 =i1;
		String str2 =integer1.toString();//����2���Ƚ�intװ��Ϊ���󣬵���integer�����toString()����
		
		//�ַ���ת����
		String str3="66";
		int i2=Integer.parseInt(str3);//����Integer�ľ�̬����parseInt()
		
		//���������ַ�����ת
		double dou=3.14;
		String str4=String.valueOf(dou);
		String str5=Double.toString(dou);
		System.out.println("������ת�����ַ���="+str4+str5);
		
		dou=Double.parseDouble("3.14");
		System.out.println("�ַ���ת���ɸ�����="+dou);
		
		
	}
	
}
