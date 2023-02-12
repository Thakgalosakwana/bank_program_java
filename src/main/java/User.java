package main.java;

import main.java.Account;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User {
    protected static final User Bank = new User("Thakgalo", "Bank");
    protected String firstName;
    protected String lastName;
    protected List<Account> accountList = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        String[] firstNames = this.firstName.split(" ");
        StringBuilder initials = new StringBuilder();
        for(String name : firstNames) {
            initials.append(name.charAt(0));
        }
        return  this.getLastName() + " " + initials;
    }

    // fullName = this.accountHolder.getName().split(' ');
    public List<Account> getAccountList() {
        return accountList;
    }
    public void appendAccountList(Account account) {
        this.accountList.add(account);
    }

    public double getNetBalance() {
        double balance = 0;
        for(Account a: accountList) {
            balance += a.getBalance();
        }
        return balance;
    }
}
