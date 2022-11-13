package TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            boolean isValid = true;
            String userName = input[i];
            if (userName.length() >= 3 && userName.length() <= 16) {
                for (int j = 0; j < userName.length(); j++) {
                    char currentChar = userName.charAt(j);
                    if (!Character.isLetter(currentChar) && !Character.isDigit(currentChar) && currentChar != '-' && currentChar != '_') {
                        isValid = false;
                    }
                }
            }   else {
                isValid = false;
            }
            if (isValid)    {
                System.out.println(userName);
            }
        }
    }
}
