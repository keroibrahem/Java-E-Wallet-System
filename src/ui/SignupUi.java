package ui;

import service.AuthServise;
import java.util.Scanner;
import validation.AccountValidator;
import util.ConsoleUtil;

public class SignupUi {

    private final AuthServise authServise = new AuthServise();
    Scanner scanner = new Scanner(System.in);
    boolean isValid= false;
    int countOFtries =0;
    String username;
    String password;
    String phone;
    int age;
    double balance;
   


    public void startSignup() {
        ConsoleUtil.clear();

        System.out.println("\n                       =============== Signup ===============");

        // Username validation loop
        while (!isValid && countOFtries<3) {
            System.out.print("\nEnter Username: (The first letter must be Uppercase and longer than 5 letters.) ");
            username = scanner.nextLine();
            isValid = AccountValidator.isValidUsername(username);
            if (!isValid) {
                System.out.println("Invalid username! Please try again.");
                System.out.println("You have " + (2 - countOFtries) + " attempts left.");
                countOFtries++;
            }
        }
        if(!isValid){
            System.out.println("Too many failed attempts. Returning to main menu.");
            System.out.println("\nRegistration failed! Please check your input and try again.");
            FristMenu fristMenuUi = new FristMenu();
            fristMenuUi.display();
        }else{
            isValid = false;
            countOFtries =0;
        }
        // Password validation loop
        while (!isValid && countOFtries<3) {
            System.out.print("\nEnter Password: (At least 8 characters, including uppercase, lowercase, digit, and special character.) ");
            password = scanner.nextLine();
            isValid = AccountValidator.isValidPassword(password);
            if (!isValid) {
                System.out.println("Invalid password! Please try again.");
                System.out.println("You have " + (2 - countOFtries) + " attempts left.");
                countOFtries++;
            }
        }
        if(!isValid){
            System.out.println("Too many failed attempts. Returning to main menu.");
            System.out.println("\nRegistration failed! Please check your input and try again.");
            FristMenu fristMenuUi = new FristMenu();
            fristMenuUi.display();
        }else{
            isValid = false;
            countOFtries =0;
        }

        // Phone number input

        while (!isValid && countOFtries<3) {
            System.out.print("\nEnter phone number: (11 digits, starts with 010, 011, 012, or 015) ");
            phone = scanner.nextLine();
            isValid = AccountValidator.validPhone(phone);
            if (!isValid) {
                System.out.println("Invalid phone number! Please try again.");
                System.out.println("You have " + (2 - countOFtries) + " attempts left.");
                countOFtries++;
            }
        }
        if(!isValid){
            System.out.println("Too many failed attempts. Returning to main menu.");
            System.out.println("\nRegistration failed! Please check your input and try again.");
            FristMenu fristMenuUi = new FristMenu();
            fristMenuUi.display();
        }else{
            isValid = false;
            countOFtries =0;
        }

        // Age input
        while (!isValid && countOFtries<3) {
            System.out.print("\nEnter age: (Must be 18 or older) ");
            String ageInput = scanner.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                isValid = AccountValidator.isValidAge(age);
                if (!isValid) {
                    System.out.println("Invalid age! Please try again.");
                    System.out.println("You have " + (2 - countOFtries) + " attempts left.");
                    countOFtries++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid age.");
                System.out.println("You have " + (2 - countOFtries) + " attempts left.");
                countOFtries++;
            }
            
        }
        if(!isValid){
            System.out.println("Too many failed attempts. Returning to main menu.");
            System.out.println("\nRegistration failed! Please check your input and try again.");
            FristMenu fristMenuUi = new FristMenu();
            fristMenuUi.display();
        }else{
            isValid = false;
            countOFtries =0;
        }

        // Balance input
        while (!isValid) {
            System.out.print("\nEnter initial balance: ");
            try {
                balance = Double.parseDouble(scanner.nextLine());
                isValid = AccountValidator.isValidBalance(balance);
                if (!isValid) {
                    System.out.println("Invalid balance! Please enter a valid amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                System.out.println("You have " + (2 - countOFtries) + " attempts left.");
                countOFtries++;
            }
        }

        if(!isValid){
            System.out.println("Too many failed attempts. Returning to main menu.");
            System.out.println("\nRegistration failed! Please check your input and try again.");
            FristMenu fristMenuUi = new FristMenu();
            fristMenuUi.display();
        }else{
            isValid = false;
            countOFtries =0;
        }
        
        boolean isRegistered = authServise.register(username, password, balance, age, phone);
        if (isRegistered) {
            System.out.println("\nRegistration successful!");
        } else {
            System.out.println("\nRegistration failed! Please check your input and try again.");
        }
    }


}
