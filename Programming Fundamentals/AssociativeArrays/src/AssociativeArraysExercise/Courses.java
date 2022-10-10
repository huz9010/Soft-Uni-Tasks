package AssociativeArraysExercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input.equals("end"))    {
            List<String> students = new ArrayList<>();
            String[] inputCourse = input.split(" : ");
            String currentCourse = inputCourse[0];
            String student = inputCourse[1];
            if (!coursesMap.containsKey(currentCourse))   {
                students.add(student);
                coursesMap.put(currentCourse, students);
            }   else {
                coursesMap.get(currentCourse).add(student);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (String element : entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }
    }
}
