package CaseModule2.views;

import CaseModule2.io.ReadAndWriteAccount;
import CaseModule2.model.Account;

import java.util.List;
import java.util.Scanner;

public class ViewLogin {
    Scanner scanner = new Scanner(System.in);
    public String menuLogin() {
        System.out.println("************************************************");
        System.out.println("**                                            **");
        System.out.println("**          1.Login        2.Register         **");
        System.out.println("**                                            **");
        System.out.println("************************************************");
        return scanner.nextLine();
    }
    public Account createAccount() {
        System.out.println("Input UserName");
        String userName = scanner.nextLine();
        if (!validUserName(userName)) return createAccount();
        System.out.println("Input PassWord");
        String passWord = scanner.nextLine();
        return new Account(userName,passWord);
    }
    public Account registerAdmin() {
        System.out.println("Input UserName");
        String userName = scanner.nextLine();
        System.out.println("Input PassWord");
        String passWord = scanner.nextLine();
        return new Account(userName,passWord);
    }
    public static boolean validUserName(String userName) {
        if (userName.equals("admin")) {
            System.err.println("--> Not allowed to use this User name");
            return false;
        }
        List<Account> accountList = ReadAndWriteAccount.readAccount();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserName().equals(userName)) {
                System.err.println("--> Username is duplicated!");
                return false;
            }
        }
        return true;
    }
}
