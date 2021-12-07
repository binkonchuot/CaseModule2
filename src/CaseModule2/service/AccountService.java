package CaseModule2.service;

import CaseModule2.io.ReadAndWriteAccount;
import CaseModule2.model.Account;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
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
         System.out.println("************************************************");
         System.err.println("**  Account chưa đăng ký hoặc Sai thông tin   **");
         System.err.println("**               Mời Nhập lại!                **");
         System.out.println("************************************************");
         return false;
     }
    public boolean loginAdmin(Account account) {
            if ("admin".equals(account.getUserName()) && "admin".equals(account.getPassWord())) {
                return true;
            }
        return false;
    }
}
