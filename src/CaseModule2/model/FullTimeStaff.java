package CaseModule2.model;

public class FullTimeStaff extends Staff {
    private double coefficients;

    public FullTimeStaff(double coefficients) {
        this.coefficients = coefficients;
    }

    public FullTimeStaff(String name, int age, String phone, String gender, String address, double luongTong, int luongTime, double hours, double coefficients) {
        super(name, age, phone, gender, address, luongTong, luongTime, hours);
        this.coefficients = coefficients;
    }
    public double getCoefficients() {
        return coefficients;
    }
    public void setCoefficients(double coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public double getLuongtong() {
        return super.getLuongtong() * coefficients;
    }

    @Override
    public String toString() {
        return "FullTimeStaff{" + super.toString() +
                "coefficients=" + coefficients +
                '}';
    }
}
