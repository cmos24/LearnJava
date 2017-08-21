package pers.oyxx.someDemo.CollectionFramework;

import java.util.LinkedList;

//练习-自定义MyHashMap
public class MyHashMap implements IHashMap {
	/*
	 * 根据前面学习的hashcode的原理和自定义hashcode, 设计一个MyHashMap，实现接口IHashMap
	 * 
	 * MyHashMap内部由一个长度是2000的对象数组实现。
	 * 
	 * 设计put(String key,Object value)方法
	 * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
	 * 如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，
	 * 最后把LinkedList 保存在这个位置。
	 * 如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。
	 * 
	 * 设计 Object get(String key) 方法
	 * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
	 * 如果这个位置没有数据，则返回空
	 * 如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
	 */

	public LinkedList<Entry>[] lls=new LinkedList[2001];
	
	@Override
	public void put(String key, Object object) {
		//获取该字符串的hashcode
		MyHashcode mhc= new MyHashcode();
		int hashcode=mhc.hashcode(key);
		//进行判断，这个键值对是先创建LinkedList再插入还是直接插入已有的LinkedList
		Entry keyValue=new Entry(key,object);;
		if(null==lls[hashcode]){
			lls[hashcode]=new LinkedList<Entry>();
			lls[hashcode].add(keyValue);
		}else{
			//lls[hashcode].add(keyValue);
			for(int i=0;i<lls[hashcode].size();i++){
				//把原本与插入的键重复的键值对移除，插入新的，实现HashMap的覆盖功能
				Entry kv=lls[hashcode].get(i);
				if(key.equals(kv.key)){
					lls[hashcode].remove(i);
					lls[hashcode].add(keyValue);
				}
					
			}

		}
	}

	@Override
	public Object get(String key) {
		//获得（键值）字符串的hashcode
		MyHashcode mhc=new MyHashcode();
		int hashcode=mhc.hashcode(key);
		if(null!=lls[hashcode]){
			for(int i=0;i<lls[hashcode].size();i++){
				Entry kv=lls[hashcode].get(i);
				if(key.equals((String)kv.key)){
					return kv.value;
				}		
			}
		}
		return null;		
	}
	
	//显示MyHashMap中的全部元素
	public void showAllElements(){
		for(int i=0;i<lls.length;i++){
			if(null!=lls[i]){
				for(int j=0;j<lls[i].size();j++){
					System.out.println(lls[i].get(j));
				}				
			}
		}
	}
	
}
