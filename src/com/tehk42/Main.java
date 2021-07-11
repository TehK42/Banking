package com.tehk42;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Bank of the Philippine Islands");

        bank.addBranch("Bacolod");

        bank.addCustomer("Bacolod", "James", 50.05);
        bank.addCustomer("Bacolod", "John", 10.12);
        bank.addCustomer("Bacolod", "Ann", 25.25);

        bank.addBranch("IloIlo");
        bank.addCustomer("IloIlo", "Luigi", 420.69);

        bank.addTransaction("Bacolod", "James", 42.00);
        bank.addTransaction("Bacolod", "James", 42.00);
        bank.addTransaction("Bacolod", "Ann", 42.00);

//        bank.printCustomers("Bacolod", true);

        bank.printCustomers("IloIlo", true);

    }
}
