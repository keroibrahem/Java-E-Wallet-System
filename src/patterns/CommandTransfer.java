package patterns;

import service.AccountService;
import model.Account;


public class CommandTransfer implements Command {
    private Account fromAccount;
    public CommandTransfer(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
    @Override
    public void execute() {
        AccountService accountService = new AccountService();
        accountService.transfer(fromAccount);
        
    }

}
