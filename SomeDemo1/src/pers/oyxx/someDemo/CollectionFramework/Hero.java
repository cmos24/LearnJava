package pers.oyxx.someDemo.CollectionFramework;

public class Hero implements Flag{
    public String name;
    public float hp;
 
    public int damage;
 
    public Hero() {
 
    }
 
    // ����һ����ʼ��name�Ĺ��췽��
    public Hero(String name) {
 
        this.name = name;
    }
 
    // ��дtoString����
    public String toString() {
        return name;
    }
 
}
