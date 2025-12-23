package ui;

import service.AuthServise;
import java.util.Scanner;
import util.ConsoleUtil;

public class SignupUi {

    private final AuthServise authServise = new AuthServise();
    Scanner scanner = new Scanner(System.in);
   


    public void startSignup() {
        ConsoleUtil.clear();

        System.out.println("\n                       =============== Signup ===============");

        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();

        System.out.print("\nEnter password: ");
        String password = scanner.nextLine();

        System.out.print("\nEnter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("\nEnter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("\nEnter initial balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        boolean isRegistered = authServise.register(username, password, balance, age, phone);
        if (isRegistered) {
            System.out.println("\nRegistration successful!");
        } else {
            System.out.println("\nRegistration failed! Please check your input and try again.");
        }
    }


}
