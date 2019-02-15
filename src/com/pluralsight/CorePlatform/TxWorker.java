package com.pluralsight.CorePlatform;

public class TxWorker {

    protected BankAccount account;
    protected char txType; //'w' -> withdrawal, 'd' -> deposit
    protected int amt;

    // constructor that sets initial state of the object
    public TxWorker(BankAccount account, char txType, int amt) {
        this.account = account; //right hand is the parameter, left hand is the field
        this.txType = txType;
        this.amt = amt;
    }

    public void runIt() {

        int endBalance = 0;
        int startBalance = 0;

        startBalance = account.getBalance();

        if (txType == 'w') {
            account.withdrawal(amt);  //both are synchronized methods
        }
        else if (txType == 'd') {
            account.deposit(amt);
        }

        endBalance = account.getBalance();

        System.out.println("Account Number:  " + account.getId() + "  Transaction Type:  "+ txType + "  Start Balance:  " + startBalance
                + "  End Balance:  " + endBalance
                + "  "+Thread.currentThread().getName());
    }


}
