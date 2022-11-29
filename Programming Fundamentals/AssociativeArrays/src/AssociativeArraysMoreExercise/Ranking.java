package AssociativeArraysMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contestData = new LinkedHashMap<>();
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> users = new LinkedHashMap<>();

        while (!input.equals("end of contests"))    {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestData.put(contest, password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("end of submissions"))  {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            Map<String, Integer> contests = new HashMap<>();

            if (contestData.containsKey(contest) && contestData.containsValue(password))    {

                if (users.containsKey(username))    {

                    if (users.get(username).containsKey(contest))   {

                        if (users.get(username).get(contest) < points)   {
                            users.get(username).put(contest, points);
                        }
                    }   else {
                        users.get(username).put(contest, points);
                    }
                }   else {
                    contests.put(contest, points);
                    users.put(username, contests);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            Map<String, Integer> tempMap = entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            users.put(entry.getKey(), tempMap);
        }
        users = users.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        String best = (String) users.keySet().toArray()[0];
        int bestTotal = 0;
        String bestCandidate = "";

        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            int tempSum = 0;
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                tempSum += entry1.getValue();
            }
            if (bestTotal < tempSum)    {
                bestTotal = tempSum;
                bestCandidate = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestTotal);
        System.out.println("Ranking:");

        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.printf("#  %s -> %d%n", entry1.getKey(), entry1.getValue());
            }
        }
    }
}
