package week_6_lash;

public abstract class Employee implements Comparable<Employee> {
    protected int id;
    protected String employeeType;
    protected String empName;

    public Employee(int id, String employeeType, String empName) {
        this.id = id;
        this.employeeType = employeeType;
        this.empName = empName;
    }

    abstract double GetPayment();

    @Override
    public int compareTo(Employee o) {
        return employeeType.compareTo(o.employeeType);
    }
}
