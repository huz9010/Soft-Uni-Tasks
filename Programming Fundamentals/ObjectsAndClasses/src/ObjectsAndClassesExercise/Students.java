package ObjectsAndClassesExercise;

import java.util.*;

public class Students {
    static class Student {
        private String firstName;
        private String lastName;
        private double grade;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public double getGrade() {
            return this.grade;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < studentsCount; i++) {
            String[] currentStudentData = scanner.nextLine().split(" ");
            String firstName = currentStudentData[0];
            String lastName = currentStudentData[1];
            double grade = Double.parseDouble(currentStudentData[2]);
            Student currentStudent = new Student();
            currentStudent.setFirstName(firstName);
            currentStudent.setLastName(lastName);
            currentStudent.setGrade(grade);

            studentList.add(currentStudent);
        }
        studentList.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student student : studentList) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
