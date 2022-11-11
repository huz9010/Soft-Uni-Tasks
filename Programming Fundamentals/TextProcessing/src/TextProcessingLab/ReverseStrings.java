package TextProcessingLab;

import java.util.Date;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        while (!word.equals("end"))    {
            StringBuilder reversed = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed.append(word.charAt(i));
            }
            System.out.printf("%s = %s%n", word, reversed.toString());
            word = scanner.nextLine();
        }
    }
}
