package com.ocpexamples.threads;

public class AccountDanger implements Runnable {

    private Account account = new Account();

    public static void main(String args[]) {
	AccountDanger accountDanger = new AccountDanger();
	Thread t1 = new Thread(accountDanger, "Fred1");
	Thread t2 = new Thread(accountDanger, "Lucy");
	t1.start();
	t2.start();
    }

    public void run() {
	for (int i = 0; i < 5; i++) {
	    makeWithdrawal(10);
	    if (account.getBalance() < 0) {
		System.out.println("Account is overdrawn!!! ");
	    }
	}
    }

    private synchronized void  makeWithdrawal(int amount) {
	if (account.getBalance() >= amount) {
	    System.out.println(Thread.currentThread().getName() + " is going to withdraw");
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    }

	    account.withdraw(amount);
	    System.out.println(Thread.currentThread().getName() + " completes withdrawal");
	} else {
	    System.out.println("Not enough amount of money in the account for " + Thread.currentThread().getName()
		    + " to withdraw " + account.getBalance());
	}
    }
}