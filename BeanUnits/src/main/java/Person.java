import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private Person spouse;
    private int age;
    private String name;

    public Person getSpouse() {
        return spouse;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
