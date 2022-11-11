package TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputString = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputString.length; i++) {
            String currentWord = inputString[i];
            for (int j = 0; j < currentWord.length(); j++) {
                result.append(currentWord);
            }
        }
        System.out.println(result);
    }
}
