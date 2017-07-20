package pers.oyxx.someDemo.ExceptionsHandling;

//银行账户类
public class Account {
	protected double balance = 0;

	public Account(double balance) {
        this.balance = balance;
    }
	
	double getBalance() {
		return balance;
	}

	// 存钱
	void deposit(double num) {
		balance += num;
		System.out.println("你成功存入了" + num + "元，帐号余额为：" + balance + "元");
	}

	// 取钱
	void withdraw(double num) throws OverdraftExcetpion {
		if (balance < num) {
			throw new OverdraftExcetpion("账号余额不足！", (num - balance));
		}
		balance -= num;
		System.out.println("你成功取出了" + num + "元，帐号余额为：" + balance + "元");
	}

	public static void main(String[] args) {
		Account a = new Account(100.5);// 开户,存入100.5
		a.deposit(100.5);// 存了100.5
		System.out.println("账号余额为：" + a.getBalance() + "元");// 查看账户余额
		try {
			a.withdraw(300);// 取300
		} catch (OverdraftExcetpion e) {
			System.err.println("透支金额："+e.getDeficit());
			e.printStackTrace();
		}
	}

}
