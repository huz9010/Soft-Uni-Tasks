package TextProcessingMoreExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[] english = {"A", "B", "C","D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashMap<String, String> morseEnglishMap = new LinkedHashMap<>();
        for (int i = 0; i < english.length; i++) {
            morseEnglishMap.put(morse[i], english[i]);
        }
        StringBuilder inputInEnglish = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("|"))   {
                inputInEnglish.append(" ");
            }   else {
                String currentChar = morseEnglishMap.get(input[i]);
                inputInEnglish.append(currentChar);
            }
        }
        System.out.println(inputInEnglish);
    }
}
