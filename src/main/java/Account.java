package main.java;

import java.util.*;

public class Account {
    protected User accountHolder;
    protected int accountNo;
    protected static List<Integer> usedAccountNo = new ArrayList<>();

    protected static Account cash = new Account(User.Bank, 100000);
    protected double balance;

    public Account(User accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        Random random = new Random();
        accountNo = random.nextInt(100000000) + 10000000;
        while (Collections.singletonList(Account.usedAccountNo).contains(accountNo)) {
            accountNo = random.nextInt(100000000) + 10000000;
        }
        Account.usedAccountNo.add(accountNo);
        accountHolder.appendAccountList(this);
    }

    public Account(User accountHolder) {
        this(accountHolder, 0.0);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        // System.out.println(String.format("%s withdraw %f", this.getName(), amount));
        new Transaction(this, cash, amount);
    }

    public void deposit(double amount) {
        // System.out.println(String.format("%s deposited %f", this.getName(), amount));
        new Transaction(cash, this, amount);
    }

    public void send(double amount, Account to) {
        // System.out.println(String.format("%s sent %f to %s", this.getName(), amount, to.getName()));
        new Transaction(this, to, amount);
    }

    public String getAccountHolderName() {
        return this.accountHolder.getName();
    }


    public List<Transaction> getTransactionsList() {
        List<Transaction> result = new ArrayList<>();
        for(Transaction x: Transaction.getTransactionsList()){
            if(this == x.getFrom() || this == x.getTo()) {
                result.add(x);
            }
        }
        return result;
    }

    public int getAccountNo() {
        return accountNo;
    }
/*
    public void printStatement() {
        List<Transaction> transactions = this.getTransactionsList();
        for(Transaction transaction: transactions) {
            double runningBalance = balance
            System.out.printf("%9s; %24s; %15s; %15s; %7.2f; %7.2f",
                    this.getAccountNo(), this.getDateTime().substring(0, 19).replace('T', ' '),
                    this.getFrom().getAccountHolderName(), this.getTo().getAccountHolderName(),
                    this.getAmount(), this.getBalance());
        }

    }


    // TransactionID; dateTime; Sender; Receiver; Amount
        return String.format("%9s; %24s; %15s; %15s; %7.2f",
                this.getTransactionId(), this.getDateTime().substring(0, 19).replace('T', ' '),
                this.getFrom().getAccountHolderName(), this.getTo().getAccountHolderName(), this.getAmount());
    }
     */

}
