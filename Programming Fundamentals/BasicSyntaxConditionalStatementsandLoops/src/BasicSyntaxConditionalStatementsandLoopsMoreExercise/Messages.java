package BasicSyntaxConditionalStatementsandLoopsMoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numCount = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int i = 0; i < numCount; i++) {
            String num = scanner.nextLine();
            int digits = num.length();
            char mainDigit = num.charAt(0);
            int offset = (Integer.parseInt(String.valueOf(mainDigit)) - 2) * 3;

            if (mainDigit == '8' || mainDigit == '9')   {
                offset += 1;
            }
            int index = offset + digits - 1;
            int letterCode = index + 97;

            char letter = (char) letterCode;

            if (mainDigit == '0') {
                letter = (char) (Integer.parseInt(String.valueOf(mainDigit)) + 32);
            }
                message += letter;

        }
        System.out.println(message);
    }
}
