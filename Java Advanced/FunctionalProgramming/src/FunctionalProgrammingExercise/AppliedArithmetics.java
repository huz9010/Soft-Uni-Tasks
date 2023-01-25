package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        UnaryOperator<List<Integer>> add = num -> num.stream().map(n -> n + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = num -> num.stream().map(n -> n - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = num -> num.stream().map(n -> n * 2).collect(Collectors.toList());
        Consumer<List<Integer>> print = n -> n.forEach(number -> System.out.print(number + " "));

        while (!command.equalsIgnoreCase("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown command: " + command);
            }
            command = scanner.nextLine();
        }
    }
}
