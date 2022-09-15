package MethodsExercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printVowelCount(input);
    }

    public static void printVowelCount(String str){
        int vowelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'o' || letter =='i' || letter == 'u'
            || letter == 'A' || letter == 'E' || letter == 'O' || letter =='I' || letter == 'U'){
                vowelCount++;
            }
        }
        System.out.println(vowelCount);
    }
}
