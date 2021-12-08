package CaseModule2.controller;

import CaseModule2.model.Account;
import CaseModule2.service.AccountService;
import CaseModule2.views.ViewLogin;

public class ControllerLogin {
    public static void menuLogin() {
        ViewLogin viewLogin = new ViewLogin();
        AccountService accountService = new AccountService();
        while (true) {
            String choice = viewLogin.menuLogin();
            switch (choice) {
                case "1":
                    Account account = viewLogin.registerAdmin();
                    if (accountService.login(account)) {
                        ControllerStaff.menuManagerUser();
                        break;
                    }
                    if (accountService.loginAdmin(account)) {
                        ControllerAdmin.menuManagerAdmin();
                        break;
                    }
                    break;
                case "2":
                    accountService.addAccount(viewLogin.createAccount());
                    break;
                default:
                    System.err.println("**    Requires entering the correct option!   **");
            }
        }
    }
}