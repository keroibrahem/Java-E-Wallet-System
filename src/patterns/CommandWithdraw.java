package patterns;

import model.Account;
import service.AccountService;

public class CommandWithdraw implements Command {
    private Account account;

    public CommandWithdraw(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        
        AccountService accountService = new AccountService();
        accountService.withdraw(account);
    }
}
