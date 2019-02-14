package com.pluralsight.CorePlatform;

public class BankAccount {

    // accepts bank account balance
    private int balance;

    // constructor that sets initial state of the object
    public BankAccount(int startBalance) {
        this.balance = startBalance; //right hand is the parameter, left hand is the field
    }

    //getters and setters so outside things can use
    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
    }


}
