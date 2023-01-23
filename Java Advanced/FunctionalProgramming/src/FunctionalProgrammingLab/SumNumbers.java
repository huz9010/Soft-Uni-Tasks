package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        System.out.printf("Count = %d%n", Arrays.stream(input).count());
        System.out.printf("Sum = %d", Arrays.stream(input).sum());
    }
}
