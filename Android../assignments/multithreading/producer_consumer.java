import java.util.*;
import java.lang.Thread;

class account {
	int balance =0;	
	boolean iscredit = false;

	public synchronized void credit(int num) {
		this.balance=num;
		if(iscredit) {
			try{wait();}catch(Exception e){};
		}
		System.out.println("balance credited : "+balance);
		iscredit =true;
		notify();
	}

	public synchronized void show(){
		if(!iscredit) {
			try{wait();}catch(Exception e){};
		}
		System.out.println("balance: "+ this.balance);
		iscredit = false;
		notify();
	}
}

class producer implements Runnable {
	account acc;
	public producer(account q) {
	this.acc = q;
	Thread t = new Thread(this);
	t.start();
	
	}
	public void run() {
		int i =0;
		while(true){
			acc.credit(i++);
			try{Thread.sleep(1000);}catch(Exception e){};

		}
	}
}

class consumer implements Runnable {
	account acc;
	public consumer(account q) {
		this.acc = q;
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		while(true) {
		acc.show();
		try{Thread.sleep(1000);}catch(Exception e){};
		}

	}
}



public class producer_consumer {
	public static void main(String[] args) {

	 account acc = new account();
	 new producer(acc);
	 new consumer(acc);
	}
}

