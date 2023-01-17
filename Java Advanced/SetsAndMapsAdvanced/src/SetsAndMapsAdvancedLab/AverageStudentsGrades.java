package SetsAndMapsAdvancedLab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int studentCount = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsList = new TreeMap<>();

        for (int i = 0; i < studentCount; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

            studentsList.putIfAbsent(name, new ArrayList<>());
            studentsList.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentsList.entrySet()) {
            double grades = 0;
            for (Double grade : entry.getValue()) {
                grades += grade;
            }
            double average = grades / entry.getValue().size();

//            Average with StreamAPI - not working in Judge!!!
//            double average = entry.getValue().stream().mapToDouble(e -> e).average().orElse(0);



            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
