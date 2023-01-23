package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Predicate<Integer> isEven = n -> n % 2 ==0;
        List<Integer> nums = Arrays.stream(input.split(", ")).map(Integer::parseInt).filter(isEven).collect(Collectors.toList());

        System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(nums.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
