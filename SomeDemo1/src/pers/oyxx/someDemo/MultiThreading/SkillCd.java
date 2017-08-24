package pers.oyxx.someDemo.MultiThreading;

//技能cd
public class SkillCd implements Runnable{
	public int cdTime;
	/**
	 * 技能经过一段时间（秒）后冷却完毕
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
