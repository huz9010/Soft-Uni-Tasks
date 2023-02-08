package RetakeExamAug2021.cafe;

public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString()    {
        return String.format("Employee: %s, %s from %s", this.name, this.age, this.country);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int compareTo(Employee e) {
        if (this.getAge() == e.getAge())    {
            return 0;
        } else if (this.age > e.getAge())   {
            return 1;
        }   else {
            return -1;
        }
    }
}
