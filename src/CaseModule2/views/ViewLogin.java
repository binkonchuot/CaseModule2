package CaseModule2.views;

import CaseModule2.model.Account;

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
          System.out.println("Input PassWord");
          String passWord = scanner.nextLine();
          return new Account(userName,passWord);
      }
}
