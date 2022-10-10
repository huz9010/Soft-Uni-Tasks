package AssociativeArraysExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Double>> studentsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            List<Double> grades = new ArrayList<>();

            if (studentsMap.containsKey(student)) {
                studentsMap.get(student).add(grade);
            } else {
                grades.add(grade);
                studentsMap.put(student, grades);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double sum = 0;
            for (double element : entry.getValue()) {
                sum += element;
            }
            double average = sum / entry.getValue().size();
            if (average >= 4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), average);
            }
        }
    }
}
