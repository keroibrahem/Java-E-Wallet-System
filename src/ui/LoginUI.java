package ui;


import service.AuthServise;
import java.util.Scanner;
import model.Account;

public class LoginUI {
    private  AuthServise authServise = new AuthServise();
    Scanner scanner = new Scanner(System.in);

    public LoginUI() {
        this.authServise = new AuthServise();
    }

    public Account startLogin(){
        int loginAttempts = 0;
        System.out.println("\n                       =============== Login ===============");
        while (loginAttempts < AuthServise.MAX_LOGIN_ATTEMPTS) {
            System.out.println("\nAttempt " + (loginAttempts + 1) + " of " + AuthServise.MAX_LOGIN_ATTEMPTS);
            System.out.print("\nEnter username: ");
            String username = scanner.nextLine();
            System.out.print("\nEnter password: ");
            String password = scanner.nextLine();
            Account account = authServise.login(username, password);
            if (account != null) {
                System.out.println("\nLogin successful! Welcome, " + account.getUsername() + ":)");
                MainMenuUi mainMenuUi = new MainMenuUi(account);
                mainMenuUi.start();
                
            } else {
                System.out.println("\nLogin failed! Invalid username or password. Attempts left: " + (AuthServise.MAX_LOGIN_ATTEMPTS - loginAttempts+1));
                loginAttempts++;

            }
        }
        System.out.println("\n Too many failed attempts. Try again later.");
        return null;   

    }


}
