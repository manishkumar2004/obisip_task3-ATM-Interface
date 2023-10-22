import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String pin;
    private double balance;

    public User(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class ATM {
    private Map<String, User> users;
    private Scanner scanner;

    public ATM() {
        users = new HashMap<>();
        // Add sample users (PIN, Balance)
        users.put("1234", new User("1234", 1000.0));
        users.put("5678", new User("5678", 1500.0));
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        while (true) {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            User user = users.get(pin);
            if (user != null) {
                showMenu(user);
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        }
    }

    private void showMenu(User user) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + user.getBalance());
                    break;
                case 2:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
