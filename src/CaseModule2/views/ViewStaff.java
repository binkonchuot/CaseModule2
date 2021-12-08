package CaseModule2.views;

import CaseModule2.controller.ControllerStaff;
import CaseModule2.model.FullTimeStaff;
import CaseModule2.model.PartTimeStaff;
import CaseModule2.model.Staff;
import CaseModule2.service.StaffService;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewStaff {
    static ControllerStaff controller = new ControllerStaff();
    Scanner scanner = new Scanner(System.in);
    static StaffService staffService = new StaffService();

    public String menuUser(){
        System.out.println("************************************************");
        System.out.println("**        # Please Choose from Menu #         **");
        System.out.println("**               1. Add Staff                 **");
        System.out.println("**               2. Edit staff                **");
        System.out.println("**               3. Delete employee           **");
        System.out.println("**               4. Show staff                **");
        System.out.println("**               5. Exit the program          **");
        System.out.println("************************************************");
        return scanner.nextLine();
    }

    public String menuAdmin(){
        System.out.println("************************************************");
        System.out.println("**        # Please Choose from Menu #         **");
        System.out.println("**               1. Edit Account              **");
        System.out.println("**               2. Delete Account            **");
        System.out.println("**               3. Show Account              **");
        System.out.println("**               4. Log Out                   **");
        System.out.println("************************************************");
        return scanner.nextLine();
    }
    public String menuAdd(){
        System.out.println("************************************************");
        System.out.println("**               # Please Choose #            **");
        System.out.println("**            1. Add Full Time Staff          **");
        System.out.println("**            2. Add Part Time Staff          **");
        System.out.println("************************************************");
        return scanner.nextLine();
    }
    public String inputName(){
        System.out.println("1. Input Name ");
        return scanner.nextLine();
    }
    public String inputNameAcc(){
        System.out.println("1. Input UserName ");
        return scanner.nextLine();
    }
    public Staff createStaff(boolean isFullTimeStaff) {
        System.out.println("Input Name: ");
        String name = validateName();
        System.out.println("Input Age: ");
        int age = validateNumber();
        System.out.println("Input PhoneNumber: ");
        String phone = validatePhone();
        System.out.println("Input Gender: ");
        String gender = validateGender();
        System.out.println("Input Address: ");
        String address = scanner.nextLine();
        System.out.println("Input Hourly: ");
        int luongTime = validateLuongHours();
        System.out.println("Input HoursWork: ");
        double hours = validateGioLam();

        double luongTong = 1;
        if(isFullTimeStaff) {
            System.out.println("Input Coefficients");
            double coefficients = validateHeSoLuong();
            return new FullTimeStaff(name,age,phone,gender,address,luongTime,hours,coefficients);
        } else {
            return new PartTimeStaff(name,age,phone,gender,address,luongTong,luongTime,hours);
        }
    }
    public void show(List<Staff> staffs) {
        for (Staff h: staffs) {
            System.out.println(h.toString());
        }
    }
    public String validateName() {
     String name = scanner.nextLine();
        for (int i = 0; i < staffService.findAll().size(); i++) {
            if (staffService.findAll().get(i).getName().equalsIgnoreCase(name)) {
            System.err.println("* Duplicate name! Pease re-enter another name *");
            return validateName();}
        }
        return name;
    }
    private static final String ACCOUNT_REGEX = "[0]\\d{8,11}";

    public String validatePhone() {
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            return regex;
        } else {
            System.err.println(" Phone numbers starting with 0 And have between 10 and 13 numbers! ");
            regex=validatePhone();
        }
        return regex;
    }
    public int validateNumber() {
        try {
            String age = scanner.nextLine();
            int tuoi = Integer.parseInt(age);
            if (tuoi < 18 || tuoi > 50) {
                System.err.println("Age regulation from 18 to 50!");
                return validateNumber();
            }
            return tuoi;
        } catch (Exception e) {
            System.err.println("Requires input number!");
            return validateNumber();
        }
    }
    public int validateLuongHours() {
        try {
            String luongTime = scanner.nextLine();
            int luong = Integer.parseInt(luongTime);
            if (luong < 1000 ) {
                System.err.println("Money regulation > 1000 VND!");
                return validateLuongHours();
            }
            return luong;
        } catch (Exception e) {
            System.err.println("Requires input number!");
            return validateLuongHours();
        }
    }
    public double validateHeSoLuong() {
        try {
            String coefficients = scanner.nextLine();
            double heSoLuong = Double.parseDouble(coefficients);
            if (heSoLuong < 1.3 || heSoLuong > 9.0) {
                System.err.println(" Regulations on Salary Coefficient applied in 2021 from 1.3 -> 9.0! ");
                return validateHeSoLuong();
            }
            return heSoLuong;
        } catch (Exception e) {
            System.err.println("Requires input number!");
            return validateHeSoLuong();
        }
    }
    public String validateGender() {
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("male")) return "Male";
            if (gender.equalsIgnoreCase("female")||gender.equalsIgnoreCase("Female")) return "Female";
            System.err.println("Rules for entering male or female characters!");
        }
    }
    private double validateGioLam() {
        try {
            String hours = scanner.nextLine();
            double gioLam = Double.parseDouble(hours);
            if (gioLam < 0 ) {
                System.err.println("Requires re-entry!");
                return validateGioLam();
            }
            return gioLam;
        } catch (Exception e) {
            System.err.println("Requires input number!");
            return validateGioLam();
        }
    }
}
