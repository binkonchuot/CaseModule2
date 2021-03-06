package CaseModule2.controller;

import CaseModule2.model.FullTimeStaff;
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
                 case "3":
                     count = 0;
                     while (true) {
                         index = staffService.findIndexByName(viewStaff.inputName());
                         count++;
                         if (index == -1) {
                             System.err.println("---> No find Name!");
                             System.err.println("---> Wrong more than 3 times, Please re-enter!");
                             if (count==4){
                                 System.err.println("**        Enter incorrectly 3 times,Please re-enter!       **");
                                 break;
                             }
                         } else {
                             staffService.delete(index);
                             System.err.println("**                   Deleted!                 **");
                             break;
                         }
                     }
                     break;
                 case "4":
                     viewStaff.show(staffService.findAll());
                     break;
                 case "5":
                     System.err.println("**              Request Selection!            **");
                     return;
                 default:
                     System.err.println("**    Requires entering the correct option!   **");
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
                System.err.println("**  Requires entering the correct option! **");
                add(viewStaff,staffService);
        }
    }

}