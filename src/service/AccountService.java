package service;

import model.Account;
import repository.AccountRepository;

import java.util.Scanner;

public class AccountService {
    AccountRepository accountRepository = AccountRepository.getInstance();
    private Scanner scanner = new Scanner(System.in);


    public boolean deposit(Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive (greater than zero).");
            return false;
        }
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited: " + amount);
        System.out.println("your Balance: " + account.getBalance());
        return true;
    }

    public boolean withdraw(Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive (greater than zero).");
            return false;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance for this withdrawal.");
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdrew: " + amount);
        System.out.println("your Balance: " + account.getBalance());
        return true;
    }

    public boolean transfer(Account fromAccount) {
        System.out.println("\nEnter recipient username: ");
        String toUsername = scanner.next();
        Account toAccount = accountRepository.findByUsername(toUsername);
        if (toAccount == null) {
            System.out.println("Recipient account not found.");
            return false;
        }
        System.out.println("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        System.out.println();
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive (greater than zero).");
            return false;
        }
        if (amount > fromAccount.getBalance()) {
            System.out.println("Insufficient balance for this transfer.");
            return false;
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        System.out.println("Transferred: " + amount + " to " + toAccount.getUsername());
        System.out.println("your Balance: " + fromAccount.getBalance());
        return true;
    }

    public void showAccountDetails(Account account) {
        System.out.println("\n======= Account Details =======");
        System.out.println("Username: " + account.getUsername());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Phone: " + account.getPhone());
        System.out.println("Age: " + account.getAge());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Password: " + maskPassword(account.getPassword()));
        System.out.println("==============================");
    }

    
    public String maskPassword(String password) {
        int length = password.length();
        String firstChars = password.substring(0, 2);
        String lastChar = password.substring(length - 1);
        String maskedPart = "*".repeat(length - 3);
        
        return firstChars + maskedPart + lastChar;
    }

    public boolean changePassword(Account account) {
        System.out.print("Enter old password: ");
        String oldPassword = scanner.next();
        System.out.print("Enter new password: ");
        String newPassword = scanner.next();
        if (!account.getPassword().equals(oldPassword)) {
            System.out.println("Old password is incorrect.");
            return false;
        }
        if(!validation.AccountValidator.isValidPassword(newPassword)) {
            System.out.println("New password does not meet the criteria.");
            return false;
        }
        account.setPassword(newPassword);
        System.out.println("Password changed successfully.");
        return true;
    }

    public void logout() {
        System.out.println("Logged out successfully. :( ");
        
    }

}
