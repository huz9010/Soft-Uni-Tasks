package ExamFeb2022;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowelsQueue.offer(e.charAt(0)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonantsStack.push(e.charAt(0)));

        LinkedHashMap<String, HashSet<Character>> words = new LinkedHashMap<>();
        words.put("pear", new HashSet<>());
        words.put("flour", new HashSet<>());
        words.put("pork", new HashSet<>());
        words.put("olive", new HashSet<>());

        LinkedHashSet<String> wordsFound = new LinkedHashSet<>();

        while (!consonantsStack.isEmpty())  {

            char vowel = vowelsQueue.poll();
            char consonant = consonantsStack.pop();

            for (Map.Entry<String, HashSet<Character>> word : words.entrySet()) {
                if (word.getKey().contains(String.valueOf(vowel)))  {
                    word.getValue().add(vowel);
                }
                if (word.getKey().contains(String.valueOf(consonant)))  {
                    word.getValue().add(consonant);
                }
            }
            vowelsQueue.offer(vowel);
        }

        for (Map.Entry<String, HashSet<Character>> word : words.entrySet()) {
            if (word.getKey().length() == word.getValue().size())   {
                wordsFound.add(word.getKey());
            }
        }

        int wordCount = wordsFound.size();

        System.out.println("Words found: " + wordCount);
        wordsFound.forEach(System.out::println);
    }
}
