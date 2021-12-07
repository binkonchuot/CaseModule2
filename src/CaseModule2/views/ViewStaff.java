package CaseModule2.views;

import CaseModule2.controller.ControllerStaff;
import CaseModule2.model.FullTimeStaff;
import CaseModule2.model.PartTimeStaff;
import CaseModule2.model.Staff;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewStaff {
    static ControllerStaff controller = new ControllerStaff();
    Scanner scanner = new Scanner(System.in);

    public String menuUser(){
        System.out.println("************************************************");
        System.out.println("**             # Mời Lựa Chọn #               **");
        System.out.println("**             1. Thêm nhân viên              **");
        System.out.println("**             2. Sửa nhân viên               **");
        System.out.println("**             3. Xóa nhân viên               **");
        System.out.println("**             4. Hiển thị nhân viên          **");
        System.out.println("**             5. Thoát chương trình          **");
        System.out.println("************************************************");
        return scanner.nextLine();
    }

    public int menuAdmin(){
        System.out.println("************************************************");
        System.out.println("**              # Mời Lựa Chọn #              **");
        System.out.println("**               1. Sửa Account               **");
        System.out.println("**               2. Xóa Account               **");
        System.out.println("**               3. Show Account              **");
        System.out.println("**               4. Log Out                   **");
        System.out.println("************************************************");
        return Integer.parseInt(scanner.nextLine());
    }
    public String menuAdd(){
        System.out.println("************************************************");
        System.out.println("**               #Mời Lựa Chọn#               **");
        System.out.println("**         1. Thêm nhân viên FullTime         **");
        System.out.println("**         2. Thêm nhân viên PartTime         **");
        System.out.println("************************************************");
        return scanner.nextLine();
    }

    public String inputName(){
        System.out.println("1. Nhập Name ");
        return scanner.nextLine();
    }
    public Staff createStaff(boolean isFullTimeStaff) {
        System.out.println("Nhập Name: ");
        String name = scanner.nextLine();
        System.out.println("Nhập Age: ");
        int age = validateNumber();
        System.out.println("Nhập PhoneNumber: ");
        String phone = validatePhone();
        System.out.println("Nhập Gender: ");
        String gender = validateGender();
        System.out.println("Nhập Address: ");
        String address = scanner.nextLine();
        System.out.println("Nhập Lương theo giờ làm: ");
        int luongTime = validateLuongHours();
        System.out.println("Nhập Số giờ làm: ");
        double hours = validateGioLam();

        double luongTong = 1;
        if(isFullTimeStaff) {
            System.out.println("Nhập Hệ số lương");
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

//    public String validateName() {
//        String regex = scanner.nextLine();
//        if (controller.checkName(regex)) {
//            System.err.println("DA TON TAI TEN NAY");
//            validateName();
//        }
//        final String ACCOUNT_REGEX = ("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
//                "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
//                "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
//        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
//        Matcher matcher = pattern.matcher(regex);
//        if (matcher.matches()) {
//            return regex;
//        } else {
//            System.err.println("VUI LONG NHAP LAI!");
//            validateName();
//        }
//        return null;
//    }
    public int validateNumber() {
        try {
            String age = scanner.nextLine();
            int tuoi = Integer.parseInt(age);
            if (tuoi < 18 || tuoi > 50) {
                System.err.println("Quy định tuổi từ 18 - 50!");
                return validateNumber();
            }
            return tuoi;
        } catch (Exception e) {
            System.err.println("Yêu cầu nhập số!");
            return validateNumber();
        }
    }
    public int validateLuongHours() {
        try {
            String luongTime = scanner.nextLine();
            int luong = Integer.parseInt(luongTime);
            if (luong < 1000 ) {
                System.err.println("Quy định tiền > 1000 VND!");
                return validateLuongHours();
            }
            return luong;
        } catch (Exception e) {
            System.err.println("Yêu cầu nhập số!");
            return validateLuongHours();
        }
    }
    private static final String ACCOUNT_REGEX = "[0]\\d{8,11}";

    public String validatePhone() {
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            return regex;
        } else {
            System.err.println(" Số điện thoại bắt đầu số 0 và < 13 số! ");
            regex=validatePhone();
        }
        return regex;
    }
    public double validateHeSoLuong() {
        try {
            String coefficients = scanner.nextLine();
            double heSoLuong = Double.parseDouble(coefficients);
            if (heSoLuong < 0 || heSoLuong >= 10) {
                System.err.println(" Quy định Hệ Số Lương từ 0.1 - 10.0! ");
                return validateHeSoLuong();
            }
            return heSoLuong;
        } catch (Exception e) {
            System.err.println("Yêu cầu nhập số!");
            return validateHeSoLuong();
        }
    }
    public String validateGender() {
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("nam")) return "Nam";
            if (gender.equalsIgnoreCase("nu")||gender.equalsIgnoreCase("nữ")) return "Nữ";
            System.err.println("Quy định nhập chữ Nam hoặc Nữ!");
        }
    }
    private double validateGioLam() {
        try {
            String timeWork = scanner.nextLine();
            double gioLam = Double.parseDouble(timeWork);
            if (gioLam < 0 ) {
                System.err.println("Yêu cầu nhập lại!");
                return validateGioLam();
            }
            return gioLam;
        } catch (Exception e) {
            System.err.println("Yêu cầu nhập số!");
            return validateGioLam();
        }
    }
}
