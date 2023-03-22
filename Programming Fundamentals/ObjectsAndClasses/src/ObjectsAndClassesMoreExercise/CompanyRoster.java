package ObjectsAndClassesMoreExercise;

import java.util.*;

public class CompanyRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Department> departments = new ArrayList<>();

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] employeeData = scanner.nextLine().split(" ");
            Employee employee = createEmployee(employeeData);

            String departmentName = employeeData[3];
            Department department = findDepartment(departments, departmentName);

            if (department == null) {
                department = new Department(departmentName);
                departments.add(department);
            }

            department.addEmployee(employee);
        }

        Department maxSalaryDep = getMaxSalaryDep(departments);

        System.out.println("Highest Average Salary: " + maxSalaryDep.getName());
        maxSalaryDep.getEmployees().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);


    }

    private static Department getMaxSalaryDep(List<Department> departments) {
        double max = 0;
        Department maxDepartment = null;
        for (Department department : departments) {
            if (department.getAvgSalary() > max) {
                max = department.getAvgSalary();
                maxDepartment = department;
            }
        }
        return maxDepartment;
    }

    private static Department findDepartment(List<Department> departments, String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }

    private static Employee createEmployee(String[] employeeData) {
        String name = employeeData[0];
        double salary = Double.parseDouble(employeeData[1]);
        String position = employeeData[2];
        String department = employeeData[3];
        String email = "";
        int age = 0;

        if (employeeData.length == 5) {
            if (employeeData[4].contains("@")) {
                email = employeeData[4];
            } else {
                age = Integer.parseInt(employeeData[4]);
            }
        } else if (employeeData.length == 6) {
            email = employeeData[4];
            age = Integer.parseInt(employeeData[5]);
        }

        return new Employee(name, salary, position, department, email, age);
    }

    private static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;
        private static final String NULL_MAIL = "n/a";
        private static final int NULL_AGE = -1;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            setEmail(email);
            setAge(age);
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }

        public double getSalary() {
            return salary;
        }

        public void setEmail(String email) {
            if (email.isEmpty()) {
                this.email = NULL_MAIL;
            } else {
                this.email = email;
            }
        }

        public void setAge(int age) {
            if (age == 0) {
                this.age = NULL_AGE;
            } else {
                this.age = age;
            }
        }
    }

    private static class Department {
        private String name;
        private Collection<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(Employee employee) {
            this.employees.add(employee);
        }

        public double getAvgSalary() {
            return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        }

        public String getName() {
            return name;
        }

        public Collection<Employee> getEmployees() {
            return employees;
        }
    }
}