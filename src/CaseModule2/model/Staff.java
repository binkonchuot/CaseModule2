package CaseModule2.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private String name;
    private int age;
    private String phone;
    private String gender;
    private String address;
    private boolean status = true;
    private double luongTong;
    private int luongTime;
    private double hours;

    public Staff() {
    }

    public Staff(String name, int age, String phone, String gender, String address,
                  int luongTime, double hours) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.luongTime = luongTime;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public double getLuongtong() {
        luongTong=luongTime*hours;
        return luongTong ;
    }
    public int getLuongTime() {
        return luongTime;
    }
    public void setLuongTime(int luongTime) {
        this.luongTime = luongTime;
    }
    public double getHours() {
        return hours;
    }
    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return
                "Name = " + name + "" +
                ", Age = " + age + "" +
                ", PhoneNumber = " + phone + "" +
                ", Gender = " + gender + ",\n" +
                " Address = " + address + "" +
                ", Status = " + status + "" +
                ", WorkingTime = " + hours + "h" +
                ", HourlyIncome = " + luongTime + " VND" + "" +
                ", Salary = " + getLuongtong() + " VND";
    }
}
