import pers.oyxx.someDemo.Other.*;
import pers.oyxx.someDemo.String.*;
import pers.oyxx.someDemo.Array.*;

public class main {

	public static void main(String[] args) throws Exception {

		// //���5λ�����֤��
		// StringDemo stringdemo = new StringDemo();
		// String YanZhengMa=stringdemo.get5randomString();
		// System.out.println("��֤�룺"+YanZhengMa);
		// outputYZMpng.createImage(YanZhengMa,"C:/Users/pre/Desktop/��֤��.png");
		//
		// //���ַ������鰴����ĸ����
		// String[] randomStringGroup=stringdemo.getrandomStringGroup();
		// stringdemo.rankStringGroup(randomStringGroup);

		// �ӿ���̨�����������
		// OperationSymbol OS = new OperationSymbol();
		// //OS.add();
		// OS.TernaryOperator();

		// 1~20֮�����������Ļƽ�ָ���
		// ControlFlow CF=new ControlFlow();
		//// CF.getGoldenSectionNum(1,20);
		//// CF.getNarcissusNumber1();//�õ�ˮ�ɻ���
		// CF.getNarcissusNumber2();

		// �������������
		// pers.oyxx.someDemo.Array.sort Sort = new
		// pers.oyxx.someDemo.Array.sort();
		// // Sort.SelectionSort();// ѡ������
		// //Sort.BubbleSort();// ð������
		// Sort.forEX();

		// ��������
		// copy Copy = new copy();
		// //Copy.copyArray();
		// Copy.mergeRandomArrays();

		// ��������װ�����
		// NumAndString nas =new NumAndString();
		// nas.BasetoClass();//�ֶ� ��������ת��װ��
		// nas.ClasstoBase();//�ֶ� ��װ��ת��������
		// nas.INTminmax();//int���ֵ��Сֵ
		// nas.NUMtoString();//���ֺ��ַ�����ת

		// outputFormat opf = new outputFormat();
		// opf.outputFormatTest();// ��ʽ���
		// // opf.fillWords();

		MyStringBuffer myStringBuffer = new MyStringBuffer("abc");
		// myStringBuffer.append('d');
		myStringBuffer.insert(0, "123");
		System.out.println(new String(myStringBuffer.value));

	}

}
