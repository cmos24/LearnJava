package pers.oyxx.someDemo.ExceptionsHandling;

import java.nio.channels.OverlappingFileLockException;

//֧Ʊ�˻���ӵ��͸֧���
public class CheckingAccount extends Account {
	private double overdraftProtection = 0;// ͸֧���

	public CheckingAccount(double balance) {
		super(balance);
		this.balance = balance;
		System.out.println("�����balance=" + super.balance);
	}

	public CheckingAccount(double balance, double overdraftProtection) {
		super(balance);
		this.overdraftProtection = overdraftProtection;
		System.out.println("�����balance=" + (this.balance));
		// System.out.println("�����balance=" +
		// (this.balance));//��������ж���balance�Ļ��������ʾΪ0�������balance�Ż���ʾ1000
		// System.out.println("�����balance=" +
		// (super.balance==this.balance));//��������ж���balance������д�Ļᷢ�ָ����balance�������balance������ͬһ��
	}

	// ȡǮ
	public void withdraw(double amt) throws OverdraftExcetpion {
		if ((this.balance + overdraftProtection) < amt) {
			double deficit = amt - (this.balance + overdraftProtection);
			throw new OverdraftExcetpion("����", deficit);
		}
		this.balance -= amt;
		System.out.println("��ɹ�ȡ���ˣ�" + amt + "Ԫ����ǰ���Ϊ��" + this.balance);
	}

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount(1000, 500);// ��������1000Ԫ��ӵ��500Ԫ��͸֧���
		ca.deposit(1000);// ����1000
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
			System.err.println("͸֧����:" + e.getDeficit());
			e.printStackTrace();
		}
	}
}
