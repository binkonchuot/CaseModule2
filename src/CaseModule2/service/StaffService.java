package CaseModule2.service;

import CaseModule2.io.ReadAndWriteStaff;
import CaseModule2.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffService {

   private List<Staff> staffs = new ArrayList<>();

    public StaffService() {
       staffs = ReadAndWriteStaff.readStaff() ;
    }

    public void save(Staff staff) {
        staffs.add(staff);
       ReadAndWriteStaff.writeStaff(staffs);
    }
    public List<Staff> findAll() {
        ReadAndWriteStaff.writeStaff(staffs);
        return staffs;
    }
    public void
    delete(int index) {
        staffs.remove(index);
        findAll();
    }
    public void edit(int index, Staff staff) {
        staffs.set(index, staff);
         ReadAndWriteStaff.writeStaff(staffs);
    }
    public int findIndexByName(String name){
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getName().equals(name)) {
                return i;
            }
        } return - 1;
    }
}
