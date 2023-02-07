package EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person>   {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.equals(person.getName()) && this.age == person.getAge()) {
            return 0;
        }
        return Integer.compare(this.name.compareTo(person.getName()), Integer.compare(this.age, person.getAge()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
