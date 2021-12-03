package CaseModule2.Main;

import CaseModule2.Controller.EmployeeManagerArrayList;
import CaseModule2.Model.Employee;
import CaseModule2.Model.FullTimeEmployee;
import CaseModule2.Model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        EmployeeManagerArrayList staff = new EmployeeManagerArrayList();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee());
        employees.add(new FullTimeEmployee());
        employees.add(new FullTimeEmployee());

        staff.setEmployeesArrayList(employees);
        staff.showAllEmployee();
        staff.sortBySalary();
        staff.showAllEmployee();


//        int index = inputId();
//        Employee employee = createNewEmployee();
//        staff.updateByIndex(index, employee);
//        staff.showAllEmployee();

//    int index = inputId();
//    staff.deleteByIndex(index);
//    staff.showAllEmployee();
}

    public static Employee createNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so gio lam viec: ");
        int hours = scanner.nextInt();
        Employee newE = new PartTimeEmployee(hours);
        return newE;
    }

    public static int inputId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao index:");
        int index = scanner.nextInt();
        return index;
    }
}
