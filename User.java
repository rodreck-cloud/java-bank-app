import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private int pin;
    private double balance;
    private ArrayList<String> transactions;

    public User(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getPin() { return pin; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("✅ Deposited: R" + amount);
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            transactions.add("❌ Withdraw failed: R" + amount);
        } else {
            balance -= amount;
            transactions.add("✅ Withdrawn: R" + amount);
        }
    }

    public void printTransactions() {
        System.out.println("\n📄 Transaction History:");
        if(transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for(String t : transactions) {
                System.out.println(t);
            }
        }
    }
} 
