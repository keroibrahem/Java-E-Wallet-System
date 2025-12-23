package ui;

import java.util.Scanner;
import util.ConsoleUtil;

public class FristMenu {
    int running = 1;

    Scanner scanner = new Scanner(System.in);

    public void display() {
        while (running == 1) {
            ConsoleUtil.clear();
            System.out.println("\n                    ======= Welcome to E-Wallet System =======");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    LoginUI loginUI = new LoginUI();
                    loginUI.startLogin();
                    break;
                case 2:
                    SignupUi signupUi = new SignupUi();
                    signupUi.startSignup();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    running = 0;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

        
    }


}
