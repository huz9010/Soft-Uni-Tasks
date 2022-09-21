package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("course start"))   {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add":
                    if (!lessons.contains(command[1])) {
                        lessons.add(command[1]);
                    }
                    break;
                case "Insert":
                    if (!lessons.contains(command[1])) {
                        int index = Integer.parseInt(command[2]);
                        lessons.add(index, command[1]);
                    }
                    break;
                case "Remove":
                    if (lessons.contains(command[1]))   {
                        lessons.remove(command[1]);
                        if (lessons.contains(command[1] + "-Exercise")){
                            lessons.remove(command[1] + "-Exercise");
                        }
                    }
                    break;
                case "Swap":
                    if (lessons.contains(command[1]) && lessons.contains(command[2])) {
                        int index1 = 0;
                        int index2 = 0;
                        String lesson1 = "";
                        String lesson2 = "";
                        for (int i = 0; i < lessons.size(); i++) {
                            if (lessons.get(i).equals(command[1])) {
                                index1 = i;
                                lesson1 = lessons.get(i);
                            }
                            if (lessons.get(i).equals(command[2])) {
                                index2 = i;
                                lesson2 = lessons.get(i);
                            }
                        }
                        lessons.set(index1, lesson2);
                        lessons.set(index2, lesson1);
                        if (lessons.contains(lesson1 + "-Exercise"))    {
                            lessons.remove(lesson1 + "-Exercise");
                            lessons.add(index2 + 1, lesson1 + "-Exercise");
                        }
                        if (lessons.contains(lesson2 + "-Exercise"))    {
                            lessons.remove(lesson2 + "-Exercise");
                            lessons.add(index1 + 1, lesson2 + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (lessons.contains(command[1])) {
                        if (!lessons.contains(command[1] + "-Exercise")) {
                            for (int i = 0; i < lessons.size(); i++) {
                                if (lessons.get(i).equals(command[1])) {
                                    lessons.add(i + 1, command[1] + "-Exercise");
                                }
                            }
                        }
                    }
                    else {
                        lessons.add(command[1]);
                        lessons.add(command[1] + "-Exercise");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, lessons.get(i));
        }
    }
}
