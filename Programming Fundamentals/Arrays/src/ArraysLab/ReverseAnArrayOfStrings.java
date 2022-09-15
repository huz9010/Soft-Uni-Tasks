package ArraysLab;

import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length / 2; i++) {
            String oldFirst = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = oldFirst;
        }
        System.out.println(String.join(" ", input));
    }
}
