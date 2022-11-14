package TextProcessingMoreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();

        int maxChar = Math.max(char1, char2);
        int minChar = Math.min(char1, char2);
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > minChar && input.charAt(i) < maxChar) {
                sum += input.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
