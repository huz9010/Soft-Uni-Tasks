package AssociativeArraysMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> contestList = new LinkedHashMap<>();
        Map<String, Integer> userScore = new TreeMap<>();

        while (!input.equals("no more time"))   {
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            Map<String, Integer> userList = new LinkedHashMap<>();

            if (contestList.containsKey(contest))   {
                if (contestList.get(contest).containsKey(username))   {
                    if (contestList.get(contest).get(username) < points)    {
                        contestList.get(contest).put(username, points);
                    }
                }   else {
                    contestList.get(contest).put(username, points);
                }
            }   else {
                userList.put(username, points);
                contestList.put(contest, userList);

            }

            if (userScore.containsKey(username))    {
                int tempSum = userScore.get(username) + points;
                userScore.put(username, tempSum);
            }   else {
                userScore.put(username, points);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : contestList.entrySet()) {
            Map<String, Integer> tempMap = entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            contestList.put(entry.getKey(), tempMap);
        }

        Map<String, Integer> sortedUserScore = userScore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Integer>> entry : contestList.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), contestList.size());
            int i = 1;

            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.printf("%d. %s <::> %d%n", i, entry1.getKey(), entry1.getValue());
                i++;
            }
        }

        System.out.println("Individual standings:");
        int i = 1;
        for (Map.Entry<String, Integer> entry : sortedUserScore.entrySet()) {
            System.out.printf("%d. %s -> %d%n", i, entry.getKey(), entry.getValue());
            i++;
        }
    }
}
