package com.pluralsight.CorePlatform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = 7107747050370571393L;

    private String id;
    private int balance = 0;
    private char lastTxType;
    private int lastTxAmount;

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

    public char getLastTxType() {
        return lastTxType;
    }

    public int getLastTxAmount() {
        return lastTxAmount;
    }


    //getters and setters so outside things can use
    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){

        balance += amount;
        lastTxType = 'd';
        lastTxAmount = amount;
    }

    public synchronized void withdrawal(int amount){

        balance -= amount;
        lastTxType = 'w';
        lastTxAmount = amount;

    }

    private void writeObject(ObjectOutputStream out)
        throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        id = (String) fields.get("id", null);
        balance = fields.get("balance", 0);
        lastTxType = fields.get("lastTxType", 'u');
        lastTxAmount = fields.get("lastTxAmount", -1);
    }




}
