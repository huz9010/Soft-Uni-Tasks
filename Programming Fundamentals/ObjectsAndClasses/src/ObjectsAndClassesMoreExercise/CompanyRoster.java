package ObjectsAndClassesMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyRoster {
    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        String age;

        public void setEmployee(String name, double salary, String position, String department, String email, String age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] employeeData = scanner.nextLine().split(" ");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            String email = "";
            String age = "";

            if (employeeData.length == 4)   {
                email = "n/a";
                age = "-1";
            } else if (employeeData.length == 5 && employeeData[4].contains("@")) {
                email = employeeData[4];
                age = "-1";
            } else if (employeeData.length == 6) {
                email = employeeData[4];
                age = employeeData[5];
            }   else {
                email = "n/a";
                age = employeeData[5];
            }
            Employee currentEmployee = new Employee();
            currentEmployee.setEmployee(name, salary, position, department, email, age);
            employeeList.add(currentEmployee);
        }

    }
}
