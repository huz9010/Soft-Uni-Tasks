package RetakeExamAug2021.cafe;

import java.util.*;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee)  {
        if (employees.size() < capacity)    {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name)  {
        for (Employee e : employees)  {
            if (e.getName().equals(name))   {
                employees.remove(e);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return Collections.max(employees);
    }

    public Employee getEmployee(String name)    {
        for (Employee e : employees)    {
            if (e.getName().equals(name))   {
                return e;
            }
        }
        return null;
    }

    public int getCount()   {
        return employees.size();
    }

    public String report()  {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe :", this.name)).append(System.lineSeparator());
        for (Employee e : employees)    {
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
