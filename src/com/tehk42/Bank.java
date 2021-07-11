package com.tehk42;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branches> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }

    private Branches findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branches check = this.branches.get(i);
            if (check.getName().equals(branchName)) {
                return check;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        Branches temp = findBranch(branchName);
        if (temp == null) {
            temp = new Branches(branchName);
            this.branches.add(temp);
            return true;
        } else {
            System.out.println("Branch already exists.");
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branches temp = findBranch(branchName);
        if (temp != null) {
            return temp.addCustomer(customerName, transaction);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transaction) {
        Branches temp = findBranch(branchName);
        if (temp != null) {
            return temp.addTransaction(customerName, transaction);
        }
        return false;
    }

    public boolean printCustomers(String branchName, boolean printTransaction) {
        Branches temp = findBranch(branchName);
        if (temp != null) {
            System.out.println("Customer details for the branch " + temp.getName());
            ArrayList<Customers> customer = temp.getCustomers();
            for (int i = 0; i < temp.getCustomers().size(); i++) {
                Customers branchCustomer = customer.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");

                if(printTransaction) {
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j=0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "]  Amount "  + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}