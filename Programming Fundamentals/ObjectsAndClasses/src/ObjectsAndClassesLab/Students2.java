package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {

        static class Student {
            private String firstName;
            private String lastName;
            private String age;
            private String city;

            public void setStudent(String firstName, String lastName, String age, String city) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
                this.city = city;
            }

            public String getFirstName() {

                return this.firstName;
            }

            public String getLastName() {

                return this.lastName;
            }

            public String getAge() {

                return this.age;
            }

            public String getCity() {
                return this.city;
            }
        }
        private static boolean StudentExists (List<Student> studentList, String firstName, String lastName) {
            for (Student element : studentList) {
                if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                    return true;
                }
            }
            return false;
        }
        private static Student getStudent(List<Student> studentList, String firstName, String lastName)    {
            Student existingStudent = null;
            for (Student element : studentList) {
                if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                    existingStudent = element;
                }
            }
            return existingStudent;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            List<Student> studentList = new ArrayList<>();
            String input = scanner.nextLine();

            while (!input.equals("end"))    {
                String[] studentData = input.split(" ");
                String firstName = studentData[0];
                String lastName = studentData[1];
                String age = studentData[2];
                String city = studentData[3];
                Student currentStudent = new Student();

                if (StudentExists(studentList, firstName, lastName))    {
                    Student student = getStudent(studentList, firstName, lastName);
                    student.setStudent(firstName, lastName, age, city);
                }   else {
                    currentStudent.setStudent(firstName, lastName, age, city);
                    studentList.add(currentStudent);
                }

                input = scanner.nextLine();
            }
            String city = scanner.nextLine();

            for (Student element : studentList) {
                if (element.getCity().equals(city)) {
                    System.out.printf("%s %s is %s years old%n", element.getFirstName(), element.getLastName(), element.getAge());
                }
            }
        }
    }