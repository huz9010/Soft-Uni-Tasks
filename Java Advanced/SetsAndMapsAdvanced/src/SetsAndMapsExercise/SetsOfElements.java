package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSetLength = scanner.nextInt();
        int secondSetLength = scanner.nextInt();
        scanner.nextLine();

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (Integer num : firstSet) {
            if (secondSet.contains(num))    {
                System.out.print(num + " ");
            }
        }
    }
}
