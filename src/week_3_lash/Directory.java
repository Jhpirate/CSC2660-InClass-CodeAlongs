package week_3_lash;

import java.util.ArrayList;
import java.util.Arrays;

public final class Directory {
    private static Directory instance;
    private static ArrayList<Person> schoolDirectory;

    private Directory() {
        schoolDirectory = new ArrayList<>();
    }

    // Singleton Method
    // Only allow one instance of this class
    // https://refactoring.guru/design-patterns/singleton/java/example
    public static Directory getInstance() {
        if (instance == null) {
            instance = new Directory();
        }

        return instance;
    }

    public ArrayList<Person> getSchoolDirectory() {
        return schoolDirectory;
    }

    public void setSchoolDirectory(ArrayList<Person> schoolDirectory) {
        Directory.schoolDirectory = schoolDirectory;
    }

    @Override
    public String toString() {
        return (Arrays.toString(schoolDirectory.toArray()));
    }
}
