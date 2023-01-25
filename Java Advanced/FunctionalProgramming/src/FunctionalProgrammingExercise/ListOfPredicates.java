package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());
        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> checkNum = n -> {
            for (int d : dividers)  {
                if (n % d != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, range).boxed().filter(checkNum).forEach(e -> System.out.print(e + " "));
    }
}
