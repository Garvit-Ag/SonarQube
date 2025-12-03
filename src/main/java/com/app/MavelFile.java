package com.app;

import java.util.*;

// Account class implementing Comparable
class Account implements Comparable<Account> {
    private String accountHolderName;
    private int accountNo;
    private String transCode;
    private String country;
    private String ifscCode;
    private double balance;

    // Constructor
    public Account(String accountHolderName, int accountNo, String transCode, String country, String ifscCode, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        this.transCode = transCode;
        this.country = country;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }

    // Getters
    public String getAccountHolderName() { return accountHolderName; }
    public int getAccountNo() { return accountNo; }
    public String getTransCode() { return transCode; }
    public String getCountry() { return country; }
    public String getIfscCode() { return ifscCode; }
    public double getBalance() { return balance; }

    // toString for easy printing
    @Override
    public String toString() {
        return String.format("%-10s | %6d | %-3s | %-8s | %-8s | %.2f",
                accountHolderName, accountNo, transCode, country, ifscCode, balance);
    }

    // Comparable - sort by accountHolderName
    @Override
    public int compareTo(Account other) {
        return this.accountHolderName.compareToIgnoreCase(other.accountHolderName);
    }
}

// Comparator for sorting by account number
class AccountNoComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return Integer.compare(a1.getAccountNo(), a2.getAccountNo());
    }
}

// Comparator for sorting by balance
class BalanceComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return Double.compare(a1.getBalance(), a2.getBalance());
    }
}

public class MavelFile {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Alice", 105, "TR1", "India", "IFSC001", 45000.50));
        accounts.add(new Account("Bob", 101, "TR2", "USA", "IFSC002", 90000.75));
        accounts.add(new Account("Charlie", 109, "TR3", "UK", "IFSC003", 30000.00));
        accounts.add(new Account("David", 103, "TR4", "Canada", "IFSC004", 70000.25));

        System.out.println("Original List:");
        accounts.forEach(System.out::println);

        System.out.println("\nSorted by AccountHolderName (Comparable):");
        Collections.sort(accounts);
        accounts.forEach(System.out::println);

        System.out.println("\nSorted by AccountNo (Comparator):");
        Collections.sort(accounts, new AccountNoComparator());
        accounts.forEach(System.out::println);

        System.out.println("\nSorted by Balance (Comparator):");
        Collections.sort(accounts, new BalanceComparator());
        accounts.forEach(System.out::println);
    }
}
