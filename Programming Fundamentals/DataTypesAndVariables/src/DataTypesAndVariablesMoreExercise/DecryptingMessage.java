package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte key = Byte.parseByte(scanner.nextLine());
        byte lines = Byte.parseByte(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            char letter = scanner.nextLine().charAt(0);
            char currentLetter = (char) (letter + key);

            System.out.print(currentLetter);
        }
    }
}
