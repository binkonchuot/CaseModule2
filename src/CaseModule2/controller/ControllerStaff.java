package CaseModule2.controller;

import CaseModule2.model.FullTimeStaff;
import CaseModule2.service.StaffService;
import CaseModule2.views.ViewStaff;

public class ControllerStaff {
    public static void menuManagerUser() {
        ViewStaff viewStaff = new ViewStaff();
        StaffService staffService = new StaffService();
         while (true) {
             int choice = viewStaff.menuUser();
             switch (choice) {
                 case 1:
                     int choiceAdd = viewStaff.menuAdd();
                     switch (choiceAdd) {
                         case 1:
                             staffService.save(viewStaff.createStaff(true));
                             break;
                         case 2:
                             staffService.save(viewStaff.createStaff(false));
                             break;
                     }
                     break;
                 case 2:
                     int index = staffService.findIndexByName(viewStaff.inputName());
                    if (index != -1) {
                        if (staffService.findAll().get(index) instanceof FullTimeStaff) {
                           staffService.edit(index, viewStaff.createStaff(true));
                        } else {
                            staffService.edit(index, viewStaff.createStaff(false));
                        }
                    }
                 case 3:
                 case 4:
                     viewStaff.show(staffService.findAll());
                     break;
                 case 5:
                     return;
             }
         }
    }
    public static void menuManagerAdmin() {
        ViewStaff viewStaff = new ViewStaff();
        while (true) {
            int choice = viewStaff.menuAdmin();
    }
}}