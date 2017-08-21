package pers.oyxx.someDemo.CollectionFramework;

//根据前面学习的hashcode的原理和自定义hashcode, 设计一个MyHashMap，实现接口IHashMap
public interface IHashMap {
	/**
	 * 添加键值对到MyHashMap中
	 * @param key
	 * 	键
	 * @param object
	 * 	值
	 */
	public void put(String key,Object object);
	
	/**
	 * 通过键名获取值
	 * @param key
	 * 	键
	 * @return
	 * 	键对应的值
	 */
	public Object get(String key);
}
