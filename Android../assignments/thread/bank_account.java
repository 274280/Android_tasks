import java.util.*;

class bankaccount extends Thread {
	int balance =0;
	void deposit(int a) {
		balance+=a;
	}
	int withdrawl(int a) {
		if(balance!=0) 
			balance-=a;
			else
			System.out.println("Insufficient balance");
			
			return balance;
	}
}

public class bank_account {
	public static void main(String[] args) {
		bankaccount b1 = new bankaccount();
		bankaccount b2 = new bankaccount();

		b1.start();
		b2.start();
	}
}

