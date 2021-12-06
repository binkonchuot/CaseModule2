package CaseModule2.controller;

import CaseModule2.service.AccountService;
import CaseModule2.views.ViewLogin;

public class ControllerLogin {
    public static void menuLogin() {
        ViewLogin viewLogin = new ViewLogin();
        AccountService accountService = new AccountService()
;        while (true) {
               int choice = viewLogin.menuLogin();
            switch (choice) {
                case 1:
                    if (accountService.login(viewLogin.createAccount())) {
                      ControllerStaff.menuManager();
                    }
                    break;
                case 2:
                    accountService.addAccount(viewLogin.createAccount());
                    break;
            }
        }
    }
}
