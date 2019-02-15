package com.pluralsight.CorePlatform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountGroup implements Serializable {

    private Map<String, BankAccount> accountMap = new HashMap<>();

    private transient int totalBalance;

    public int getTotalBalance() {return totalBalance;}

    public void addAccount(BankAccount account) {
        totalBalance += account.getBalance();
        accountMap.put(account.getId(),account);
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        for(BankAccount account : accountMap.values())
            totalBalance += account.getBalance();
    }




}
