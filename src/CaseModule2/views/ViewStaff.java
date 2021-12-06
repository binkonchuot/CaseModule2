package CaseModule2.views;

import CaseModule2.model.FullTimeStaff;
import CaseModule2.model.PartTimeStaff;
import CaseModule2.model.Staff;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;
import java.util.Scanner;

public class ViewStaff {
    Scanner scanner = new Scanner(System.in);

    public int menu(){
        System.out.println("1. Them");
        System.out.println("2. Sua");
        System.out.println("3. Xoa");
        System.out.println("4. Show");
        return Integer.parseInt(scanner.nextLine());
    }
    public int menuAdd(){
        System.out.println("1. Them Nhan Vien FullTime ");
        System.out.println("2. Them Nhan Vien PartTime");
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputName(){
        System.out.println("1. Nhap Name ");
        return scanner.nextLine();
    }
    public Staff createStaff(boolean isFullTimeStaff) {
        System.out.println("Nhap name");
        String name = scanner.nextLine();
        System.out.println("Nhap age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap phone");
        String phone = scanner.nextLine();
        System.out.println("Nhap gender");
        String gender = scanner.nextLine();
        System.out.println("Nhap address");
        String address = scanner.nextLine();
        System.out.println("Nhap luongTime");
        int luongTime = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap gio lam: ");
        double hours = Double.parseDouble(scanner.nextLine());

        if(isFullTimeStaff) {
            System.out.println("Nhap coefficients");
            double coefficients = Double.parseDouble(scanner.nextLine());
            return new FullTimeStaff(name,age,phone,gender,address,luongTime,coefficients);
        } else {
            return new PartTimeStaff(name,age,phone,gender,address,luongTime);
        }
    }
    public void show(List<Staff> staffs) {
        for (Staff h: staffs) {
            System.out.println(h.toString());
        }
    }
}
