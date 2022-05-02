package week_4_aggregation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AggregationPractice {
    public static void main(String[] args) {
        ArrayList<Student> students = getStudents();
        showStudents(students);
        ArrayList<Course> catalog = setCourseCatalog();

        //print catalog before sorting it
        showCatalog(catalog);

        // sort and print again
        Collections.sort(catalog); //uses comparable in the Course class
        showCatalog(catalog);

        updateStudent(students, 1, "CSC1700", catalog);
//        updateStudent(students, 2, "CSC1700");
//        updateStudent(students, 1, "CSC2660");
        showStudents(students);
//
        showCourseInfo("CSC2660", catalog);
        // Operations to do
        // Mark studentId 2 completed CSC2200
        // Mark studentId 3 completed CSC2300
        // all students completed CSC1700
    }

    private static void showCourseInfo(String courseId, ArrayList<Course> catalog) {
        //Todo: for a CourseId .. output all the data on it from the catalog
        System.out.print("\nResults Found: \n");
        for (Course course : catalog) {
            if (course.getcId().equals(courseId)) {
                System.out.printf("%s, %s, %s\n", course.getcId(), course.getcName(), course.getcDescription());
                return;
            }
        }

        System.out.print("No Results Found...\n");
    }

    private static boolean updateStudent(ArrayList<Student> students, int studentId, String courseId, ArrayList<Course> catalog) {
        /// Find the student with the ID and Add CourseIf to complete
        //ToDo: Write this method return true if found
        //    otherwise return false

        for (Student student : students) {
            if (student.getId() == studentId) {
                // get the course from the catalog
                for (Course course : catalog) {
                    if (course.getcId().equals(courseId)) {
                        student.getCoursesComplete().add(course.getcId());
                    }
                }
                return true;
            }
        }
        System.out.println("Student with specified ID not found!");
        return false;
    }

    private static void updateStudents(ArrayList<Student> students) {
        for (Student student : students) {
            student.addCompletedCoursed("CSC1700");
        }
    }

    private static void showCatalog(ArrayList<Course> catalog) {
        //ToDo: Show all the courses in the catalog
        System.out.print("\nCourse ID, Course Name, Course Description\n");
        for (Course course : catalog) {
            System.out.printf("%s, %s, %s\n", course.getcId(), course.getcName(), course.getcDescription());
        }
    }

    private static ArrayList<Course> setCourseCatalog() {
        //public Course(String cName, String cId, String cDescription)
        ArrayList<Course> catalog = new ArrayList<>();

        Course csc1700 = new Course("Intro to Programming", "CSC1700", "A first Course In Programming");
        catalog.add(csc1700);

        catalog.add(new Course("Intro to Web Dev", "CSC2200", "An introduction to web development with lots of fun stuff"));
        catalog.add(new Course("Capstone", "CSC4990", "Senior Capstone often a project"));
        catalog.add(new Course("Computer Architecture", "CSC2300", "An exploration of computer architectures with hands on activities"));
        catalog.add(new Course("Software Engineering", "CSC4350", "Software Engineering"));
        catalog.add(new Course("OOP Programming", "CSC2660", "A Second Course In Programming"));
        catalog.add(new Course("Data Structures Programming", "CSC3660", "A Third Course In Programming"));
        catalog.add(new Course("Introduction to databases", "CSC4550", "Database programming at its best"));

        return catalog;
    }

    private static void showStudents(ArrayList<Student> students) {
        //ToDo: Show all the info for a student
        System.out.print("\nID, Student Name, Student Address\n");
        for (Student student : students) {
            System.out.printf("%s, %s, %s, %s\n", student.getId(), student.getStudentName(), student.getStudentAddress(), Arrays.toString(student.getCoursesComplete().toArray()));
        }
    }

    private static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Joe B", new Address("1600 Pennsylvania Av", "Washingoton", "DC", "USA")));
        Address bakerAd = new Address("221b Baker Street", "London", "London", "England");
        students.add(new Student(2, "Sherlock Holmes", bakerAd));
        students.add(new Student(3, "John H. Watson", bakerAd));
        Address munsterAd = new Address("1313 MockingBird Heights", "LA", "California", "USA");
        students.add(new Student(4, "Hermon Munster", munsterAd));
        students.add(new Student(5, "Lilly Munster", munsterAd));

        return students;
    }
}

class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String country;

    Address(String streetAddress, String city, String st, String coun) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = st;
        this.country = coun;
    }

    public String getStreetNum() {
        return streetAddress;
    }

    public void setStreetNum(String streetNum) {
        this.streetAddress = streetNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{%s, %s, %s, %s}".formatted(streetAddress, city, state, country);
    }
}

// INNER STUDENT CLASS
class Student {
    private int id;
    private String studentName;
    //Creating HAS-A relationship with Address class
    private Address studentAddress;
    // A student has a completed list of course Ids
    private ArrayList<String> coursesComplete = new ArrayList<>();

    Student(int id, String name, Address add) {
        this.id = id;
        this.studentName = name;
        this.studentAddress = add;
    }

    public void addCompletedCoursed(String courseId) {
        coursesComplete.add(courseId);
    }

    public ArrayList<String> getCoursesComplete() {
        return coursesComplete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }
}

// INNER Course Class
class Course implements Comparable<Course> {
    //Todo: Make this class sortable by courseId
    private String cName;
    private String cId;
    private String cDescription;

    public Course(String cName, String cId, String cDescription) {
        this.cName = cName;
        this.cId = cId;
        this.cDescription = cDescription;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    //Todo: Implement comparable
    @Override
    public int compareTo(Course o) {
        return this.cId.compareTo(o.cId);
    }
}
