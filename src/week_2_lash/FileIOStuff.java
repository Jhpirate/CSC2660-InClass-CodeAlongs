package week_2_lash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileIOStuff {
    public static void main(String[] args) {
        final String PATH = "./testFile.csv";
        try {
            ArrayList<Person> contents = readInFile(PATH);
            System.out.println(Arrays.toString(contents.toArray()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> readInFile(String fileName) throws FileNotFoundException {
        ArrayList<Person> fileContents = new ArrayList<>();
        File file = new File(fileName);
        Scanner inFile = new Scanner(file);

        while (inFile.hasNextLine()) {
            String[] contents = inFile.nextLine().split("[\\s,]+");
            fileContents.add(new Person(contents[0], Integer.parseInt(contents[1])));
        }

        return fileContents;
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}