import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Comparable<Person>,User {
    private String name;
    private int age;
    private String username;

    Person(String name) {
        this.name = name;
        this.age = 0;
        this.username = name;
    }

    Person(String name,int age) {
        this.name = name;
        this.age = age;
        this.username = name + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String toString();

    public boolean equals(Object o) {
        return this.name.equals(((Person)o).getName());
    }

    public int compareTo(Person p1) {
        return this.name.compareTo(p1.getName());
    }

    @Override
    public String getUsername() {
        return username;
    }
}
