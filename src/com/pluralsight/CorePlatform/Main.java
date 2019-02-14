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

        BankAccount account = new BankAccount(600);

        TxWorker worker1 = new TxPromoWorker(account, 'd', 150 );
        TxWorker worker2 = new TxPromoWorker(account, 'w', 300 );
//        TxWorker worker3 = new TxWorker(account, 'd', 100 );
//        TxWorker worker4 = new TxWorker(account, 'd', 600 );
//        TxWorker worker5 = new TxWorker(account, 'w', 300 );
//        TxWorker worker6 = new TxWorker(account, 'w', 100 );
//        TxWorker worker7 = new TxWorker(account, 'w', 130 );


        TxWorker[] workers = {worker1, worker2};
        //TxWorker[] workers = {worker1, worker2, worker3, worker4, worker5, worker6, worker7};

        for(TxWorker worker:workers){
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
