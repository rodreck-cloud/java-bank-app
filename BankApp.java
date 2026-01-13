import java.util.*;
import java.io.*;

public class BankApp {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, User> users = new HashMap<>();
    static final String FILE_NAME = "users.dat";

    public static void main(String[] args) {
        loadUsers();
        System.out.println("🏦 Welcome to Rodreck Bank");

        User currentUser = login();
        if(currentUser == null) {
            System.out.println("❌ Too many failed attempts. Exiting.");
            return;
        }

        int option;
        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            option = scanner.nextInt();

            switch(option) {
                case 1:
                    System.out.println("💰 Balance: R" + 
currentUser.getBalance());
                    break;
                case 2:
                    deposit(currentUser);
                    break;
                case 3:
                    withdraw(currentUser);
                    break;
                case 4:
                    currentUser.printTransactions();
                    break;
                case 5:
                    saveUsers();
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid option!");
            }
        } while(option != 5);
    }

    static User login() {
        int attempts = 3;
        while(attempts > 0) {
            System.out.print("Enter username: ");
            String name = scanner.next();
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            User user = users.get(name);
            if(user != null && user.getPin() == pin) {
                System.out.println("✅ Login successful!");
                return user;
            } else {
                attempts--;
                System.out.println("❌ Wrong credentials. Attempts left: " 
+ attempts);
            }
        }
        return null;
    }

    static void deposit(User user) {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        user.deposit(amount);
        System.out.println("✅ Deposited: R" + amount);
    }

    static void withdraw(User user) {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        user.withdraw(amount);
        System.out.println("💰 Balance now: R" + user.getBalance());
    }

    // Load users from file
    static void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new 
FileInputStream(FILE_NAME))) {
            users = (HashMap<String, User>) ois.readObject();
        } catch (Exception e) {
            // No file yet, create default users
            users.put("rodreck", new User("rodreck", 1234, 1000));
            users.put("alex", new User("alex", 1111, 500));
        }
    }

    // Save users to file
    static void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new 
FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        } catch (Exception e) {
            System.out.println("❌ Error saving users: " + 
e.getMessage());
        }
    }
} 
