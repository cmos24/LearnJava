package pers.oyxx.someDemo.CollectionFramework;

//MyHashMapµÄ¼üÖµ¶Ô
public class Entry {
	public Object key;
	public Object value;
	
	public Entry(Object key,Object value){
		super();
		this.key=key;
		this.value=value;
	}
	
	@Override
	public String toString(){
		return "[key="+key+",value="+value+"]";
	}
	
}
