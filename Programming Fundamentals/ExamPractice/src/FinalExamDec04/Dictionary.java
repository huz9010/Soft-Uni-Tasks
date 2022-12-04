package FinalExamDec04;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordDictionaryList = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());
        Map<String, List<String>> dictionary = new LinkedHashMap<>();

        for (String item : wordDictionaryList) {
            String word = item.split(": ")[0];
            String definition =  item.split(": ")[1];
            List<String> tempList = new ArrayList<>();

            if (dictionary.containsKey(word))   {
                dictionary.get(word).add(definition);
            }   else {
                tempList.add(definition);
                dictionary.put(word, tempList);
            }
        }
        List<String> testList = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        if (command.equals("Test")) {
            for (int i = 0; i < testList.size(); i++) {
                String currentWord = testList.get(i);
                if (dictionary.containsKey(currentWord))    {
                    System.out.printf("%s:%n", currentWord);
                    for (int j = 0; j < dictionary.get(currentWord).size(); j++) {
                        System.out.printf(" -%s%n", dictionary.get(currentWord).get(j));
                    }
                }
            }
        }   else {
            for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
                System.out.printf("%s ",entry.getKey());
            }

        }
    }
}
