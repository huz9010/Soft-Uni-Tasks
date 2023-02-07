package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lake lake = new Lake(Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).toArray(Integer[]::new));
        String end = scanner.nextLine();

        List<String> result = new ArrayList<>();

        for (Integer number : lake) {
            result.add(String.valueOf(number));
        }

        System.out.println(String.join(", ", result));
    }
}
