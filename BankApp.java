
import java.util.Scanner;

public class BankApp {

    static double balance = 1000.00;
    static final int PIN = 1234;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        if (!login()) {
            System.out.println(" Too many failed attempts. Account locked.");
            return;
        }

        int option;

        System.out.println("Welcome to Rodreck Bank");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            option = scanner.nextInt();

            switch(option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid option!");
            }

        } while(option != 4);
    }

    static boolean login() {
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("🔑 Enter PIN: ");
            int input = scanner.nextInt();

            if (input == PIN) {
                System.out.println("✅ Login successful!");
                return true;
            } else {
                attempts--;
                System.out.println("❌ Wrong PIN. Attempts left: " + 
attempts);
            }
        }
        return false;
    }

    static void checkBalance() {
        System.out.println("💰 Current Balance: R" + balance);
    }

    static void deposit() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("✅ Deposited: R" + amount);
    }

    static void withdraw() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if(amount > balance) {
            System.out.println("❌ Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn: R" + amount);
        }
    }
} 
