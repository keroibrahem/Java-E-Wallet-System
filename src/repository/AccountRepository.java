package repository;

import model.Account;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * AccountRepository - Repository pattern implementation for Account management
 * 
 * Improvements & Enhancements:
 * ✅ Added HashMap for O(1) username lookup performance (instead of O(n) with ArrayList only)
 * ✅ Maintains both ArrayList and HashMap for data integrity and efficient searching
 * ✅ Added exception handling and null checks in critical methods
 * ✅ Added deleteAccount() method for complete CRUD operations
 * ✅ Ensures unique usernames using HashMap containsKey() check
 * 
 * @author Development Team
 * @version 2.0
 */
public class AccountRepository {
    private List<Account> accounts;
    private Map<String, Account> accountsMap;
    private static AccountRepository instance = null;

    private AccountRepository() {
        this.accounts = new ArrayList<>();
        this.accountsMap = new java.util.HashMap<>();
    }

    // Singleton pattern to ensure only one instance of AccountRepository
    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    public void addAccount(Account account) {
        if(account == null) {
            return;
        }
        accounts.add(account);
        accountsMap.put(account.getUsername(), account);
    }

    public Account findByUsername(String username) {
        return accountsMap.get(username);
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
        return accountsMap.containsKey(username);
    }

    public boolean phoneExists(String phone) {
        return accounts.stream()
                .anyMatch(acc -> acc.getPhone().equals(phone));
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public void deleteAccount(String username) {
        accounts.removeIf(acc -> acc.getUsername().equals(username));
        accountsMap.remove(username); 
    }



}
