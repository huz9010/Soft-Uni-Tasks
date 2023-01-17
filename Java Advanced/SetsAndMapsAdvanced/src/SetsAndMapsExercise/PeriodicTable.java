package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int compoundsCount = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < compoundsCount; i++) {
            List<String> currentElements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            elements.addAll(currentElements);
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
