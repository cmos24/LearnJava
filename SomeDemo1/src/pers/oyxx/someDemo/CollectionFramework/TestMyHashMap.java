package pers.oyxx.someDemo.CollectionFramework;

//�����Լ�д��MyHashMap
public class TestMyHashMap {

	public static void main(String[] args) {
		MyHashMap mhm=new MyHashMap();
		for(int i=0;i<10;i++){
			mhm.put("Hero"+i, new Hero("Ӣ��"+i));
		}
		//��һ���������ֵһ���ļ�ֵ�Բ����ܲ��ܸ������е�
		mhm.put("Hero6", new Hero("Hero6"));
		
		mhm.showAllElements();
		Hero h=(Hero) mhm.get("Hero6");
		System.out.println(h);
	}

}
