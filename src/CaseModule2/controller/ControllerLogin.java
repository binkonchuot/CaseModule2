package CaseModule2.controller;

import CaseModule2.model.Account;
import CaseModule2.service.AccountService;
import CaseModule2.views.ViewLogin;

import java.util.Scanner;

public class ControllerLogin {
    public static void menuLogin() {
        Scanner sc = new Scanner(System.in);
        ViewLogin viewLogin = new ViewLogin();
        AccountService accountService = new AccountService()
;        while (true) {

               int choice = viewLogin.menuLogin();
            switch (choice) {
                case 1:
                    Account account = viewLogin.createAccount();
                    if (accountService.login(account)) {
                      ControllerStaff.menuManagerUser();
                      break;
                    }
                    if (accountService.loginAdmin(account )) {
                        ControllerStaff.menuManagerAdmin();
                        break;
                    }
                    break;
                case 2:
                    accountService.addAccount(viewLogin.createAccount());
                    break;
            }
        }
    }
}
