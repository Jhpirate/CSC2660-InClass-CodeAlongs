package week_5_lash_polymorphism;

import java.util.ArrayList;

public class PolymorphicPersonExample {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>() {{
            add(new Student("Adam West", 22, "Criminal Justice"));
            add(new ComputerScienceStudent("James Moss", 24, "Dell XPS 15 9510"));
            add(new EarthScienceStudent("Harvey Dent", 32, "Volcanic Eruptions"));
        }};

        for(Person p : personList) {
            p.greetPerson();
        }
    }
}

abstract class Person {
    protected final String name;
    protected final int age;

    protected Person() {
        this.name = "NOT-SET";
        this.age = -1;
    }

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greetPerson() {
        System.out.printf("Hello there, %s\n", name);
    }
}

class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void greetPerson() {
        System.out.printf("Hello there student, %s. I see you are studying %s!\n", name, major);
    }
}

class ComputerScienceStudent extends Student {
    private final String computerType;

    public ComputerScienceStudent(String name, int age, String computerType) {
        super(name, age, "Computer Science");
        this.computerType = computerType;
    }

    @Override
    public void greetPerson() {
        System.out.printf("%s the computer science student used a %s. Nice choice!\n", name, computerType);
    }
}

class EarthScienceStudent extends Student {
    private final String researchPath;

    public EarthScienceStudent(String name, int age, String researchPath) {
        super(name, age, "Earth Science");
        this.researchPath = researchPath;
    }

    @Override
    public void greetPerson() {
        System.out.printf("Cool you are an earth Science student studying: %s\n", researchPath);
    }
}
