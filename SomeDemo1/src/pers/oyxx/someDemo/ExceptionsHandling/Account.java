package pers.oyxx.someDemo.ExceptionsHandling;

//�����˻���
public class Account {
	protected double balance = 0;

	public Account(double balance) {
        this.balance = balance;
    }
	
	double getBalance() {
		return balance;
	}

	// ��Ǯ
	void deposit(double num) {
		balance += num;
		System.out.println("��ɹ�������" + num + "Ԫ���ʺ����Ϊ��" + balance + "Ԫ");
	}

	// ȡǮ
	void withdraw(double num) throws OverdraftExcetpion {
		if (balance < num) {
			throw new OverdraftExcetpion("�˺����㣡", (num - balance));
		}
		balance -= num;
		System.out.println("��ɹ�ȡ����" + num + "Ԫ���ʺ����Ϊ��" + balance + "Ԫ");
	}

	public static void main(String[] args) {
		Account a = new Account(100.5);// ����,����100.5
		a.deposit(100.5);// ����100.5
		System.out.println("�˺����Ϊ��" + a.getBalance() + "Ԫ");// �鿴�˻����
		try {
			a.withdraw(300);// ȡ300
		} catch (OverdraftExcetpion e) {
			System.err.println("͸֧��"+e.getDeficit());
			e.printStackTrace();
		}
	}

}
