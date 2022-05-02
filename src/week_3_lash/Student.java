package week_3_lash;

import java.time.LocalDateTime;
import java.util.Date;

public class Student extends Person {
    private String grade;
    private double gpa;
    private String favouriteFood;
    private String favouriteColor;

    public Student(int id, LocalDateTime dateOfBirth, String firstName, String lastName, Address address, String grade, double gpa, String favouriteFood, String favouriteColor) {
        super(id, dateOfBirth, firstName, lastName, address);
        this.grade = grade;
        this.gpa = gpa;
        this.favouriteFood = favouriteFood;
        this.favouriteColor = favouriteColor;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    public void setFavouriteColor(String favouriteColor) {
        this.favouriteColor = favouriteColor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade='" + grade + '\'' +
                ", favouriteFood='" + favouriteFood + '\'' +
                ", favouriteColor='" + favouriteColor + '\'' +
                "} " + super.toString();
    }
}
