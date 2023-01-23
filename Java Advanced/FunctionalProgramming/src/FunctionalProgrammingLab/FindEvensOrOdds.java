package FunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        String oddOrEven = scanner.nextLine();

        IntPredicate predicate = n -> oddOrEven.equalsIgnoreCase("odd") == (n % 2 != 0);

        System.out.println(IntStream.rangeClosed(start, end).filter(predicate).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
