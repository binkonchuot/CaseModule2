package CaseModule2.Controller;

import CaseModule2.Model.Employee;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeManagerArrayList {
    private ArrayList<Employee> employeesArrayList = new ArrayList<>();

    public ArrayList<Employee> getEmployeesArrayList() {
        return employeesArrayList;
    }

    public void setEmployeesArrayList(ArrayList<Employee> employeesArrayList) {
        this.employeesArrayList = employeesArrayList;
    }

    public void addNewEmployee(Employee newEmployee) {
        employeesArrayList.add(newEmployee);
    }

    public void deleteByIndex(int index) {
        employeesArrayList.remove(index);
    }

    public void updateByIndex(int index, Employee employee) {
        employeesArrayList.set(index, employee);
    }

    //Tinh Luong Trung Binh

//    public double getAverage() {
//        double sum = 0;
//        for (Employee e: employeesArrayList) {
//            sum += e.getSalary();
//        }
//        double average = sum/employeesArrayList.size();
//        return average;
//    }
    // Phuong thuc Liet ke danh sach nhan vien FullTime

    public void showAllEmployee() {
        for (Employee e : employeesArrayList) {
            System.out.println(e);
        }
    }

    // sap xep su dung interface comparator
    public void sortBySalary() {
        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() > o2.getSalary() ? 1 : -1;
            }
        };
        employeesArrayList.sort(employeeComparator);
//        Comparator.sort(employeesArrayList, employeeComparator);
    }
        // sap xep su dung interface compraable
        public void sortById(){
            Collections.sort(employeesArrayList);
    }
}