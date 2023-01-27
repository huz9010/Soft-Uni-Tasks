import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            Employee employee = new Employee(name, salary, position, department);

            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                    employee.setEmail(input[4]);
                    employee.setAge(Integer.parseInt(input[5]));
                    break;
            }
            boolean departmentExists = departments.stream().anyMatch(d -> d.getName().equals(department));

            if (!departmentExists)  {
                departments.add(new Department(department));
            }

            Department currentDep = departments.stream().filter(d -> d.getName().equals(employee.getDepartment())).findFirst().get();
            currentDep.getEmployees().add(employee);
        }

        Department highestAvgDep = departments.stream().max(Comparator.comparingDouble(Department::getAverage)).get();

        System.out.println("Highest Average Salary: " + highestAvgDep.getName());

        highestAvgDep.getEmployees().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
    }
}
