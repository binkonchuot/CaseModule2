package CaseModule2.views;

import CaseModule2.model.FullTimeStaff;
import CaseModule2.model.PartTimeStaff;
import CaseModule2.model.Staff;

import java.util.List;
import java.util.Scanner;

public class ViewStaff {
    Scanner scanner = new Scanner(System.in);

    public int menuUser(){
        System.out.println("****************************************");
        System.out.println("**         1. Thêm nhân viên          **");
        System.out.println("**         2. Sửa nhân viên           **");
        System.out.println("**         3. Xóa nhân viên           **");
        System.out.println("**         4. Hiển Thị nhân viên      **");
        System.out.println("**         5. Thoát chương trình      **");
        System.out.println("**             #Mời Chọn#             **");
        System.out.println("****************************************");
        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAdmin(){
        System.out.println("***************************************************");
        System.out.println("**               1. Sửa Account                  **");
        System.out.println("**               2. Xóa Account                  **");
        System.out.println("**               3. Show Account                 **");
        System.out.println("**               4. Đăng xuất                    **");
        System.out.println("**                  #Mời Chọn#                   **");
        System.out.println("***************************************************");
        return Integer.parseInt(scanner.nextLine());
    }
    public int menuAdd(){
        System.out.println("****************************************");
        System.out.println("**    1. Thêm nhân viên FullTime      **");
        System.out.println("**    2. Thêm nhân viên PartTime      **");
        System.out.println("**             #Mời Chọn#             **");
        System.out.println("****************************************");
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputName(){
        System.out.println("1. Nhập Name ");
        return scanner.nextLine();
    }
    public Staff createStaff(boolean isFullTimeStaff) {
        System.out.println("Nhập Name: ");
        String name = scanner.nextLine();
        System.out.println("Nhập Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập PhoneNumber: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập Address: ");
        String address = scanner.nextLine();
        System.out.println("Nhập Lương theo giờ làm: ");
        int luongTime = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Số giờ làm: ");
        double hours = Double.parseDouble(scanner.nextLine());

        double luongTong = 0;
        if(isFullTimeStaff) {
            System.out.println("Nhập Hệ số lương");
            double coefficients = Double.parseDouble(scanner.nextLine());
            return new FullTimeStaff(name,age,phone,gender,address,luongTong,luongTime,hours,coefficients);
        } else {
            return new PartTimeStaff(name,age,phone,gender,address,luongTong,luongTime,hours);
        }
    }
    public void show(List<Staff> staffs) {
        for (Staff h: staffs) {
            System.out.println(h.toString());
        }
    }
}
