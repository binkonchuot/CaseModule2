package CaseModule2.model;


public class PartTimeStaff extends Staff {
    public PartTimeStaff() {
    }

    public PartTimeStaff(String name, int age, String phone, String gender,
                         String address, double luongTong, int luongTime, double hours) {
        super(name, age, phone, gender, address, luongTime, hours);
    }


    @Override
    public String toString() {
        return "PartTimeStaff{" + super.toString()+ "}";
    }
}
