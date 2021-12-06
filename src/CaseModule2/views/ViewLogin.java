package CaseModule2.views;

import CaseModule2.model.Account;

import java.util.Scanner;

public class ViewLogin {
      Scanner scanner = new Scanner(System.in);

      public int menuLogin() {
          System.out.println("1. Dang Nhap");
          System.out.println("2. Dang Ky");
          return Integer.parseInt(scanner.nextLine());
      }
      public Account createAccount() {
          System.out.println("Nhap UserName");
          String userName = scanner.nextLine();
          System.out.println("Nhap PassWord");
          String passWord = scanner.nextLine();
          return new Account(userName,passWord);
      }
}
