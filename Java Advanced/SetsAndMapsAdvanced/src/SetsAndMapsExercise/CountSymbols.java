package SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        TreeMap<Character, Integer> letterOccurrences = new TreeMap<>();

        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);
            letterOccurrences.putIfAbsent(currentChar, 0);
            int occurrence = letterOccurrences.get(currentChar);
            occurrence++;
            letterOccurrences.put(currentChar, occurrence);
        }

        for (Map.Entry<Character, Integer> letter : letterOccurrences.entrySet()) {
            System.out.printf("%s: %d time/s%n", letter.getKey(), letter.getValue());
        }
    }
}
