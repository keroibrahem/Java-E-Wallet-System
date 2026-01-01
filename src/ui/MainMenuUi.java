package ui;

import model.Account;
import patterns.Command;
import patterns.CommandFactory;
import util.ConsoleUtil;

import java.util.Scanner;

public class MainMenuUi {
    Scanner scanner = new Scanner(System.in);
    int choice;
    private Account loggedInAccount;

    public MainMenuUi(Account account) {
        this.loggedInAccount = account;
    }

    public void start() {
        boolean running = true;

        while (running) {
            ConsoleUtil.clear();
            System.out.println("\n                    ======= Main Menu =======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Show Account Details");
            System.out.println("5. Change Password");
            System.out.println("6. Logout");
            System.out.print("Choose: ");

            
            try{
               choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1 and 6."); // clear the invalid input
                continue;
            }
            
            ConsoleUtil.clear();
            Command command = CommandFactory.getCommand(choice, loggedInAccount);

            if (command != null) {
                command.execute();
                if (choice == 6) {
                    System.out.println("Goodbye!....");
                    running = false;
                    FristMenu fristMenu = new FristMenu();
                    fristMenu.display();
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
