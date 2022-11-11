package TextProcessingLab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder nums = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder characters = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                nums.append(currentChar);
            } else if (Character.isLetter(currentChar)) {
                letters.append(currentChar);
            }   else {
                characters.append(currentChar);
            }
        }
        System.out.println(nums);
        System.out.println(letters);
        System.out.println(characters);
    }
}
