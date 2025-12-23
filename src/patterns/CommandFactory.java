package patterns;

import model.Account;


public class CommandFactory {

    public static Command getCommand(int choice, Account account) {
       
        return switch (choice) {
            case 1 -> new CommandDeposit(account);
            case 2 -> new CommandWithdraw(account);
            case 3 -> new CommandTransfer(account);
            case 4 -> new CommandShowDetails(account);
            case 5 -> new CommandChangePassword(account);
            case 6 -> new CommandLogout(account);
            default -> null;
        };
        
        
    }

}
