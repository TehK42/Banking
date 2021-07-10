package com.tehk42;

import java.util.ArrayList;

public class Customers {
    private String name;
    private ArrayList<Double> transactions;

    public Customers(String name, double initialTransactions) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialTransactions);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransactions(double transaction) {
        this.transactions.add(transaction);
    }
}
