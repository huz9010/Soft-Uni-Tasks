package MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleChars(input);
    }

    public static void printMiddleChars(String input){
        String[] text = input.split("");

        if (text.length % 2 == 0) {
            System.out.print(text[text.length / 2 - 1]);
            System.out.print(text[text.length / 2]);
        }   else {
            System.out.println(text[text.length - text.length / 2 - 1]);
        }
    }
}
