import pers.oyxx.someDemo.ClassandProject.FUNoverload;
import pers.oyxx.someDemo.ClassandProject.HeroExample;
import pers.oyxx.someDemo.ClassandProject.TransferParameters;
import pers.oyxx.someDemo.ClassandProject.hungrySingleClass;
import pers.oyxx.someDemo.ClassandProject.lazySingleClass;
import pers.oyxx.someDemo.String.MyStringBuffer;

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

		// MyStringBuffer myStringBuffer = new MyStringBuffer("abc");
		// // myStringBuffer.append('d');
		// myStringBuffer.insert(0, "123");
		// System.out.println(new String(myStringBuffer.value));

		// ��������
		// FUNoverload fol1 = new FUNoverload();
		// FUNoverload fol2 = new FUNoverload('0');
		// FUNoverload fol3 = new FUNoverload("a", "b", "c");

		// �������Ͳ������䴫��
		// TransferParameters teemo = new TransferParameters("��Ī",383);
		// int xueping = 100;//Ѫƿ����ֵ��100
		// //��Īͨ�����Ѫƿ��Ѫ
		// teemo.huixue(xueping);
		// System.out.println(xueping);//����xueping��ֵ������0��Ϊ�ڷ����ڣ��޷��޸ķ�����Ļ������Ͳ������������Ĳ������˷������������ʧЧ��

		// �����Ͳ�������&���캯���͹�����ִ��˳�򣨹������ִ�У�
		// HeroExample teemo = new HeroExample("��Ī", 383);
		// HeroExample glren = new HeroExample();
		// teemo.hp = teemo.hp - 400; // �ܵ�400�˺�������
		// teemo.revive(teemo);// ����
		// System.out.println(teemo.hp); // ��û�б��383�����Ǽ���400֮�����ֵ
		// System.out.println(HeroExample.copyright);

		// ��������ģʽ
		hungrySingleClass hsc1 = hungrySingleClass.getinstance();
		hungrySingleClass hsc2 = hungrySingleClass.getinstance();
		System.out.println(hsc1 == hsc2);// ��������ָ��ͬһ����Ψһ�ģ���������true

		// ��������ģʽ
		lazySingleClass lsc1 = lazySingleClass.getInstance();
		lazySingleClass lsc2 = lazySingleClass.getInstance();
		System.out.println(lsc1 == lsc2);// ��������ָ��ͬһ����Ψһ�ģ���������true
	}

}
