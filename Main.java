package vpkbiet;

import java.util.Scanner;

//Bank Account class
class BankAccount {
 private String accountNumber;
 private double balance;

 public BankAccount(String accountNumber, double initialBalance) {
     this.accountNumber = accountNumber;
     this.balance = initialBalance;
 }

 public String getAccountNumber() {
     return accountNumber;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: $" + amount);
     displayBalance();
 }

 public void withdraw(double amount) {
     if (balance >= amount) {
         balance -= amount;
         System.out.println("Withdrawn: $" + amount);
         displayBalance();
     } else {
         System.out.println("Insufficient funds!");
     }
 }

 public void displayBalance() {
     System.out.println("Current Balance: $" + balance);
 }
}

//ATM class
class ATM {
 private BankAccount userAccount;

 public ATM(BankAccount userAccount) {
     this.userAccount = userAccount;
 }

 public void displayMenu() {
     System.out.println("1. Deposit");
     System.out.println("2. Withdraw");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 public void handleOption(int option) {
     Scanner scanner = new Scanner(System.in);

     switch (option) {
         case 1:
             System.out.print("Enter deposit amount: $");
             double depositAmount = scanner.nextDouble();
             userAccount.deposit(depositAmount);
             break;
         case 2:
             System.out.print("Enter withdrawal amount: $");
             double withdrawalAmount = scanner.nextDouble();
             userAccount.withdraw(withdrawalAmount);
             break;
         case 3:
             userAccount.displayBalance();
             break;
         case 4:
             System.out.println("Exiting. Thank you!");
             System.exit(0);
             break;
         default:
             System.out.println("Invalid option. Please try again.");
     }
 }
}

//Main class
public class Main {
 public static void main(String[] args) {
     // Create a bank account for the user
     BankAccount userAccount = new BankAccount("123456789", 1000.0);

     // Create an ATM with the user's account
     ATM atm = new ATM(userAccount);

     // ATM User Interface
     Scanner scanner = new Scanner(System.in);

     while (true) {
         // Display ATM menu
         System.out.println("\nWelcome to the ATM");
         atm.displayMenu();

         // Get user input
         System.out.print("Enter your choice (1-4): ");
         int choice = scanner.nextInt();

         // Handle user choice
         atm.handleOption(choice);
     }
 }
}
