package CaseModule2.model;


public class PartTimeStaff extends Staff {
    public PartTimeStaff() {
    }

    public PartTimeStaff(String name, int age, String phone, String gender,
                         String address, int luongTime) {
        super(name, age, phone, gender, address, luongTime);
    }

    @Override
    public String toString() {
        return "PartTimeStaff{}" + super.toString();
    }
}
