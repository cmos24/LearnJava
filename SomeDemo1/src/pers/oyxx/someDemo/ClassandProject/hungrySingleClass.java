package pers.oyxx.someDemo.ClassandProject;

//����ʽ����ģʽ

/*GiantDragon Ӧ��ֻ��һֻ��ͨ��˽�л��乹�췽����ʹ���ⲿ�޷�ͨ��new �õ��µ�ʵ����
GiantDragon �ṩ��һ��public static��getInstance�������ⲿ������ͨ���÷���
��ȡ12�ж���Ķ��󣬶���ÿһ�ζ��ǻ�ȡͬһ������ �Ӷ��ﵽ������Ŀ�ġ����ֵ���ģʽ�ֽ�����
��ʽ����ģʽ��������ζ��ᴴ��һ��ʵ��*/
public class hungrySingleClass {
	// ˽�л����췽��ʹ�ø����޷����ⲿͨ��new ����ʵ����
	private hungrySingleClass() {

	}

	// ׼��һ�������ԣ�ָ��һ��ʵ�������� ��Ϊ�������ԣ�����ֻ��һ��
	private static hungrySingleClass instance = new hungrySingleClass();
	
	//public static �������ṩ�������߻�ȡ���涨��Ķ���
	public static hungrySingleClass getinstance(){
		return instance;
	}
}
