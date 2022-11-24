package FinalExamRetake03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<delimiter>[@\\|#])(?<word1>[A-Za-z]{3,})\\k<delimiter>{2}(?<word2>[A-Za-z]{3,})\\k<delimiter>");
        Matcher matcher = pattern.matcher(input);
        List<String> pairList = new ArrayList<>();
        Map<String, String> mirrorPairs = new LinkedHashMap<>();

        while (matcher.find())  {
        pairList.add(matcher.group());
        }

        if (pairList.isEmpty()) {
            System.out.println("No word pairs found!");
        }   else {
            System.out.println((pairList.size()) + " word pairs found!");
        }

        for (int i = 0; i < pairList.size(); i++) {
            String word1 = pairList.get(i).substring(0, pairList.get(i).length() / 2);
            String word2 = pairList.get(i).substring(word1.length());

            word1 = word1.replaceAll("[#@]", "");
            word2 = word2.replaceAll("[#@]", "");

            StringBuilder reversedWord2 = new StringBuilder(word2).reverse();

            if (word1.equals(reversedWord2.toString()))     {
                mirrorPairs.put(word1, word2);
            }
        }
        if (mirrorPairs.isEmpty())  {
            System.out.println("No mirror words!");
        }   else {
            List<StringBuilder> outputList = new ArrayList<>();
            System.out.println("The mirror words are:");
            for (Map.Entry<String, String> entry : mirrorPairs.entrySet()) {
                StringBuilder output = new StringBuilder();
                output.append(entry.getKey()).append(" <=> ").append(entry.getValue());
                outputList.add(output);
            }
            System.out.println(String.join(", ", outputList));
        }
    }
}
