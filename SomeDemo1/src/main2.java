import pers.oyxx.someDemo.InterfaceandInherit.*;

public class main2 {
	public static void main(String[] arg) {
		// new ADHero();// ���ȵ��ø�����޲ι��췽���ٵ���������޲ι��췽��
		// Hero h = new ADHero("abc");//
		// �ȵ��ø�����޲ι��췽���ٵ�������Ķ�Ӧ�вι��췽����Ҫ���ø����ĳ���вι��췽��Ҫ�������Ӧ���вι��췽������super()����������
		// System.out.println(h.toString());// �����඼�̳���Object������toString()����

		// ֻ��һ����
		// Hero hero;
		// for (int i = 0; i < 10000; i++) {
		//
		// // ���������µĶ���
		// // ÿ����һ������ǰһ�����󣬾�û������ָ����
		// // ��Щ���󣬾������������յ�����
		// // ���������ѻ��ıȽ϶��ʱ�򣬾ͻᴥ����������
		// // һ��������󱻻��գ�����finalize()�����ͻᱻ����
		// hero = new Hero();//������д��finalize()Ϊʲôû��ִ��?
		// }

		REWriteSuperFun resf = new REWriteSuperFun();
		resf.equals();//��дequals()����
		System.out.println(resf.toString());//��дtoString()����

		LifePotion BigRed = new LifePotion();
		if(true==BigRed.disposable()){
			System.out.println("BigRed������Ʒ��ʹ�ú����ʧ");
		}
		Weapon ElecSword = new Weapon();
		if(false==ElecSword.disposable()){
			System.out.println("ElecSword��������Ʒ��ʹ�ú󲻻���ʧ");
		}


	}// main����β��
}
