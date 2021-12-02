package MultiThread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WhatDeadLock {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();



    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) throws InterruptedException {
        boolean firstLockTaken = false; // первый лок забрался
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock();                // Если метод может забрать лок, то он его забирает и возвращает true
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }
                if (firstLockTaken) {
                    lock1.unlock();
                }
                if (secondLockTaken) {
                    lock2.unlock();
                }
            }
            Thread.sleep(1);
        }
    }



    public void firstThread() throws InterruptedException {         // Первый поток
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100)); // код будет выполнятся только в том случае
                // когда поток получит монитор объектов account1 и account2
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {        // Второй поток
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(100)); // код будет выполнятся только в том случае
                // когда поток получит монитор объектов account1 и account2
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {            // Метод который мы будем вызывать после того как два потока исполнят свой код
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance()+account2.getBalance()));
    }
}

class Account {                         // Этот класс понадобится для того чтобы симулировать реальный случай
    private int balance = 10000;        // Изначальный баланс

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }

}