package com.pluralsight.CorePlatform;

public final class HighVolumeAccount extends BankAccount implements Runnable {

    // constructor that sets initial state of the object

    // constructor that accepts just the id
    public HighVolumeAccount(String id) {super(id);}

    // constructor that accepts just the id and the starting balance
    public HighVolumeAccount(String id, int balance) {super (id, balance);}


    private int[] readDailyDeposits() {
        return new int[]{100,100,100}; //stub to get thru lesson, would have to read from a database if real
    }

    private int[] readDailyWithdrawals() {
        return new int[]{10,10,10}; //stub to get thru lesson, would have to read from a database if real
    }

    public void run() {
        for(int depositAmt:readDailyDeposits())
            deposit(depositAmt);

        for(int withdrawalAmt:readDailyWithdrawals())
            withdrawal(withdrawalAmt);

        System.out.println("Account Number:  " + getId()
                + "  Balance:  "+ getBalance()
                + "  "+Thread.currentThread().getName());



    }



}
