package javaproject;
import java.util.*;


class Account {
	static int amount = 0;
	synchronized void inout(String name, int money, String type){
		if (type.equals("입금")) 
			amount += money;
		 else if (type.equals("출금")) {
				 amount -= money;
		 }
		System.out.println(name + "이(가) " + money + "원 을 " + type + "했습니다. 잔액 : " + amount + "원");
	}
}

class Man extends Thread{
	Account abc;
	
	Man(Account p, String name) {
		super(name);
		abc = p;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			abc.inout(getName(), 1000, "입금");
			abc.inout(getName(), 100, "출금");
	}
}
}

public class Problem1 {
	public static void main(String[] args) {
		Account tongjang = new Account();
		Man m1 = new Man(tongjang, "김명지");
		Man m2 = new Man(tongjang, "홍은성");
		Man m3 = new Man(tongjang, "박상현");
		
	
			m1.start();
			m2.start();
			m3.start();
		
	}
}