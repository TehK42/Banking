package com.tehk42;

import java.util.ArrayList;

public class Branches {
    private String name;
    private ArrayList<Customers> customers;

    public Branches(String name) {
        this.name = name;
        this.customers = new ArrayList<Customers>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    private Customers findCustomer(String customerName) {
        for(int i = 0; i < this.customers.size(); i++) {
            if(this.customers.get(i).getName().equals(customerName)) {
                return this.customers.get(i);
            }
        }
        return null;
    }

    public boolean addCustomer(String customerName, double transaction) {
        Customers temp = findCustomer(customerName);
        if(temp != null) {
            temp = new Customers(customerName, transaction);
            this.customers.add(temp);
            return true;
        } else {
            System.out.println("Customer is already in branch.");
            return false;
        }
    }

    public boolean addTransaction(String customerName, double transaction) {
        Customers temp = findCustomer(customerName);
        if (temp != null) {
            temp.addTransactions(transaction);
            return true;
        }
        System.out.println("Customer was not found.");
        return false;
    }
}
