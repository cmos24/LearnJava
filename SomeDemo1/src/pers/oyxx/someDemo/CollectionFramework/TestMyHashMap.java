package pers.oyxx.someDemo.CollectionFramework;

//测试自己写的MyHashMap
public class TestMyHashMap {

	public static void main(String[] args) {
		MyHashMap mhm=new MyHashMap();
		for(int i=0;i<10;i++){
			mhm.put("Hero"+i, new Hero("英雄"+i));
		}
		//加一个和上面键值一样的键值对测试能不能覆盖已有的
		mhm.put("Hero6", new Hero("Hero6"));
		
		mhm.showAllElements();
		Hero h=(Hero) mhm.get("Hero6");
		System.out.println(h);
	}

}
