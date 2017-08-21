package pers.oyxx.someDemo.CollectionFramework;

import java.util.LinkedList;

//��ϰ-�Զ���MyHashMap
public class MyHashMap implements IHashMap {
	/*
	 * ����ǰ��ѧϰ��hashcode��ԭ����Զ���hashcode, ���һ��MyHashMap��ʵ�ֽӿ�IHashMap
	 * 
	 * MyHashMap�ڲ���һ��������2000�Ķ�������ʵ�֡�
	 * 
	 * ���put(String key,Object value)����
	 * ����ͨ����һ���Զ����ַ�����hashcode��ϰ��ȡ�����ַ�����hashcode,Ȼ������hashcode��Ϊ�±꣬��λ�������ָ��λ�á�
	 * �����λ��û�����ݣ�����ַ����Ͷ�����ϳɼ�ֵ��Entry���ٴ���һ��LinkedList���Ѽ�ֵ�ԣ��Ž�LinkedList�У�
	 * ����LinkedList ���������λ�á�
	 * �����λ�������ݣ�һ����һ��LinkedList,����ַ����Ͷ�����ϳɼ�ֵ��Entry�����뵽LinkedList���档
	 * 
	 * ��� Object get(String key) ����
	 * ����ͨ����һ���Զ����ַ�����hashcode��ϰ��ȡ�����ַ�����hashcode,Ȼ������hashcode��Ϊ�±꣬��λ�������ָ��λ�á�
	 * ������λ��û�����ݣ��򷵻ؿ�
	 * ������λ�������ݣ��򰤸��Ƚ����м�ֵ�Եļ�-�ַ������Ƿ�equals���ҵ�ƥ��ģ��Ѽ�ֵ�Ե�ֵ�����س�ȥ���Ҳ���ƥ��ģ��ͷ��ؿ�
	 */

	public LinkedList<Entry>[] lls=new LinkedList[2001];
	
	@Override
	public void put(String key, Object object) {
		//��ȡ���ַ�����hashcode
		MyHashcode mhc= new MyHashcode();
		int hashcode=mhc.hashcode(key);
		//�����жϣ������ֵ�����ȴ���LinkedList�ٲ��뻹��ֱ�Ӳ������е�LinkedList
		Entry keyValue=new Entry(key,object);;
		if(null==lls[hashcode]){
			lls[hashcode]=new LinkedList<Entry>();
			lls[hashcode].add(keyValue);
		}else{
			//lls[hashcode].add(keyValue);
			for(int i=0;i<lls[hashcode].size();i++){
				//��ԭ�������ļ��ظ��ļ�ֵ���Ƴ��������µģ�ʵ��HashMap�ĸ��ǹ���
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
		//��ã���ֵ���ַ�����hashcode
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
	
	//��ʾMyHashMap�е�ȫ��Ԫ��
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
