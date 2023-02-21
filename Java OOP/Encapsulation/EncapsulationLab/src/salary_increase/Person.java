package salary_increase;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString()    {
        return String.format("%s %s gets %f leva", firstName, lastName, salary);
    }

    public void increaseSalary(double bonus)    {
        if (this.age < 30)  {
            salary = salary + salary * (bonus / 2) / 100;
        }   else {
            salary = salary + salary * bonus / 100;
        }
    }
}


