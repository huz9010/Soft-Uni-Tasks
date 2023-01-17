package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSorted = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((i1, i2) -> i2.compareTo(i1))
                .collect(Collectors.toList());

        if (numbersSorted.size() <= 3)  {
            for (Integer num : numbersSorted) {
                System.out.print(num + " ");
            }
        }   else {
            for (int i = 0; i < 3; i++) {
                System.out.print(numbersSorted.get(i) + " ");
            }
        }
    }
}
