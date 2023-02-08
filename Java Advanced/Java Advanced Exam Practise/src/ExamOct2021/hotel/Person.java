package ExamOct2021.hotel;

public class Person {

    String HOMETOWN_DEFAULT_VALUE = "n/a";
    private String name;
    private int id;
    private int age;
    private String hometown = HOMETOWN_DEFAULT_VALUE;

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    @Override
    public String toString()    {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }
}
