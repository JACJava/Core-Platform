package com.pluralsight.CorePlatform;

public class BankAccount {

    private String id;
    private int balance = 0;

    // constructor that sets initial state of the object

    // constructor that accepts nothing
    public BankAccount(){};


    // constructor that accepts just the id
    public BankAccount(String id) {
        this.id = id; //right hand is the parameter, left hand is the field
    }

    // constructor that accepts just the id and the starting balance
    public BankAccount(String id, int balance) {
        this.id = id; //right hand is the parameter, left hand is the field
        this.balance = balance;
    }

    //getters and setters so outside things can use
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getId() {
        return id;
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
