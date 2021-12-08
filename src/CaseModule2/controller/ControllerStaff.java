package CaseModule2.controller;

import CaseModule2.model.FullTimeStaff;
import CaseModule2.model.Staff;
import CaseModule2.service.StaffService;
import CaseModule2.views.ViewStaff;

public class ControllerStaff {
    public static void menuManagerUser() {
        ViewStaff viewStaff = new ViewStaff();
        StaffService staffService = new StaffService();
        int index;
        while (true) {
             String choice = viewStaff.menuUser();
             switch (choice) {
                 case "1":
                     add(viewStaff, staffService);
                     break;
                 case "2":
                     int count=0;
                     while (true) {
                         index = staffService.findIndexByName(viewStaff.inputName());
                         count++;
                         if (index != -1) {
                             if (staffService.findAll().get(index) instanceof FullTimeStaff) {
                                 staffService.edit(index, viewStaff.createStaff(true));
                             } else {
                                 staffService.edit(index, viewStaff.createStaff(false));
                             }
                             System.err.println("**                 Đã sửa xong!               **");
                             break;
                         } else {
                             System.err.println("---> No find Name!");
                             System.err.println("---> Nếu sai quá 3 lần, mời nhập lại!");
                             if (count == 4) {
                                 System.err.println("**        Nhập sai 3 lần, mời nhập lại!       **");
                                 break;
                             }
                     }
                     }
                    break;
                 case "3":
                     count = 0;
                     while (true) {
                         index = staffService.findIndexByName(viewStaff.inputName());
                         count++;
                         if (index == -1) {
                             System.err.println("---> No find Name!");
                             System.err.println("---> Nếu sai quá 3 lần, mời nhập lại!");
                             if (count==4){
                                 System.err.println("**        Nhập sai 3 lần, mời nhập lại!       **");
                                 break;
                             }
                         } else {
                             staffService.delete(index);
                             System.err.println("**                 Đã xóa xong!               **");
                             break;
                         }
                     }
                     break;
                 case "4":
                     viewStaff.show(staffService.findAll());
                     break;
                 case "5":
                     return;
                 default:

                     System.err.println("**         Yêu cầu nhập đúng lựa chọn!        **");
//                     System.out.println("************************************************");
             }
          }
    }

    private static void add(ViewStaff viewStaff, StaffService staffService) {
        String choiceAdd = viewStaff.menuAdd();
        switch (choiceAdd) {
            case "1":
                staffService.save(viewStaff.createStaff(true));
                break;
            case "2":
                staffService.save(viewStaff.createStaff(false));
                break;
            default:
//                System.out.println("***********************************************");
                System.err.println("**         Yêu cầu nhập đúng lựa chọn!       **");
                add(viewStaff,staffService);
        }
    }

    public static void menuManagerAdmin() {
        ViewStaff viewStaff = new ViewStaff();
        while (true) {
            int choice = viewStaff.menuAdmin();
    }
}
}