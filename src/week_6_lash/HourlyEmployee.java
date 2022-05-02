package week_6_lash;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(int id, String employeeType, String empName, double hourlyRate, double hoursWorked) {
        super(id, employeeType, empName);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double GetPayment() {
        return hourlyRate * hoursWorked;
    }
}
