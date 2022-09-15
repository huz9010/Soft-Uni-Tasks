package MethodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char ch1 = scanner.nextLine().charAt(0);
        char ch2 = scanner.nextLine().charAt(0);

        printCharsInRange(ch1, ch2);
    }
    public static void printCharsInRange (char ch1, char ch2) {
        if (ch1 > ch2) {
            char tempChar = ch1;
            ch1 = ch2;
            ch2 = tempChar;
        }
        for (int i = ch1 + 1; i < ch2; i++) {
            char currentChar = (char) i;
            System.out.print(currentChar + " ");
        }
    }
}
