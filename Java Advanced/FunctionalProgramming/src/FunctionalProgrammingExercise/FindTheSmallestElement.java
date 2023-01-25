package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());



        Function<List<Integer>, Integer> findMinElement = n -> {
            int minElement = Integer.MAX_VALUE;
            int minElementIndex = -1;
            for (int i = 0; i < n.size(); i++) {
                if (n.get(i) <= minElement) {
                    minElement = n.get(i);
                    minElementIndex = i;
                }
            }
            return minElementIndex;
        };
        System.out.println(findMinElement.apply(numbers));
    }
}
