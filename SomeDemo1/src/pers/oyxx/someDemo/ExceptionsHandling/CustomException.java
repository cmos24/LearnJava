package pers.oyxx.someDemo.ExceptionsHandling;

/*һ��Ӣ�۹�����һ��Ӣ�۵�ʱ�����������һ��Ӣ���Ѿ����ˣ��ͻ��׳�EnemyHeroIsDeadException
����һ����EnemyHeroIsDeadException�����̳�Exception
�ṩ�������췽��
1. �޲εĹ��췽��
2. ���εĹ��췽���������ø���Ķ�Ӧ�Ĺ��췽��*/

//�Զ����쳣
public class CustomException extends Exception{
	public CustomException(){
		
	}
	public CustomException(String msg){
		super(msg);
	}
}
