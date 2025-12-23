package repository;

import model.Account;
import java.util.List;
import java.util.ArrayList;

public class AccountRepository {
    private List<Account> accounts;
    private static AccountRepository instance = null;

    private AccountRepository() {
        this.accounts = new ArrayList<>();
    }

    // Singleton pattern to ensure only one instance of AccountRepository
    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findByUsername(String username) {
        return accounts.stream()
                .filter(acc -> acc.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Account getAccountByPhone(String phone) {
        for (Account account : accounts) {
            if (account.getPhone().equals(phone)) {
                return account;
            }
        }
        return null; // Return null if account not found
    }

    public boolean usernameExists(String username) {
        return accounts.stream()
                .anyMatch(acc -> acc.getUsername().equalsIgnoreCase(username));
    }

    public boolean phoneExists(String phone) {
        return accounts.stream()
                .anyMatch(acc -> acc.getPhone().equals(phone));
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }



}
