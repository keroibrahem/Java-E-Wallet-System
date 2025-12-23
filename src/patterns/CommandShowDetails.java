package patterns;
import service.AccountService;
import model.Account;

public class CommandShowDetails implements Command {
    private Account account;
    public CommandShowDetails(Account account) {
        this.account = account;
    }
    @Override
    public void execute() {
        AccountService accountService = new AccountService();
        accountService.showAccountDetails(account);
    }

}
