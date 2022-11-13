package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String word1 = input[0];
        String word2 = input[1];
        int sum = 0;
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                sum += (word1.charAt(i) * word2.charAt(i));
            }
        } else {
            int minLength = Math.min(word1.length(), word2.length());
            for (int i = 0; i < minLength; i++) {
                sum += (word1.charAt(i) * word2.charAt(i));
            }
            if (word1.length() > word2.length()) {
                for (int i = minLength; i < word1.length(); i++) {
                    sum += word1.charAt(i);
                }
            } else {
                for (int i = minLength; i < word2.length(); i++) {
                    sum += word2.charAt(i);
                }
            }
        }
        System.out.println(sum);
    }
}
