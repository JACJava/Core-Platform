package com.pluralsight.CorePlatform;

public class TxPromoWorker extends TxWorker {

    public TxPromoWorker(BankAccount account, char txType, int amt){
        super(account, txType, amt);
    }

    public void run() {

        int endBalance = 0;
        int startBalance = 0;

        startBalance = account.getBalance();

        if (txType == 'w')
            account.withdrawal(amt);
        else if (txType == 'd') {

            synchronized (account) {
                account.deposit(amt);
                if (account.getBalance() > 500) {
                    int bonus = (int) ((account.getBalance() - 500) * 0.1);
                    account.deposit(bonus);
                }
            }

        }
        endBalance = account.getBalance();
        System.out.println("Transaction Type:  "+ txType + "  Start Balance:  " + startBalance
                + "  End Balance:  " + endBalance
                + "  "+Thread.currentThread().getName());
    }


}
