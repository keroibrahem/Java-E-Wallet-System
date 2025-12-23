package service;

import model.Account;
import repository.AccountRepository;
import validation.AccountValidator;

public class AuthServise {

     private final AccountRepository repo = AccountRepository.getInstance();
    public static final int MAX_LOGIN_ATTEMPTS = 3;

    

    public boolean register(String username, String password, double balance, int age, String phone) {
        if (!AccountValidator.isValidUsername(username) ||
            !AccountValidator.isValidPassword(password) ||
            !AccountValidator.isValidBalance(balance) ||
            !AccountValidator.isValidAge(age)||
            !AccountValidator.validPhone(phone)
        ) {
            return false; // Validation failed
        }

        if (repo.usernameExists(username) || repo.phoneExists(phone)) {
            return false; // Username or phone already exists
        }

        Account newAccount = new Account(username, password, balance, age, phone);
        repo.addAccount(newAccount);
        return true; // Registration successful
    }

    public Account login(String username, String password) {
        if(!AccountValidator.isValidLoginInput(username, password)) {
            return null; // Invalid input
        }
        
        Account account = repo.findByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            account.setIsLogin("Yes");
            return account; // Login successful
        }
        return null; // Login failed
    }


}
