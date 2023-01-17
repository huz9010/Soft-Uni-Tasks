package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < studentCount; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            studentsMap.putIfAbsent(name, grades);
            studentsMap.get(name).addAll(grades);
        }

        for (Map.Entry<String, List<Double>> student : studentsMap.entrySet()) {

            double sum = 0;
            double average;

            for (Double grade : student.getValue()) {
                sum += grade;
            }
            average = sum / student.getValue().size();

            System.out.printf("%s is graduated with %f%n", student.getKey(), average);
        }
    }
}
