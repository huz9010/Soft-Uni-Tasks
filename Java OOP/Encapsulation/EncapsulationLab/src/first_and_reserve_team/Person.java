package first_and_reserve_team;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
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

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        } else {
            this.lastName = lastName;
        }
    }

    public void setAge(int age) {
        if (age <= 0)   {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }   else {
            this.age = age;
        }
    }

    public void setSalary(double salary) {
        if (salary < 460)   {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }   else {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", firstName, lastName, salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            salary = salary + salary * (bonus / 2) / 100;
        } else {
            salary = salary + salary * bonus / 100;
        }
    }
}
