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
        System.out.println("****************************************");
        System.out.println("**         1. Thêm nhân viên          **");
        System.out.println("**         2. Sửa nhân viên           **");
        System.out.println("**         3. Xóa nhân viên           **");
        System.out.println("**         4. Hiển Thị nhân viên      **");
        System.out.println("**         5. Thoát chương trình      **");
        System.out.println("**             #Mời Chọn#             **");
        System.out.println("****************************************");
        return scanner.nextLine();
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
    public String menuAdd(){
        System.out.println("****************************************");
        System.out.println("**    1. Thêm nhân viên FullTime      **");
        System.out.println("**    2. Thêm nhân viên PartTime      **");
        System.out.println("**             #Mời Chọn#             **");
        System.out.println("****************************************");
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
                System.err.println("Yêu cầu số tuổi đúng quy định từ 18 - 50!");
                return validateNumber();
            }
            return tuoi;
        } catch (Exception e) {
            System.err.println("Mời nhập số!");
            return validateNumber();
        }
    }
    public int validateLuongHours() {
        try {
            String luongTime = scanner.nextLine();
            int luong = Integer.parseInt(luongTime);
            if (luong < 1000 ) {
                System.err.println("Nhập số tiền > 1000 VND!");
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
            System.err.println("Vui lòng nhập số và đủ dãy số điện thoại !");
            regex=validatePhone();
        }
        return regex;
    }
    public double validateHeSoLuong() {
        try {
            String coefficients = scanner.nextLine();
            double heSoLuong = Double.parseDouble(coefficients);
            if (heSoLuong < 0 || heSoLuong > 10) {
                System.err.println(" Yêu cầu Hệ Số Lương đúng quy định từ 1.0 - 10.0! ");
                return validateHeSoLuong();
            }
            return heSoLuong;
        } catch (Exception e) {
            System.err.println("Mời nhập số!");
            return validateHeSoLuong();
        }
    }
    public String validateGender() {
        String gender = scanner.nextLine();
        switch (gender) {
            case "Nam":
            case "Nữ":
            case "NAM":
            case "NỮ":
            case "nam":
            case "nữ":
                return gender;
            default:
                System.err.println("Mời nhập lại đúng ký tự chữ và có dấu!");
                validateGender();
        }
        return null;
    }
    private double validateGioLam() {
        try {
            String timeWork = scanner.nextLine();
            double gioLam = Double.parseDouble(timeWork);
            if (gioLam < 0 ) {
                System.err.println("Vui lòng nhập lại!");
                return validateGioLam();
            }
            return gioLam;
        } catch (Exception e) {
            System.err.println("VUI LONG NHAP SO!");
            return validateGioLam();
        }
    }
}
