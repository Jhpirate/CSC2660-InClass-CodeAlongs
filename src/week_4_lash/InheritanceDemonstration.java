package week_4_lash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class InheritanceDemonstration {
    public static void main(String[] args) {
        ArrayList<Person> directory = new ArrayList<>();

        Student student1 = new Student(directory.size(), "Jared", "Smith", 3.8, 21, "Purple");
        directory.add(student1);

        Staff staff1 = new Staff(directory.size(), "Adam", "West", 100000d, "CSC4500");
        directory.add(staff1);

        System.out.println(Arrays.toString(directory.toArray()));

        System.out.println(staff1.showPersonSummary());
        System.out.printf("%s|%s%n", student1, student1.canDrive());
    }
}

class Person implements IPersonFormat {
    protected int id;
    private final String firstName;
    private final String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFullName() {
        return "%s: %s %s".formatted(this.getClass().getSimpleName(), this.firstName, this.lastName);
    }
}

class Student extends Person {
    private final double gpa;
    private int age;
    private final String favoriteColor;

    public Student(int id, String firstName, String lastName, double gpa, int age, String favoriteColor) {
        super(id, firstName, lastName);
        this.gpa = gpa;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }

    public boolean canDrive() {
//        return (this.age >= 16) ? true : false;
        // only allow 16+ to drive
        // disallow 100+ drivers
        // only allow those with J names to drive
        return this.age >= 16 && this.age < 101 && super.getFirstName().toUpperCase(Locale.ROOT).charAt(0) == ('J');
    }

    public void setAge(int age) {
        if ((age < 0) || (age > 140))
            this.age = -1;
        else
            this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", age=" + age +
                ", favoriteColor='" + favoriteColor + '\'' +
                "} " + super.toString();
    }
}

class Staff extends Person implements IPersonSummary {
    private final double salary;
    private final String favoriteClass;

    public Staff(int id, String firstName, String lastName, double salary, String favoriteClass) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.favoriteClass = favoriteClass;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "salary=$%,.2f".formatted(salary) +
                ", favoriteClass='" + favoriteClass + '\'' +
                "} " + super.toString();
    }

    @Override
    public String showPersonSummary() {
        return "%s Salary: %,.2f".formatted(super.getFullName(), this.salary);
    }
}

interface IPersonFormat {
    String getFullName();
}

interface IPersonSummary {
    String showPersonSummary();
}

//    private static void showAdult(Adult a1) {
//        System.out.printf("\n Person:%s Age:%s canDrive:%s income:$%,.2f taxOwed:$%,.2f",
//                a1.getName(), a1.getAge(), a1.canDrive(),
//                a1.getIncome(), a1.getTaxOwed());
//    }