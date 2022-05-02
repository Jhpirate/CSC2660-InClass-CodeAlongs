package week_3_lash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class AggregationExample {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {

        LocalDateTime date = LocalDateTime.now();
        Student s1 = new Student(1,
                LocalDateTime.now(),
                "Jared",
                "Heeringa",
                new Address("123 Main St", "Batavia", "IL", "60510"),
                "Junior",
                3.5d,
                "Pizza",
                "Red");

        System.out.println(s1);

        Directory directory = Directory.getInstance();
        directory.getSchoolDirectory().add(new Student(directory.getSchoolDirectory().size(),
                LocalDateTime.of(2002, 1, 5, 0, 0),
                "Jared",
                "Heeringa",
                new Address("123 Main St", "Batavia", "IL", "60510"),
                "Junior",
                4.0d,
                "Pizza",
                "Red"));

        directory.getSchoolDirectory().add(new Student(directory.getSchoolDirectory().size(),
                LocalDateTime.of(2000, 12, 6, 0, 0),
                "Adam",
                "West",
                new Address("666 Batcave Ave", "Gotham", "NY", "60777"),
                "Senior",
                4.0d,
                "Chicken",
                "Blue"));

        System.out.println(directory);

    }
}
