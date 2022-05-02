package week_6_lash;

public class SalaryEmployee extends Employee {
    private double salary;
    private int payPeriod;

    public SalaryEmployee(int id, String employeeType, String empName, double salary, int payPeriod) {
        super(id, employeeType, empName);
        this.salary = salary;
        this.payPeriod = payPeriod;
    }

    @Override
    double GetPayment() {
        return salary / payPeriod;
    }
}
