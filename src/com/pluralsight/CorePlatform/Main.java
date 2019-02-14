package com.pluralsight.CorePlatform;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(5);

        BankAccount account = new BankAccount(100);

        for(int i=0; i<5; i++){
            Worker worker = new Worker(account);
            es.submit(worker);
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch(Exception e){
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }


    }


}
