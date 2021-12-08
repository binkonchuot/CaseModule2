package CaseModule2.service;

import CaseModule2.io.ReadAndWriteAccount;
import CaseModule2.model.Account;

import java.util.List;

public class AccountService {
    List<Account> accounts = ReadAndWriteAccount.readAccount();

    public AccountService() {
    }
    public void addAccount(Account account) {
        for (Account acc: accounts) {
            if (acc.getUserName().equals(account.getUserName())) {
                return;
            }
        }
        accounts.add(account);
        ReadAndWriteAccount.writeAccount(accounts);
    }
    public List<Account> findAll() {
        return accounts;
    }
    public boolean login(Account account) {
        for (Account acc: accounts) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                return true;
            }
        }
        System.err.println("** Unregistered account or Wrong information  **");
        System.err.println("**              Please Re-enter!              **");
        return false;
    }
    public boolean loginAdmin(Account account) {
        if ("admin".equals(account.getUserName()) && "admin".equals(account.getPassWord())) {
            return true;
        }
        return false;
    }
}
