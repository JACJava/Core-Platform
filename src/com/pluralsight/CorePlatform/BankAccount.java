package com.pluralsight.CorePlatform;

public class BankAccount {

    // accepts bank account balance
    private int balance;

    // constructor that sets initial state of the object
    public BankAccount(int startBalance) {
        this.balance = startBalance; //right hand is the parameter, left hand is the field
    }

    //getters and setters so outside things can use
    public int getBalance(){ return balance; }
    public void setBalance(int balance) {
        this.balance = balance; //right hand is the parameter, left hand is the field}
    }

    public void deposit(int amount){
        balance += amount;
    }




}
