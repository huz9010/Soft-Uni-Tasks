package AssociativeArraysLab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().toLowerCase().split(" ");
        LinkedHashMap<String, Integer> oddCountMap = new LinkedHashMap<>();

        for (String word : words)   {
            if (!oddCountMap.containsKey(word)) {
                oddCountMap.put(word, 1);
            }   else {
                oddCountMap.put(word, oddCountMap.get(word) + 1);
            }
        }
        List<String> oddWordsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : oddCountMap.entrySet()) {
            if (entry.getValue() % 2 == 1)  {
                oddWordsList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddWordsList));
    }
}
