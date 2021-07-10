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
            if (this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        Branches temp = findBranch(branchName);
        if (temp != null) {
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
        if (temp != null && printTransaction) {
            System.out.println("Customer details for the branch " + temp.getName());
            for (int i = 0; i < temp.getCustomers().size(); i++) {
                System.out.println("Customer: " + temp.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
                System.out.println("Transactions:");
                for (int j = 0; j < temp.getCustomers().get(i).getTransactions().size(); i++) {
                    System.out.println("[" + (j + 1) + "]  Amount " + temp.getCustomers().get(i).getTransactions().get(j));
                }
            }
            return true;
        } else if (temp != null) {
            System.out.println("Customer details for the branch " + temp.getName());
            for (int i = 0; i < temp.getCustomers().size(); i++) {
                System.out.println("Customer: " + temp.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
            }
            return true;
        } else {
            return false;
        }
    }
}