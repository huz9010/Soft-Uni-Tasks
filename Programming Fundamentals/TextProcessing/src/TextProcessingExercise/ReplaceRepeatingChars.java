package TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int counter = 0;
            for (int j = i; j < input.length() - 1; j++) {
                if (input.charAt(j) != input.charAt(j + 1)) {
                    break;
                }   else {
                    counter++;
                }
            }
            input.replace(i, i + counter + 1, String.valueOf(currentChar));
        }
        System.out.println(input);
    }
}
