package patterns;

import java.util.Scanner;
import util.ConsoleUtil;
import model.Account;


public class CommandLogout implements Command {
    private Account account;
    Scanner scanner = new Scanner(System.in);
    
    public CommandLogout(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        ConsoleUtil.clear();
        System.out.println("Do you want to log out? (Y : 1/N : 0): ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            account.setIsLogin("No");
            System.out.println("You have been logged out successfully.");
        } else {
            account.setIsLogin("Yes");
        }

    }

}
