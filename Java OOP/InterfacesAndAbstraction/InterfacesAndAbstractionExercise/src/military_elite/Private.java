package military_elite;

public class Private extends Soldier implements PrivateInterface{

    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        setSalary(salary);
    }

    private void setSalary(double salary)   {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString()    {
        return String.format("Name: %s %s Id: %d Salary: %.2f%n", super.getFirstName(), super.getLastName(), super.getId(), salary);
    }
}
