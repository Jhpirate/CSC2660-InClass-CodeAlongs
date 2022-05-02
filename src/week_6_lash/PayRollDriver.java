package week_6_lash;

import java.util.ArrayList;
import java.util.Collections;

public class PayRollDriver {
    public static void main(String[] args) {
        ArrayList<Employee> employees = addEmployees();
        Collections.sort(employees);

        for (Employee e : employees) {
            System.out.printf("%s | %s | $%,.2f\n", e.empName, e.employeeType, e.GetPayment());
        }
        System.out.printf("$%,.2f", 123456676.434);

    }

    private static ArrayList<Employee> addEmployees() {
        return new ArrayList<>() {{
            add(new HourlyEmployee(size(), "Hourly", "James Smith", 10.00, 25));
            add(new SalaryEmployee(size(), "Salary", "Adam West", 100000, 12));
            add(new HourlyEmployee(size(), "Hourly", "Tim Burton", 25.00, 32.5));
            add(new SalaryEmployee(size(), "Salary", "Rich Butter", 250000, 52));
            add(new SalaryEmployee(size(), "Salary", "Vanessa Moss", 50000, 12));
            add(new HourlyEmployee(size(), "Hourly", "David Lash", 12.50, 40));
        }};
    }
}
