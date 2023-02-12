package main.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    LocalDateTime dateTime;
    protected Account from;
    protected Account to;
    protected double amount;
    protected String transactionId;
    protected static int transactionIdTrack = 0;

    protected static List<Transaction> transactionsList = new ArrayList<>();

    public Transaction (Account from, Account to, double amount) {
        Transaction.transactionIdTrack += 1;
        this.dateTime = LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.transactionId = String.format("%4d",Transaction.transactionIdTrack).replace(' ', '0');
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        transactionsList.add(this);

    }

    public String toPrintable() {
        // TransactionID; dateTime; Sender; Receiver; Amount
        return String.format("%9s; %24s; %15s; %15s; %7.2f",
                this.getTransactionId(), this.getDateTime().substring(0, 19).replace('T', ' '),
                this.getFrom().getAccountHolderName(), this.getTo().getAccountHolderName(), this.getAmount());
    }

    public String getDateTime() {
        return dateTime.toString();
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public static List<Transaction> getTransactionsList() {
        return transactionsList;
    }
}


