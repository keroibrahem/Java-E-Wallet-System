package patterns;

import model.Account;
import service.AccountService;

public class CommandDeposit implements Command {
   
    private Account account;
   

    public CommandDeposit(Account account) {
        
        this.account = account;
        
    }

    @Override
    public void execute() {
        AccountService accountService = new AccountService();
        accountService.deposit(account);
    }
}    
