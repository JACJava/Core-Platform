package com.pluralsight.CorePlatform;

public class Worker implements Runnable {
    private BankAccount account;

    public Worker(BankAccount account){
        this.account = account;
    }

    public void run() {

        int endBalance = 0;
        int startBalance = 0;

        for (int i = 0; i < 10; i++) {
            startBalance = account.getBalance();
            account.deposit(10);
            endBalance = account.getBalance();
            System.out.println("End Balance:  " + endBalance + "  Start Balance:  " + startBalance
                    + "  "+Thread.currentThread().getName());
        }
    }



}
