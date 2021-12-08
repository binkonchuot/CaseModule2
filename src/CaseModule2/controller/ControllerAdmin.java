package CaseModule2.controller;
import CaseModule2.views.ViewStaff;

public class ControllerAdmin {
    public static void menuManagerAdmin() {
        ViewStaff viewStaff = new ViewStaff();
        while (true) {
            String choice = viewStaff.menuAdmin();
        }
    }
}
