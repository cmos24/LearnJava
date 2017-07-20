package pers.oyxx.someDemo.ExceptionsHandling;

import java.nio.channels.OverlappingFileLockException;

//支票账户，拥有透支额度
public class CheckingAccount extends Account {
	private double overdraftProtection = 0;// 透支额度

	public CheckingAccount(double balance) {
		super(balance);
		this.balance = balance;
		System.out.println("父类的balance=" + super.balance);
	}

	public CheckingAccount(double balance, double overdraftProtection) {
		super(balance);
		this.overdraftProtection = overdraftProtection;
		System.out.println("父类的balance=" + (this.balance));
		// System.out.println("父类的balance=" +
		// (this.balance));//如果上面有定义balance的话这里会显示为0，父类的balance才会显示1000
		// System.out.println("父类的balance=" +
		// (super.balance==this.balance));//如果子类有定义balance，这样写的会发现父类的balance和子类的balance并不是同一个
	}

	// 取钱
	public void withdraw(double amt) throws OverdraftExcetpion {
		if ((this.balance + overdraftProtection) < amt) {
			double deficit = amt - (this.balance + overdraftProtection);
			throw new OverdraftExcetpion("余额不足", deficit);
		}
		this.balance -= amt;
		System.out.println("你成功取出了：" + amt + "元，当前余额为：" + this.balance);
	}

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount(1000, 500);// 开户存入1000元，拥有500元的透支额度
		ca.deposit(1000);// 存入1000
		System.out.println(ca.getBalance());
		try {
			ca.withdraw(600);
			System.out.println(ca.getBalance());
			ca.withdraw(600);
			System.out.println(ca.getBalance());
			ca.withdraw(600);
			System.out.println(ca.getBalance());
			ca.withdraw(600);
			System.out.println(ca.getBalance());
			ca.withdraw(600);
			System.out.println(ca.getBalance());
		} catch (OverdraftExcetpion e) {
			System.err.println("透支超额:" + e.getDeficit());
			e.printStackTrace();
		}
	}
}
