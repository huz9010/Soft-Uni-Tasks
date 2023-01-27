import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public double getAverage()  {
        return this.employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name)    {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }
}
