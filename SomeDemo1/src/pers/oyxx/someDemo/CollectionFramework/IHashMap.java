package pers.oyxx.someDemo.CollectionFramework;

//����ǰ��ѧϰ��hashcode��ԭ����Զ���hashcode, ���һ��MyHashMap��ʵ�ֽӿ�IHashMap
public interface IHashMap {
	/**
	 * ��Ӽ�ֵ�Ե�MyHashMap��
	 * @param key
	 * 	��
	 * @param object
	 * 	ֵ
	 */
	public void put(String key,Object object);
	
	/**
	 * ͨ��������ȡֵ
	 * @param key
	 * 	��
	 * @return
	 * 	����Ӧ��ֵ
	 */
	public Object get(String key);
}
