package CaseModule2.controller;
import CaseModule2.model.Account;
import CaseModule2.service.AccountService;
import CaseModule2.views.ViewLogin;
import CaseModule2.views.ViewStaff;

public class ControllerAdmin {
    public static void menuManagerAdmin() {
        ViewStaff viewAdmin = new ViewStaff();
        AccountService accountService = new AccountService();
        ViewLogin viewLogin = new ViewLogin();
        int index;
        while (true) {
            String choice = viewAdmin.menuAdmin();
            switch (choice) {
                case "1":
                    int count = 0;
                    while (true) {
                        index = accountService.findIndexByNameAcc(viewAdmin.inputNameAcc());
                        count++;
                        if (index != -1) {
                            Account newAcccount = viewLogin.createAccount();
                            accountService.editAcc(index, newAcccount);
                            System.err.println("**                   Fixed!                   **");
                            break;
                        } else {
                            System.err.println("---> No find Name!");
                            System.err.println("---> Wrong more than 3 times, Please re-enter!");
                            if (count == 4) {
                                System.err.println("**        Enter incorrectly 3 times, Please re-enter!       **");
                                break;
                            }
                        }
                    }
                    break;
                case "2":
                    count = 0;
                    while (true) {
                        index = accountService.findIndexByNameAcc(viewAdmin.inputNameAcc());
                        count++;
                        if (index == -1) {
                            System.err.println("---> No find Name!");
                            System.err.println("---> Wrong more than 3 times, Please re-enter!");
                            if (count == 4) {
                                System.err.println("**        Enter incorrectly 3 times,Please re-enter!       **");
                                break;
                            }
                        } else {
                            accountService.deleteAcc(index);
                            System.err.println("**                   Deleted!                 **");
                            break;
                        }
                    }
                    break;
                case "3":
                    accountService.showAcc(accountService.findAll());
                    break;
                case "4":
                    System.err.println("**              Request Selection!            **");
                    return;
                default:
                    System.err.println("**    Requires entering the correct option!   **");
            }
        }
    }
}