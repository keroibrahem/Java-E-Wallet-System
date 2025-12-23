package patterns;
import service.AccountService;
import model.Account;
public class CommandChangePassword implements Command {
    private Account account;
    public CommandChangePassword(Account account) {
        this.account = account;
    }
    @Override
    public void execute() {
        AccountService accountService = new AccountService();
        accountService.changePassword(account);

    }

}
