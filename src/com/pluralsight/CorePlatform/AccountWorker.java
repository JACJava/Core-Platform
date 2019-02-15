package com.pluralsight.CorePlatform;

public class AccountWorker implements Runnable {

    BankAccount ba;
    HighVolumeAccount hva;

    protected char txType; //'w' -> withdrawal, 'd' -> deposit
    protected int amt;


    // constructor that sets initial state of the object
    public AccountWorker (BankAccount ba) {
        this.ba = ba; //right hand is the parameter, left hand is the field
    }
    public AccountWorker (HighVolumeAccount hva) {
        this.hva = hva; //right hand is the parameter, left hand is the field
    }

    public AccountWorker (BankAccount ba, char txType, int amt) {
        this.ba = ba; //right hand is the parameter, left hand is the field
        this.txType = txType;
        this.amt = amt;
    }


    public void doWork() {

        Thread t = new Thread(hva != null ? hva : this);
        t.start();
    }


    public void run() {

        int endBalance = 0;
        int startBalance = 0;

        startBalance = ba.getBalance();

        if (txType == 'w') {
            ba.withdrawal(amt);  //both are synchronized methods
        }
        else if (txType == 'd') {
            ba.deposit(amt);
        }

        endBalance = ba.getBalance();

        System.out.println("Account Number:  " + ba.getId()
                + "  Transaction Type:  "+ txType
                + "  Start Balance:  " + startBalance
                + "  End Balance:  " + endBalance
                + "  "+Thread.currentThread().getName());

    }



}
