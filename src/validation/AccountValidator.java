package validation;

public class AccountValidator {
    public static boolean isValidUsername(String username) {
        return username != null 
            && username.length() >= 5 
            && Character.isUpperCase(username.charAt(0));
    }

    public static boolean isValidPassword(String password) {
        return password != null && 
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") && // at least one uppercase letter
               password.matches(".*[a-z].*") && // at least one lowercase letter
               password.matches(".*\\d.*")&&
               password.matches(".*[!@#$%^&*()-+].*");    // at least one special character
    }

    public static boolean isValidAge(int age) {
        return age >= 18;
    }

    public static boolean isValidBalance(double balance) {
        return balance >= 0;
    }

    public static boolean validPhone(String phone) {
        return phone != null && phone.matches("^01[0125][0-9]{8}$");
    }

    public static boolean isValidLoginInput(String username, String password) {
    return username != null && !username.isEmpty()
        && password != null && !password.isEmpty();
    }

}
