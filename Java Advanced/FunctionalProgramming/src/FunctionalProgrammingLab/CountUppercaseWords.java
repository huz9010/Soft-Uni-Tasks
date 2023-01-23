package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+")).filter(s -> s.charAt(0) >= 65 && s.charAt(0) <= 90).collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);
    }
}
