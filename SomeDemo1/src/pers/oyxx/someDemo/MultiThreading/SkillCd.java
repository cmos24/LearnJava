package pers.oyxx.someDemo.MultiThreading;

//����cd
public class SkillCd implements Runnable{
	public int cdTime;
	/**
	 * ���ܾ���һ��ʱ�䣨�룩����ȴ���
	 * @param cdTime
	 */
	public SkillCd(int cdTime){
		this.cdTime=cdTime;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(cdTime*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
