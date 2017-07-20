package pers.oyxx.someDemo.ExceptionsHandling;

public class OverdraftExcetpion extends Exception {
	private double deficit = 0;// Í¸Ö§½ð¶î

	public double getDeficit() {
		return deficit;
	}

	public OverdraftExcetpion(String msg, double deficit) {
		super(msg);
		this.deficit = deficit;
	}
}
